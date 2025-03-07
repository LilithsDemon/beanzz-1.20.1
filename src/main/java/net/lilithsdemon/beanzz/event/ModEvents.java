package net.lilithsdemon.beanzz.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.lilithsdemon.beanzz.beanzz;
import net.lilithsdemon.beanzz.item.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.List;

@Mod.EventBusSubscriber(modid = beanzz.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event)
    {
        if(event.getType() == VillagerProfession.FARMER)
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.bean.get(), 4),
                    10,
                    16,
                    0.02f
            ));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.IRON_INGOT, 2),
                    new ItemStack(ModItems.bean.get(), 4),
                    10,
                    8,
                    0.02f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.IRON_INGOT, 2),
                    new ItemStack(ModItems.beans_can.get(), 1),
                    10,
                    32,
                    0.02f
            ));
        }
    }

    @SubscribeEvent
    public static void addCusstomWanderingTrades(WandererTradesEvent event)
    {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModItems.bean.get(), 4),
                10,
                16,
                0.02f
        ));

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.IRON_INGOT, 2),
                new ItemStack(ModItems.bean.get(), 4),
                10,
                8,
                0.02f
        ));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.IRON_INGOT, 2),
                new ItemStack(ModItems.beans_can.get(), 1),
                10,
                32,
                0.02f
        ));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.DIAMOND, 2),
                new ItemStack(ModItems.bean.get(), 32),
                2,
                16,
                0.02f
        ));
    }
}
