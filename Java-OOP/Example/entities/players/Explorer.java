package entities.players;

import interfaces.Weapon;

public class Explorer extends BasePlayer{

    public Explorer(String name, int health, int armor, Weapon weapon) {
        super(name, health, armor, weapon);
    }
}
