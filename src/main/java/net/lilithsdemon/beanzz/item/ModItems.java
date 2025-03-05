package net.lilithsdemon.beanzz.item;

import net.lilithsdemon.beanzz.beanzz;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, beanzz.MODID);

    public static final RegistryObject<Item> bean = ITEMS.register("bean", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> beans_can = ITEMS.register("beans_can", () -> new Item(new Item.Properties().food(ModFoods.beans_can)));
    public static final RegistryObject<Item> bread_slice = ITEMS.register("bread_slice", () -> new Item(new Item.Properties().food(ModFoods.bread_slice)));
    public static final RegistryObject<Item> toast_slice = ITEMS.register("toast_slice", () -> new Item(new Item.Properties().food(ModFoods.toast_slice)));
    public static final RegistryObject<Item> beans_on_toast = ITEMS.register("beans_on_toast", () -> new Item(new Item.Properties().food(ModFoods.beans_on_toast)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
