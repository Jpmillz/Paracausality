package io.github.jpmillz.paracausality.core.init;

import io.github.jpmillz.paracausality.Paracausality;
import io.github.jpmillz.paracausality.core.data.util.ModTags;
import io.github.jpmillz.paracausality.core.init.tiers.ModRarity;
import io.github.jpmillz.paracausality.core.init.tiers.ModTiers;
import io.github.jpmillz.paracausality.core.items.PaxelItem;
import io.github.jpmillz.paracausality.core.items.StaffItem;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Paracausality.MODID);

    public static final DeferredItem<Item> COSMIC_CORE = ITEMS.register("cosmic_core", ()-> new Item(
            new Item.Properties()
            .rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> ANDROMALITE_INGOT = ITEMS.register("andromalite_ingot", ()-> new Item(new Item.Properties()
            .fireResistant()
            ));
    public static final DeferredItem<PaxelItem> ANDROMALITE_PAXEL = ITEMS.register("andromalite_paxel",
            ()-> new PaxelItem(6.0f,4.0f, ModTiers.ANDROMALITE, ModTags.Blocks.MINEABLE_WITH_PAXEL, new Item.Properties()
                    .durability(2000)));
    public static final DeferredItem<SwordItem> ANDROMALITE_SWORD = ITEMS.register("andromalite_sword", ()-> new SwordItem(ModTiers.ANDROMALITE, 4,3, new Item.Properties()
            .rarity(ModRarity.EXOTIC)
            .durability(5400)
            .fireResistant()
    ));
    public static final DeferredItem<StaffItem> HEROS_STAFF = ITEMS.register("heros_staff", () -> new StaffItem(new Item.Properties()
            .rarity(ModRarity.EXOTIC)
            .fireResistant()
            .stacksTo(1)
            .durability(10)
    ));
}
