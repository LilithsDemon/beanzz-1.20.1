package net.lilithsdemon.beanzz.datagen;

import net.lilithsdemon.beanzz.beanzz;
import net.lilithsdemon.beanzz.block.ModBlocks;
import net.lilithsdemon.beanzz.block.custom.BeanCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, beanzz.MODID, exFileHelper);
    }


    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.bean_block);

        makeBeanCrop((CropBlock) ModBlocks.bean_crop.get(), "bean_stage", "bean_stage");
    }

    public void makeBeanCrop(CropBlock block, String modelName, String textureName)
    {
        Function<BlockState, ConfiguredModel[]> function = state -> beanCropStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] beanCropStates(BlockState state, CropBlock block, String modelName, String textureName){
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((BeanCropBlock) block).getAgeProperty()),
                new ResourceLocation(beanzz.MODID, "block/" + textureName + state.getValue(((BeanCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
