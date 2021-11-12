import entities.players.Achiever;
import entities.players.Killer;
import entities.targets.Amazon;
import entities.targets.Dragon;
import entities.weapons.Bow;
import entities.weapons.Mace;
import interfaces.Player;
import interfaces.Target;
import interfaces.Weapon;

public class Main {
    public static void main(String[] args) {

        Weapon bow = new Bow();
        Weapon mace = new Mace();

        Player achiever = new Achiever("Gosho", 100, 100, bow);
        Player killer = new Killer("Pesho", 120, 150, mace);

        Target dragon = new Dragon(1000);
        Target amazon = new Amazon(500);

        dragon.takeDamage(achiever.getWeapon().getDamage());
        amazon.takeDamage(killer.getWeapon().getDamage());

        System.out.println(dragon.getHealth());
        System.out.println(amazon.getHealth());

        System.out.println(killer.getInformation());
        System.out.println(achiever.getInformation());
    }
}
