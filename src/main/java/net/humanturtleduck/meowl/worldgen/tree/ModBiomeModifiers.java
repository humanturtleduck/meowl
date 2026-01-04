package net.humanturtleduck.meowl.worldgen.tree;

import net.humanturtleduck.meowl.MeowlMod;
import net.humanturtleduck.meowl.entity.ModEntities;
import net.minecraft.core.HolderSet;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.common.world.ForgeBiomeModifiers;


import java.util.List;



public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> SPAWN_MEOWL = registerKey("spawn_meowl");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);


        context.register(SPAWN_MEOWL, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.BIRCH_FOREST)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MEOWL.get(), 25, 2, 4))));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MeowlMod.MOD_ID, name));
    }
}