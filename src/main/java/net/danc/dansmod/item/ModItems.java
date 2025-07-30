package net.danc.dansmod.item;

import net.danc.dansmod.dansmod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, dansmod.MOD_ID);

    public static final RegistryObject<Item> PORRIDGE = ITEMS.register("porridge",
            () -> new Item(new Item.Properties()));
public static final RegistryObject<Item> OATS = ITEMS.register("oats",
        () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus ){
        ITEMS.register(eventBus);
    }
}
