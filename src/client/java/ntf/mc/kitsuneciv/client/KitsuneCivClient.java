package ntf.mc.kitsuneciv.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import ntf.mc.kitsuneciv.KitsuneCivEntities;
import ntf.mc.kitsuneciv.client.renderer.KitsuneEntityRenderer;

public class KitsuneCivClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		KitsuneCivModelLayers.register();
		EntityRenderers.register(KitsuneCivEntities.KITSUNE, KitsuneEntityRenderer::new);
	}
}