package entities.weapons;

public class Bow extends BaseWeapon {
    private static final int DURABILITY = 80;
    private static final int DAMAGE = 22;

    public Bow() {
        super(DURABILITY, DAMAGE);
    }
}
