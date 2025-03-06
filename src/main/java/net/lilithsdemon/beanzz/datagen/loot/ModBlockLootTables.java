package net.lilithsdemon.beanzz.datagen.loot;

import net.lilithsdemon.beanzz.block.ModBlocks;
import net.lilithsdemon.beanzz.block.custom.BeanCropBlock;
import net.lilithsdemon.beanzz.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.bean_block.get());

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.bean_crop.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeanCropBlock.AGE, 5));

        this.add(ModBlocks.bean_crop.get(), createCropDrops(ModBlocks.bean_crop.get(), ModItems.bean.get(),
                ModItems.bean.get(), lootitemcondition$builder));
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
