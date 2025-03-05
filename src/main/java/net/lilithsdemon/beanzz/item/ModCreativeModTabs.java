package net.lilithsdemon.beanzz.item;

import net.lilithsdemon.beanzz.beanzz;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, beanzz.MODID);

    public static final RegistryObject<CreativeModeTab> BEANZZ_TAB = CREATIVE_MODE_TABS.register("beanzz_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.beans_can.get()))
                    .title(Component.translatable("creativetab.beanzz_tab"))
                    .displayItems((itemDisplayParameters, output) ->
                    {
                        output.accept(ModItems.bean.get());
                        output.accept(ModItems.beans_can.get());
                        output.accept(ModItems.bread_slice.get());
                        output.accept(ModItems.toast_slice.get());
                        output.accept(ModItems.beans_on_toast.get());
                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
