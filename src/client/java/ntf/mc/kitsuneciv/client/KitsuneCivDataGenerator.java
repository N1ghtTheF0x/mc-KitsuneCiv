package ntf.mc.kitsuneciv.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import ntf.mc.kitsuneciv.client.data.KitsuneCivModelProvider;
import ntf.mc.kitsuneciv.client.data.lang.KitsuneCivEnglishLangProvider;

public class KitsuneCivDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(KitsuneCivModelProvider::new);
		//pack.addProvider(KitsuneCivEnglishLangProvider::new);
	}
}
