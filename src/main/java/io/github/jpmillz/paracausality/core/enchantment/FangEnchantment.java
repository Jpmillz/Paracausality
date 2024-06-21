package io.github.jpmillz.paracausality.core.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.EvokerFangs;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.phys.Vec3;
import org.apache.logging.log4j.core.jmx.Server;

public class FangEnchantment extends Enchantment {
    protected FangEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }




    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        ServerLevel level = ((ServerLevel) pAttacker.level());
        BlockPos position = pTarget.blockPosition();
        float yrot = pAttacker.getYRot();
        if(pLevel == 1){
            EvokerFangs fang = new EvokerFangs(level, position.getX(), yrot, position.getZ(), 90, 1, pAttacker );
            EvokerFangs fang2 = new EvokerFangs(level, position.getX() - 1, yrot, position.getZ() + 1, 0, 1, pAttacker );
            EvokerFangs fang3 = new EvokerFangs(level, position.getX() - 1, yrot, position.getZ() - 1, 0, 1, pAttacker );
            EvokerFangs fang4 = new EvokerFangs(level, position.getX() - 2, yrot, position.getZ() + 1, 0, 3, pAttacker );
            EvokerFangs fang5 = new EvokerFangs(level, position.getX() - 2, yrot, position.getZ() - 1, 0, 3, pAttacker );
            EvokerFangs fang6 = new EvokerFangs(level, position.getX() - 2, yrot, position.getZ() + 1, 0, 3, pAttacker );
            EvokerFangs fang7 = new EvokerFangs(level, position.getX() - 3, yrot, position.getZ()- 1, 0, 7, pAttacker );
            EvokerFangs fang8 = new EvokerFangs(level, position.getX() - 3, yrot, position.getZ()+ 1, 0, 7, pAttacker );
            EvokerFangs fang9 = new EvokerFangs(level, position.getX() - 3, yrot, position.getZ() -1, 0, 7, pAttacker );
            level.addFreshEntity(fang);
            level.addFreshEntity(fang2);
            level.addFreshEntity(fang3);
            level.addFreshEntity(fang4);
            level.addFreshEntity(fang5);
            level.addFreshEntity(fang6);
            level.addFreshEntity(fang7);
            level.addFreshEntity(fang8);
            level.addFreshEntity(fang9);
            pAttacker.sendSystemMessage(Component.literal("This: " + yrot));
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
