package io.github.jpmillz.paracausality.core.items;

import io.github.jpmillz.paracausality.Paracausality;
import io.github.jpmillz.paracausality.core.init.ItemInit;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class StaffItem extends Item {

    public StaffItem(Properties pProperties) {
        super(pProperties);

    }

    //On left click use
    @Override
    public InteractionResultHolder use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        int displayDamage = pPlayer.getItemInHand(pUsedHand).getMaxDamage() - pPlayer.getItemInHand(pUsedHand).getDamageValue() - 1;
        pPlayer.getCooldowns().addCooldown(ItemInit.HEROS_STAFF.get(), 70);
        if (!pLevel.isClientSide) {
            AreaEffectCloud cloud = new AreaEffectCloud(pLevel, pPlayer.getX(), pPlayer.getY() + 0.1f, pPlayer.getZ());
            cloud.setDuration(15);
            cloud.addEffect(new MobEffectInstance(MobEffects.HEAL, 300, 4));
            cloud.setRadius(10);
            cloud.setParticle(ParticleTypes.CRIMSON_SPORE);
            pLevel.playSound((Player) null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.PLAYERS,
                    4.0f, 1.0f);
            pLevel.addFreshEntity(cloud);
            pPlayer.sendSystemMessage(Component.literal("§c§oHealing Cloud Activated"));
            itemStack.hurtAndBreak(1, pPlayer, e -> e.broadcastBreakEvent(pUsedHand));
        }
        if (pLevel.isClientSide) {
            if (itemStack.getDamageValue() >= itemStack.getMaxDamage() - 3 && !(itemStack.getDamageValue() + 1 == itemStack.getMaxDamage())) {
                pPlayer.sendSystemMessage(Component.literal("Critical Durability, " + displayDamage + " Spell(s) Left!"));
            }
        }
        return InteractionResultHolder.sidedSuccess(itemStack, pLevel.isClientSide);
    }
}

//return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));




        //Using the staff on a block
    /*
    @Override
    public InteractionResult useOn(UseOnContext player){
        Item item = player.getItemInHand().getItem();
        Level level = player.getLevel();
        Position pos = player.getPlayer().position();
        player.getPlayer().getCooldowns().addCooldown(ItemInit.HEROS_STAFF.get(), 200);
        if(item == ItemInit.HEROS_STAFF.get()){
            if(!level.isClientSide){
                AreaEffectCloud cloud = new AreaEffectCloud(level, pos.x(), pos.y() + 0.2f, pos.z());
                cloud.setDuration(15);
                cloud.addEffect(new MobEffectInstance(MobEffects.HEAL,200, 4));
                cloud.setRadius(10);
                cloud.setParticle(ParticleTypes.INSTANT_EFFECT);
                level.addFreshEntity(cloud);
            }
        }

        return InteractionResult.SUCCESS;
    }
*/

