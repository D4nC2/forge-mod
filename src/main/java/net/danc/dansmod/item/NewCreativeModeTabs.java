package net.danc.dansmod.item;

import net.danc.dansmod.block.ModdedBlocks;
import net.danc.dansmod.dansmod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NewCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
    DeferredRegister.create(Registries.CREATIVE_MODE_TAB, dansmod.MOD_ID);
    public static final RegistryObject<CreativeModeTab> PORRIDGE_TAB = CREATIVE_MODE_TABS.register("porridge_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.OATS.get()))
                    .title(Component.translatable("creativetab.porridge_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.PORRIDGE.get());
                        pOutput.accept(ModItems.OATS.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModdedBlocks.OAT_BLOCK.get());
                        pOutput.accept(ModdedBlocks.STRAWBERRY_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
