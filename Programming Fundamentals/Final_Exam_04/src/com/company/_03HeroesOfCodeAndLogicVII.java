package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> heroAndHP = new TreeMap<>();
        Map<String, Integer> heroAndMP = new TreeMap<>();

        for (int i = 0; i < number; i++) {
            String[] heroes = scanner.nextLine().split(" ");
            String heroName = heroes[0];
            int HP = Integer.parseInt(heroes[1]);
            int MP = Integer.parseInt(heroes[2]);
            heroAndHP.put(heroName, HP);
            heroAndMP.put(heroName, MP);
        }

        String commands = scanner.nextLine();
        while (!commands.equals("End")) {
            String[] tokens = commands.split(" - ");
            String action = tokens[0];
            String heroName = tokens[1];


            switch (action) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    if (heroAndMP.get(heroName) >= neededMP){
                        heroAndMP.replace(heroName, heroAndMP.get(heroName) - neededMP);
                        System.out.printf("%s has successfully cast %s and now has %s MP!\n", heroName, spellName, heroAndMP.get(heroName));
                    }else {
                        System.out.printf("%s does not have enough MP to cast %s!\n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    heroAndHP.replace(heroName, heroAndHP.get(heroName) - damage );
                    if (heroAndHP.get(heroName) > 0){
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n", heroName, damage, attacker, heroAndHP.get(heroName));
                    }else {
                        System.out.printf("%s has been killed by %s!\n", heroName, attacker);
                        heroAndHP.remove(heroName);
                        heroAndMP.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int amountOfMP = Integer.parseInt(tokens[2]);
                    if (heroAndMP.get(heroName) + amountOfMP > 200){
                        int recharge = Math.abs((heroAndMP.get(heroName) + amountOfMP) - (amountOfMP + 200));
                        heroAndMP.replace(heroName, 200);
                        System.out.printf("%s recharged for %d MP!\n", heroName, recharge);
                    }else {
                        heroAndMP.replace(heroName, heroAndMP.get(heroName) + amountOfMP);
                        System.out.printf("%s recharged for %d MP!\n", heroName, amountOfMP);
                    }
                    break;
                case "Heal":
                    int amountOfHP = Integer.parseInt(tokens[2]);
                    if (heroAndHP.get(heroName) + amountOfHP > 100){
                        int heal = Math.abs((heroAndHP.get(heroName) + amountOfHP) - (amountOfHP + 100));
                        heroAndHP.replace(heroName, 100);
                        System.out.printf("%s healed for %d HP!\n", heroName, heal);
                    }else {
                        heroAndHP.replace(heroName, heroAndHP.get(heroName) + amountOfHP);
                        System.out.printf("%s healed for %d HP!\n", heroName, amountOfHP);
                    }
                    break;
                default:
                    break;
            }


            commands = scanner.nextLine();
        }

        heroAndHP.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue()
                .reversed()
                .thenComparing(Map.Entry.comparingByKey()))
                .forEach(s -> {
                    System.out.println(s.getKey());
                    System.out.printf("HP: %d\n", s.getValue());
                    System.out.printf("MP: %d\n", heroAndMP.get(s.getKey()));
                });



        }


    }

