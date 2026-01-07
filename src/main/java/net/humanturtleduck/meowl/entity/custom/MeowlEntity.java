package net.humanturtleduck.meowl.entity.custom;


import net.humanturtleduck.meowl.MeowlMod;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.Nullable;
import net.humanturtleduck.meowl.entity.ModEntities;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;

public class MeowlEntity extends TamableAnimal {
    private float headRotSmoothYaw;
    private float headRotSmoothPitch;
    private static final float HEAD_ROT_SPEED = 5.0f; // Adjust for smoothness

    public MeowlEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData(); // Handles tame, owner, sitting automatically
    }





    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {

        if (this.isOrderedToSit()) {
            sitAnimationState.start(this.tickCount);
            idleAnimationState.stop();
            return;
        }

        sitAnimationState.stop();

        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateWalkAnimation(float partialTick) {
        if (this.isOrderedToSit()) {
            this.walkAnimation.update(0f, 0f);
            return;
        }

        float f = this.getPose() == Pose.STANDING
                ? Math.min(partialTick * 6F, 1f)
                : 0f;

        this.walkAnimation.update(f, 0.2f);
    }

    public final AnimationState sitAnimationState = new AnimationState();
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source == this.damageSources().fall()) {
            return false;
        }
        return super.hurt(source, amount);
    }
    //ai of the entity
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        // Sit ALWAYS has highest priority when ordered
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));

        // Follow owner - but SKIP if sitting
        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.1D, 10.0F, 2.0F, false) {
            @Override
            public boolean canUse() {
                return super.canUse() && !MeowlEntity.this.isOrderedToSit();
            }
        });

        // Other goals skip sitting too
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.15D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(Items.CHICKEN), false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.1D) {
            @Override
            public boolean canUse() {
                return super.canUse() && !MeowlEntity.this.isOrderedToSit();
            }
        });
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 5f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    @Override
    public boolean isImmobile() {
        return this.isOrderedToSit();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 5D)
                .add(Attributes.FOLLOW_RANGE,24D)
                .add(Attributes.MOVEMENT_SPEED, .25D);
    }
    public static SpawnPlacements.SpawnPredicate<MeowlEntity> createSpawnPredicate() {
        return (type, world, spawnType, pos, random) ->
                world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)
                        && world.getRawBrightness(pos, 0) > 8;
    }
    // Change return type
    @Nullable
    @Override
    public MeowlEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.MEOWL.get().create(pLevel);
    }
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack item = player.getItemInHand(hand);
        if (item.is(Items.APPLE)) {
            if (!this.level().isClientSide && !this.isTame()) {
                if (!ForgeEventFactory.onAnimalTame(this, player)) {
                    this.tame(player);
                    this.level().broadcastEntityEvent(this, (byte)7);
                    this.setOrderedToSit(true);
                    item.shrink(1);
                    return InteractionResult.SUCCESS;
                }
            }
        } else if (this.isTame() && player == this.getOwner()) {
            this.setOrderedToSit(!this.isOrderedToSit()); // Toggle sit
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    public boolean canBeLeashed(Player player) {
        return true;
    }
    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return !this.isTame();
    }


    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.CHICKEN);

    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.CAT_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.CAT_HURT;
    }


    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.CAT_DEATH;
    }
}