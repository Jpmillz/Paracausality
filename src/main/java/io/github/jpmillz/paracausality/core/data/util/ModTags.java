package io.github.jpmillz.paracausality.core.data.util;

import io.github.jpmillz.paracausality.Paracausality;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> MINEABLE_WITH_PAXEL = tag("mineable_with_paxel");
        public static final TagKey<Block> NEEDS_ANDROMALITE_TOOL = tag("needs_andromalite_tool");


        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(Paracausality.MODID, name));
        }
    }

    public static class Items{
        private static final TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(Paracausality.MODID, name));
        }



    }

}
