package ntf.mc.kitsuneciv;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KitsuneCiv implements ModInitializer {
	public static final String MOD_ID = "kitsuneciv";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Identifier id(String name)
	{
		return Identifier.fromNamespaceAndPath(MOD_ID,name);
	}
	@Override
	public void onInitialize() {
		KitsuneCivEntities.register();
		KitsuneCivItems.register();
	}
}