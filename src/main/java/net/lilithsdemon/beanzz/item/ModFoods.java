package net.lilithsdemon.beanzz.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties beans_can = new FoodProperties.Builder().nutrition(8)
            .saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 0.5f)
            .build();

    public static final FoodProperties bread_slice = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f)
            .build();

    public static final FoodProperties toast_slice = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.3f)
            .build();

    public static final FoodProperties beans_on_toast = new FoodProperties.Builder().nutrition(12)
            .saturationMod(1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200), 0.8f)
            .build();
}