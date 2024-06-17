package io.github.jpmillz.paracausality.core.items;

import com.google.common.collect.Sets;
import com.mojang.realmsclient.client.Request;
import io.github.jpmillz.paracausality.core.data.util.ModTags;
import net.minecraft.Util;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.collect.ImmutableSet.of;
import static net.neoforged.neoforge.common.ToolActions.*;

public class PaxelItem extends DiggerItem {
    private static final Set<ToolAction> DEFAULT_PAXEL_ACTIONS = Util.make(Collections.newSetFromMap(new IdentityHashMap<>()), actions -> {
        actions.addAll(DEFAULT_AXE_ACTIONS);
        actions.addAll(DEFAULT_HOE_ACTIONS);
        actions.addAll(DEFAULT_SHEARS_ACTIONS);
        actions.addAll(DEFAULT_SHOVEL_ACTIONS);
    });

    public PaxelItem(float pAttackDamageModifier, float pAttackSpeedModifier, Tier pTier, TagKey<Block> pBlocks, Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, ModTags.Blocks.MINEABLE_WITH_PAXEL, pProperties);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ToolAction toolAction) {
        return DEFAULT_PAXEL_ACTIONS.contains(toolAction);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        //Shovel Logic Copied From Minecraft ShovelItem Class
        if (pContext.getClickedFace() == Direction.DOWN) {
            return InteractionResult.PASS;
        } else {
            Player player = pContext.getPlayer();
            BlockState blockstate1 = blockstate.getToolModifiedState(pContext, SHOVEL_FLATTEN, false);
            BlockState blockstate2 = null;
            if (blockstate1 != null && level.getBlockState(blockpos.above()).isAir()) {
                level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                blockstate2 = blockstate1;
            } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT)) {
                if (!level.isClientSide()) {
                    level.levelEvent(null, 1009, blockpos, 0);
                }

                CampfireBlock.dowse(pContext.getPlayer(), level, blockpos, blockstate);
                blockstate2 = blockstate.setValue(CampfireBlock.LIT, Boolean.valueOf(false));
            }
            if (blockstate2 != null) {
                if (!level.isClientSide) {
                    level.setBlock(blockpos, blockstate2, 11);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, blockstate2));
                    if (player != null) {
                        pContext.getItemInHand().hurtAndBreak(1, player, p_43122_ -> p_43122_.broadcastBreakEvent(pContext.getHand()));
                    }
                }
            }
        }
        //Axe Logic Copied from Minecraft AxeItem Class
        Player player = pContext.getPlayer();
        Optional<BlockState> optional = this.evaluateNewBlockState(level, blockpos, player, level.getBlockState(blockpos), pContext);
        if (optional.isEmpty()) {
            return InteractionResult.PASS;
        } else {
            ItemStack itemstack = pContext.getItemInHand();
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockpos, itemstack);
            }

            level.setBlock(blockpos, optional.get(), 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional.get()));
            if (player != null) {
                itemstack.hurtAndBreak(1, player, p_150686_ -> p_150686_.broadcastBreakEvent(pContext.getHand()));

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    private Optional<BlockState> evaluateNewBlockState(Level level, BlockPos blockpos, @Nullable Player player, BlockState blocksstate, UseOnContext p_40529_) {
        Optional<BlockState> optional = Optional.ofNullable(blocksstate.getToolModifiedState(p_40529_, net.neoforged.neoforge.common.ToolActions.AXE_STRIP, false));
        if (optional.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            return optional;
        } else {
            Optional<BlockState> optional1 = Optional.ofNullable(blocksstate.getToolModifiedState(p_40529_, net.neoforged.neoforge.common.ToolActions.AXE_SCRAPE, false));
            if (optional1.isPresent()) {
                level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3005, blockpos, 0);
                return optional1;
            } else {
                Optional<BlockState> optional2 = Optional.ofNullable(blocksstate.getToolModifiedState(p_40529_, net.neoforged.neoforge.common.ToolActions.AXE_WAX_OFF, false));
                if (optional2.isPresent()) {
                    level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.levelEvent(player, 3004, blockpos, 0);
                    return optional2;
                } else {
                    return Optional.empty();
                }
            }
        }
    }
}



