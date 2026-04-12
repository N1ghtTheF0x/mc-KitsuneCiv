package ntf.mc.kitsuneciv.entities.ai;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.world.entity.ai.behavior.BehaviorControl;
import net.minecraft.world.entity.ai.behavior.InteractWithDoor;
import net.minecraft.world.entity.ai.behavior.LookAtTargetSink;
import net.minecraft.world.entity.ai.behavior.RandomStroll;
import net.minecraft.world.entity.ai.behavior.Swim;
import ntf.mc.kitsuneciv.entities.KitsuneEntity;

public class KitsuneGoalPackages {
    public static ImmutableList<Pair<Integer,? extends BehaviorControl<? super KitsuneEntity>>> getCorePackage()
    {
        return ImmutableList.of(
            Pair.of(0, new Swim<>(0.8f)),
            Pair.of(0, InteractWithDoor.create()),
            Pair.of(0, new LookAtTargetSink(45, 90))
        );
    }
    public static ImmutableList<Pair<Integer,? extends BehaviorControl<? super KitsuneEntity>>> getIdlePackage()
    {
        return ImmutableList.of(
            Pair.of(0, RandomStroll.stroll(1.0f))
        );
    }
}
