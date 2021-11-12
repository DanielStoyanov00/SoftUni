package entities.players;

import interfaces.Player;
import interfaces.Target;
import interfaces.Weapon;

public abstract class BasePlayer implements Player {
    private String name;
    private int health;
    private int armor;
    private Weapon weapon;

    protected BasePlayer(String name, int health, int armor, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.weapon = weapon;
    }

    @Override
    public void attack(Target target) {
        target.takeDamage(this.weapon.getDamage());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Weapon getWeapon() {
        return this.weapon;
    }

    @Override
    public String getInformation() {
        return String.format("%s with %d and %d has %s.",
        this.name, this.health, this.armor, this.weapon.getClass().getSimpleName());
    }
}
