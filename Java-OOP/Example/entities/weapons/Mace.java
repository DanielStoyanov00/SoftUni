package entities.weapons;

public class Mace extends BaseWeapon {
    private static final int DURABILITY = 120;
    private static final int DAMAGE = 55;

    public Mace() {
        super(DURABILITY, DAMAGE);
    }
}
