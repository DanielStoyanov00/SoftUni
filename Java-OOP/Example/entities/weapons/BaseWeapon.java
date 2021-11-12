package entities.weapons;

import interfaces.Weapon;

public abstract class BaseWeapon implements Weapon {
    private int durability;
    private int damage;

    protected BaseWeapon(int durability, int damage) {
        this.durability = durability;
        this.damage = damage;
    }

    @Override
    public int getDurability() {
       return this.durability;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }
}
