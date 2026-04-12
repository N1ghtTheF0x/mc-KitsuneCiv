package ntf.mc.kitsuneciv.entities;

import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.profiling.Profiler;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.ai.ActivityData;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.Brain.Packed;
import net.minecraft.world.entity.ai.Brain.Provider;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.entity.npc.Npc;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import ntf.mc.kitsuneciv.KitsuneCivEntities;
import ntf.mc.kitsuneciv.entities.ai.KitsuneGoalPackages;

public class KitsuneEntity extends PathfinderMob implements Npc, InventoryCarrier {
    private final SimpleContainer inventory = new SimpleContainer(1);
    private static final Provider<KitsuneEntity> BRAIN_PROVIDER = Brain.<KitsuneEntity>provider(
        List.of(
            SensorType.NEAREST_LIVING_ENTITIES,
            SensorType.NEAREST_PLAYERS,
            SensorType.NEAREST_ITEMS,
            SensorType.NEAREST_BED,
            SensorType.HURT_BY
        ),
        (body) ->
        {
            List<ActivityData<KitsuneEntity>> activities = new ArrayList<ActivityData<KitsuneEntity>>();
            
            activities.add(ActivityData.create(Activity.CORE, KitsuneGoalPackages.getCorePackage()));
            activities.add(ActivityData.create(Activity.IDLE, KitsuneGoalPackages.getIdlePackage()));

            return activities;
        }
    );
    public KitsuneEntity(Level level)
    {
        this(KitsuneCivEntities.KITSUNE,level);
    }
    public KitsuneEntity(EntityType<? extends KitsuneEntity> entityType,Level level)
    {
        super(entityType,level);
        setCanPickUpLoot(true);
        getNavigation().setCanOpenDoors(true);
        getNavigation().setCanFloat(true);
    }
    public static AttributeSupplier.Builder createAttributes()
    {
        return PathfinderMob.createMobAttributes()
            .add(Attributes.MAX_HEALTH,20)
            .add(Attributes.MOVEMENT_SPEED,0.3);
    }
    @Override
    public boolean canBeLeashed() {
        return false;
    }
    @Override
    public SimpleContainer getInventory() {
        return inventory;
    }
    @Override
    public SlotAccess getSlot(final int slot) {
        int inventorySlot = slot - 300;
        return inventorySlot >= 0 && inventorySlot < inventory.getContainerSize() ? inventory.getSlot(inventorySlot) : super.getSlot(slot);
    }
    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        this.writeInventoryToTag(output);
    }
    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.readInventoryFromTag(input);
    }
    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.FOX_HURT;
    }
    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.FOX_DEATH;
    }
    @Override
    protected void pickUpItem(ServerLevel level, ItemEntity entity) {
        InventoryCarrier.pickUpItem(level, this, this, entity);
    }
    @Override
    public boolean wantsToPickUp(ServerLevel level, ItemStack itemStack) {
        return getInventory().canAddItem(itemStack);
    }
    @Override
    public Brain<KitsuneEntity> getBrain() {
        return (Brain<KitsuneEntity>)super.getBrain();
    }
    @Override
    protected Brain<KitsuneEntity> makeBrain(Packed packedBrain) {
        Brain<KitsuneEntity> brain = BRAIN_PROVIDER.makeBrain(this, packedBrain);
        registerBrainGoals(brain);
        return brain;
    }
    private void refreshBrain(final ServerLevel level)
    {
        Brain<KitsuneEntity> old = getBrain();
        old.stopAll(level, this);
        brain = BRAIN_PROVIDER.makeBrain(this, old.pack());
        registerBrainGoals(getBrain());
    }
    private void registerBrainGoals(final Brain<KitsuneEntity> brain)
    {
        brain.updateActivityFromSchedule(level().environmentAttributes(), this.level().getGameTime(), position());
    }
    @Override
    protected void customServerAiStep(ServerLevel level) {
        ProfilerFiller profiler = Profiler.get();
        profiler.push("KitsuneBrain");
        getBrain().tick(level, this);
        profiler.pop();
        super.customServerAiStep(level);
    }
}
