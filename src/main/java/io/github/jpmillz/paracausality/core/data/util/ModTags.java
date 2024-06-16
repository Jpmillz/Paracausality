package io.github.jpmillz.paracausality.core.data.util;

import io.github.jpmillz.paracausality.Paracausality;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> MINEABLE_WITH_PAXEL = tag("mineable_with_paxel");


        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(Paracausality.MODID, name));
        }
    }
}
