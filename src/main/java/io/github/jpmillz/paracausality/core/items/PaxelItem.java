package io.github.jpmillz.paracausality.core.items;

import io.github.jpmillz.paracausality.core.data.util.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;

import java.util.Map;

public class PaxelItem extends DiggerItem {

    public PaxelItem(float pAttackDamageModifier, float pAttackSpeedModifier, Tier pTier, TagKey<Block> pBlocks, Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, ModTags.Blocks.MINEABLE_WITH_PAXEL, pProperties);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ToolAction toolAction) {
        return net.neoforged.neoforge.common.ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction);

    }

}
