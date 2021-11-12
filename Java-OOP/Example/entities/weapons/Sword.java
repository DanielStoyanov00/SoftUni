package entities.weapons;

public class Sword extends BaseWeapon{
    private static final int DURABILITY = 100;
    private static final int DAMAGE = 40;

    public Sword() {
        super(DURABILITY, DAMAGE);
    }
}
