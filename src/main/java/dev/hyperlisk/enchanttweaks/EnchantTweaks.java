package dev.hyperlisk.enchanttweaks;

import dev.hyperlisk.enchanttweaks.blocks.ModBlocks;
import dev.hyperlisk.enchanttweaks.blocks.XperiumBlock;
import dev.hyperlisk.enchanttweaks.setup.ClientProxy;
import dev.hyperlisk.enchanttweaks.setup.IProxy;
import dev.hyperlisk.enchanttweaks.setup.ServerProxy;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("enchanttweaks")
public class EnchantTweaks
{

    public static IProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public EnchantTweaks() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

    }

    private void setup(final FMLCommonSetupEvent event)
    {

        proxy.getClientWorld();

    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> event) {

            event.getRegistry().register(new XperiumBlock());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {

            event.getRegistry().register(new BlockItem(ModBlocks.XPERIUMBLOCK, new Item.Properties()).setRegistryName("xperiumblock"));
        }
    }

}
