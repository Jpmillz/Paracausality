package io.github.jpmillz.paracausality.core.enchantment;

import io.github.jpmillz.paracausality.core.init.tiers.ModRarity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

import static io.github.jpmillz.paracausality.Paracausality.MODID;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(Registries.ENCHANTMENT, MODID);
    public static final Supplier<Enchantment> FANG = ENCHANTMENTS.register("fang_enchantment", ()-> new FangEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
}
