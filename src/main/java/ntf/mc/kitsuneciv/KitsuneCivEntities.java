package ntf.mc.kitsuneciv;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import ntf.mc.kitsuneciv.entities.KitsuneEntity;

public class KitsuneCivEntities {
    private static <T extends Entity> EntityType<T> register(String name,EntityType.Builder<T> builder)
    {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, KitsuneCiv.id(name));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }
    public static final EntityType<KitsuneEntity> KITSUNE = register("kitsune",
        EntityType.Builder.<KitsuneEntity>of(KitsuneEntity::new,MobCategory.MISC)
        .eyeHeight(1.7f)
    );
    public static void register()
    {
        FabricDefaultAttributeRegistry.register(KITSUNE, KitsuneEntity.createAttributes());
    }
}
