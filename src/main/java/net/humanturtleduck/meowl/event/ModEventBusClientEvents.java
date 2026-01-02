package net.humanturtleduck.meowl.event;

import net.humanturtleduck.meowl.MeowlMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.humanturtleduck.meowl.entity.client.ModModelLayers;
import net.humanturtleduck.meowl.entity.client.MeowlModel;

@Mod.EventBusSubscriber(modid = MeowlMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.meowl_layer, MeowlModel::createBodyLayer);
    }
}