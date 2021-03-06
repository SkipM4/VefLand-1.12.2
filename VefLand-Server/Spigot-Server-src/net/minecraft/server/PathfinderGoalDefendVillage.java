package net.minecraft.server;

public class PathfinderGoalDefendVillage extends PathfinderGoalTarget {

    EntityIronGolem a;
    EntityLiving b;

    public PathfinderGoalDefendVillage(EntityIronGolem entityirongolem) {
        super(entityirongolem, false, true);
        this.a = entityirongolem;
        this.a(1);
    }

    public boolean a() {
        Village village = this.a.p();

        if (village == null) {
            return false;
        } else {
            this.b = village.b((EntityLiving) this.a);
            if (this.b instanceof EntityCreeper) {
                return false;
            } else if (this.a(this.b, false)) {
                return true;
            } else if (this.e.getRandom().nextInt(20) == 0) {
                this.b = village.c((EntityLiving) this.a);
                return this.a(this.b, false);
            } else {
                return false;
            }
        }
    }

    public void c() {
        this.a.setGoalTarget(this.b, org.bukkit.event.entity.EntityTargetEvent.TargetReason.DEFEND_VILLAGE, true); // CraftBukkit - reason
        super.c();
    }
}
