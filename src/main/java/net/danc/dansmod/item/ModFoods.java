package net.danc.dansmod.item;

import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties  PORRIDGE =  new FoodProperties.Builder().nutrition(8)
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 2), 1f).build();
}
