package net.humanturtleduck.meowl.entity.client;


import net.humanturtleduck.meowl.MeowlMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation meowl_layer = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(MeowlMod.MOD_ID, "meowl_layer"), "main");

}