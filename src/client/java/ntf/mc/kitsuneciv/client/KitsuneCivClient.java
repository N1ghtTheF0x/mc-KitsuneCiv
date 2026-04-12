package ntf.mc.kitsuneciv.client;

import net.fabricmc.api.ClientModInitializer;

public class KitsuneCivClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		KitsuneCivModelLayers.register();
		KitsuneCivEntityRenderers.register();
	}
}