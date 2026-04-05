package ntf.mc.kitsuneciv.client.data;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import ntf.mc.kitsuneciv.KitsuneCivItems;

public class KitsuneCivModelProvider extends FabricModelProvider {
    public KitsuneCivModelProvider(FabricPackOutput dataOutput)
    {
        super(dataOutput);
    }
    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        
    }
    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(KitsuneCivItems.KITSUNE_SPAWN_EGG,ModelTemplates.FLAT_ITEM);
    }
    @Override
    public String getName() {
        return "KitsuneCivModelProvider";
    }
}
