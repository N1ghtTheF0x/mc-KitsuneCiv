package ntf.mc.kitsuneciv.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import ntf.mc.kitsuneciv.KitsuneCiv;
import ntf.mc.kitsuneciv.KitsuneCivEntities;
import ntf.mc.kitsuneciv.client.renderer.KitsuneEntityRenderer;

public class KitsuneCivEntityRenderers {
    private static <T extends Entity> void register(EntityType<T> type,EntityRendererProvider<T> renderer)
    {
        EntityRenderers.register(type, renderer);
        KitsuneCiv.LOGGER.info("registered entity renderer for " + type.getDescriptionId());
    }
    public static void register()
    {
        register(KitsuneCivEntities.KITSUNE,KitsuneEntityRenderer::new);
    }
}
