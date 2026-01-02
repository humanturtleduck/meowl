package net.humanturtleduck.meowl.event;

import net.humanturtleduck.meowl.MeowlMod;
import net.humanturtleduck.meowl.entity.custom.MeowlEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.humanturtleduck.meowl.entity.ModEntities;

@Mod.EventBusSubscriber(modid = MeowlMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MEOWL.get(), MeowlEntity.createAttributes().build());
    }
}