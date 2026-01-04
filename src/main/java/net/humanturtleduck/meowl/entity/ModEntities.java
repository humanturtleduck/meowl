package net.humanturtleduck.meowl.entity;

import net.humanturtleduck.meowl.MeowlMod;
import net.humanturtleduck.meowl.entity.custom.MeowlEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.levelgen.Heightmap;





public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MeowlMod.MOD_ID);

    public static final RegistryObject<EntityType<MeowlEntity>> MEOWL =
            ENTITY_TYPES.register("meowl", () -> EntityType.Builder.of(MeowlEntity::new, MobCategory.CREATURE)
                    .sized(.5f, .5f).clientTrackingRange(10).updateInterval(3)
                    .build("meowl"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}