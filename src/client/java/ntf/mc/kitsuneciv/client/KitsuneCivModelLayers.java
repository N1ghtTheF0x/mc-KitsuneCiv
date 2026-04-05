package ntf.mc.kitsuneciv.client;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import ntf.mc.kitsuneciv.KitsuneCiv;
import ntf.mc.kitsuneciv.client.models.KitsuneEntityModel;

public class KitsuneCivModelLayers {
    private static ModelLayerLocation createLayerLocation(String name,String layer)
    {
        return new ModelLayerLocation(KitsuneCiv.id(name), layer);
    }
    public static final ModelLayerLocation KITSUNE = createLayerLocation("kitsune", "main");
    public static void register()
    {
        ModelLayerRegistry.registerModelLayer(KITSUNE, KitsuneEntityModel::getTextureModelData);
    }
}
