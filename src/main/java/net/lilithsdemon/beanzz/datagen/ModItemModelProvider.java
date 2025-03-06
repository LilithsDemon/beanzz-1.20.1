package net.lilithsdemon.beanzz.datagen;

import net.lilithsdemon.beanzz.beanzz;
import net.lilithsdemon.beanzz.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, beanzz.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.bean);
        simpleItem(ModItems.beans_can);
        simpleItem(ModItems.beans_on_toast);
        simpleItem(ModItems.bread_slice);
        simpleItem(ModItems.toast_slice);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(beanzz.MODID, "item/" + item.getId().getPath()));
    }
}
