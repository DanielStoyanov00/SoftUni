package entities.players;

import interfaces.Weapon;

public class Killer extends BasePlayer{

    public Killer(String name, int health, int armor, Weapon weapon) {
        super(name, health, armor, weapon);
    }
}
