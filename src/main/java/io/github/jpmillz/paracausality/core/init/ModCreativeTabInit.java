package io.github.jpmillz.paracausality.core.init;

import io.github.jpmillz.paracausality.Paracausality;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.github.jpmillz.paracausality.Paracausality.MODID;

public class ModCreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final Supplier<CreativeModeTab> PARACAUSALITY_TAB = CREATIVE_MODE_TABS.register("paracausality", ()-> CreativeModeTab.builder()
            .title(Component.translatable("tab.paracausality"))
            .icon(()-> new ItemStack(ItemInit.ANDROMALITE_PAXEL.get()))
            .withLabelColor(11141290)
            .displayItems(((pParameters, pOutput) -> {
                pOutput.accept(ItemInit.ANDROMALITE_INGOT.get());
                pOutput.accept(ItemInit.ANDROMALITE_PAXEL.get());
                pOutput.accept(ItemInit.COSMIC_CORE.get());
                pOutput.accept(ItemInit.ANDROMALITE_SWORD.get());
            }))
            .build());

}
