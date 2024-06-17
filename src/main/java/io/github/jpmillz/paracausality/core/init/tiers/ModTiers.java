package io.github.jpmillz.paracausality.core.init.tiers;

import io.github.jpmillz.paracausality.core.data.util.ModTags;
import io.github.jpmillz.paracausality.core.init.ItemInit;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModTiers {
    public static final Tier ANDROMALITE = new SimpleTier(5, 5400, 10.0f,4.5f,22, ModTags.Blocks.NEEDS_ANDROMALITE_TOOL,
            ()-> Ingredient.of(ItemInit.ANDROMALITE_INGOT.get()));



}
