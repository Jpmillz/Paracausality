package io.github.jpmillz.paracausality.core.init;

import io.github.jpmillz.paracausality.Paracausality;
import io.github.jpmillz.paracausality.core.data.util.ModTags;
import io.github.jpmillz.paracausality.core.items.PaxelItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.swing.text.html.HTML;
import javax.tools.Tool;
import java.util.function.Supplier;

public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Paracausality.MODID);

    public static final DeferredItem<Item> COSMIC_CORE = ITEMS.register("cosmic_core", ()-> new Item(
            new Item.Properties()
            .rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> ANDROMALITE_INGOT = ITEMS.register("andromalite_ingot", ()-> new Item(new Item.Properties()
            .fireResistant()
            ));
    public static final DeferredItem<PaxelItem> ANDROMALITE_PAXEL = ITEMS.register("andromalite_paxel",
            ()-> new PaxelItem(7.0f,10.0f, Tiers.NETHERITE, ModTags.Blocks.MINEABLE_WITH_PAXEL, new Item.Properties()
                    .durability(2000)));{
        }

}
