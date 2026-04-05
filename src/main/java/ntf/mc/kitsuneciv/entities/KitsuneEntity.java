package ntf.mc.kitsuneciv.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import ntf.mc.kitsuneciv.KitsuneCivEntities;

public class KitsuneEntity extends PathfinderMob {
    public KitsuneEntity(Level level)
    {
        this(KitsuneCivEntities.KITSUNE,level);
    }
    public KitsuneEntity(EntityType<? extends KitsuneEntity> entityType,Level level)
    {
        super(entityType,level);
        this.getNavigation().setCanOpenDoors(true);
        this.getNavigation().setCanFloat(true);
    }
    public static AttributeSupplier.Builder createAttributes()
    {
        return PathfinderMob.createMobAttributes()
            .add(Attributes.MAX_HEALTH,20)
            .add(Attributes.MOVEMENT_SPEED,0.3);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 4));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
    }
    @Override
    public void tick() {
        super.tick();
        if(!level().isClientSide())
        {
            serverTick();
            return;
        }
    }
    private void serverTick()
    {
        
    }
}
