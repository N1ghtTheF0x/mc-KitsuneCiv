package ntf.mc.kitsuneciv;

import java.util.function.Function;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

public class KitsuneCivItems {
    private static <T extends Item> T register(String name,Function<Item.Properties,T> itemFactory,Item.Properties settings)
    {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, KitsuneCiv.id(name));

        T item = itemFactory.apply(settings.setId(key));

        Registry.register(BuiltInRegistries.ITEM, key, item);

        return item;
    }
    public static final SpawnEggItem KITSUNE_SPAWN_EGG = register(
        "kitsune_spawn_egg",
        SpawnEggItem::new,
        new Item.Properties()
            .spawnEgg(KitsuneCivEntities.KITSUNE)
    );
    public static void register()
    {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS)
            .register(tab -> tab.accept(KITSUNE_SPAWN_EGG));
    }
}
