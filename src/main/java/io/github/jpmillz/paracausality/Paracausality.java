package io.github.jpmillz.paracausality;

import com.mojang.logging.LogUtils;
import io.github.jpmillz.paracausality.core.enchantment.ModEnchantments;
import io.github.jpmillz.paracausality.core.init.ItemInit;
import io.github.jpmillz.paracausality.core.init.ModCreativeTabInit;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;


@Mod(Paracausality.MODID)

public class Paracausality {
    public static final String MODID = "paracausality";

    private static final Logger LOGGER = LogUtils.getLogger();

    public Paracausality(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);

        ModEnchantments.ENCHANTMENTS.register(modEventBus);

        ModCreativeTabInit.CREATIVE_MODE_TABS.register(modEventBus);

        ItemInit.ITEMS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
