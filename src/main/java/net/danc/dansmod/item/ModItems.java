package net.danc.dansmod.item;

import net.danc.dansmod.dansmod;
import net.danc.dansmod.item.custom.metaldetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, dansmod.MOD_ID);

    public static final RegistryObject<Item> PORRIDGE = ITEMS.register("porridge",
            () -> new Item(new Item.Properties().food(ModFoods.PORRIDGE)));
public static final RegistryObject<Item> OATS = ITEMS.register("oats",
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new metaldetectorItem(new Item.Properties().stacksTo(1).durability(128)));
    public static void register(IEventBus eventBus ){
        ITEMS.register(eventBus);
    }
}
