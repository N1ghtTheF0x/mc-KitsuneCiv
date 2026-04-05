package ntf.mc.kitsuneciv.client.data.lang;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import ntf.mc.kitsuneciv.KitsuneCivEntities;
import ntf.mc.kitsuneciv.KitsuneCivItems;

public class KitsuneCivEnglishLangProvider extends FabricLanguageProvider {
    protected KitsuneCivEnglishLangProvider(FabricPackOutput dataOutput,CompletableFuture<HolderLookup.Provider> registryLookup)
    {
        super(dataOutput,"en_us",registryLookup);
    }
    @Override
    public void generateTranslations(Provider registryLookup, TranslationBuilder translationBuilder)
    {
        translationBuilder.add(KitsuneCivEntities.KITSUNE,"Kitsune");
        translationBuilder.add(KitsuneCivItems.KITSUNE_SPAWN_EGG,"Kitsune Spawn Egg");
    }
}
