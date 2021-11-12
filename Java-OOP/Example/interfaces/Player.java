package interfaces;

public interface Player {

    void attack(Target target);

    String getName();

    int getHealth();

    int getArmor();

    Weapon getWeapon();

    String getInformation();
}
