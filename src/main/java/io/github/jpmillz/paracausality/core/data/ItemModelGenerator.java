package io.github.jpmillz.paracausality.core.data;

import io.github.jpmillz.paracausality.Paracausality;
import io.github.jpmillz.paracausality.core.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.apache.logging.log4j.core.util.NameUtil;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Paracausality.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ItemInit.ANDROMALITE_SWORD.getId().getPath(), mcLoc("item/handheld")).texture("layer0", "item/andromalite_sword");
        withExistingParent(ItemInit.ANDROMALITE_PAXEL.getId().getPath(), mcLoc("item/handheld")).texture("layer0","item/andromalite_paxel");

    }
}





