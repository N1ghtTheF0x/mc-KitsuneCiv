package ntf.mc.kitsuneciv.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import ntf.mc.kitsuneciv.KitsuneCiv;
import ntf.mc.kitsuneciv.client.KitsuneCivModelLayers;
import ntf.mc.kitsuneciv.client.models.KitsuneEntityModel;
import ntf.mc.kitsuneciv.client.states.KitsuneEntityRenderState;
import ntf.mc.kitsuneciv.entities.KitsuneEntity;

public class KitsuneEntityRenderer extends MobRenderer<KitsuneEntity,KitsuneEntityRenderState,KitsuneEntityModel> {
    private static final Identifier TEXTURE = KitsuneCiv.id("textures/entity/kitsune.png");
    public KitsuneEntityRenderer(EntityRendererProvider.Context context)
    {
        super(context, new KitsuneEntityModel(context.bakeLayer(KitsuneCivModelLayers.KITSUNE)),0.5f);
    }
    @Override
    public KitsuneEntityRenderState createRenderState()
    {
        return new KitsuneEntityRenderState();
    }
    @Override
    public Identifier getTextureLocation(KitsuneEntityRenderState state) {
        return TEXTURE;
    }
}
