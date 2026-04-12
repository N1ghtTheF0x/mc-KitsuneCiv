package ntf.mc.kitsuneciv.client;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry.TexturedLayerDefinitionProvider;
import net.minecraft.client.model.geom.ModelLayerLocation;
import ntf.mc.kitsuneciv.KitsuneCiv;
import ntf.mc.kitsuneciv.client.models.KitsuneEntityModel;

public class KitsuneCivModelLayers {
    private static ModelLayerLocation register(String name,String layer,TexturedLayerDefinitionProvider provider)
    {
        ModelLayerLocation location = new ModelLayerLocation(KitsuneCiv.id(name), layer);
        KitsuneCiv.LOGGER.info("registering model layer '" + layer + "' for " + name);
        ModelLayerRegistry.registerModelLayer(location, provider);
        return location;
    }
    public static final ModelLayerLocation KITSUNE = register("kitsune", "main", KitsuneEntityModel::getTextureModelData);
    public static void register()
    {
        
    }
}
