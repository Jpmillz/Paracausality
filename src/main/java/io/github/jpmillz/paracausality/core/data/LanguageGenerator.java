package io.github.jpmillz.paracausality.core.data;

import io.github.jpmillz.paracausality.Paracausality;
import io.github.jpmillz.paracausality.core.init.ItemInit;
import io.github.jpmillz.paracausality.core.init.ModCreativeTabInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class LanguageGenerator extends LanguageProvider {


    public LanguageGenerator(PackOutput output) {
        super(output, Paracausality.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(ItemInit.COSMIC_CORE, "Cosmic Core");
        addItem(ItemInit.ANDROMALITE_INGOT, "Andromalite Ingot");
        addItem(ItemInit.ANDROMALITE_SWORD, "Andromalite Sword");
        addItem(ItemInit.ANDROMALITE_PAXEL, "Andromalite Paxel");
        add("tab.paracausality", "Paracausality");


    }
}

