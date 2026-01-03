package net.humanturtleduck.meowl.item.Custom;

import net.humanturtleduck.meowl.MeowlMod;
import net.humanturtleduck.meowl.entity.ModEntities;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MeowlMod.MOD_ID);

    public static final RegistryObject<Item> MEOWL_SPAWN_EGG = ITEMS.register("meowl_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MEOWL, 0xA8A8A8, 0xFFFF99, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}