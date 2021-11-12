package entities.targets;

import interfaces.Target;

public abstract class BaseTarget implements Target {
    private int health;
    private boolean isAlive;

    protected BaseTarget(int health) {
        this.health = health;
        this.isAlive = true;
    }

    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0){
            isAlive = false;
        }
    }

    @Override
    public int getHealth(){
        return this.health;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }
}
