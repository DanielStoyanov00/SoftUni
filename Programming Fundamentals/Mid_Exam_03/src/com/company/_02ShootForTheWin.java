package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int shotTargets = 0;

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            int index = Integer.parseInt(line);
            if (index >= 0 && index < list.size()) {
                int currentTargetValue = list.get(index);
                shotTargets++;

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != -1) {
                        if (list.get(i) <= currentTargetValue) {
                            list.set(i, list.get(i) + currentTargetValue);
                        } else {
                            list.set(i, list.get(i) - currentTargetValue);
                        }
                    }


                }
                list.set(index, -1);
            }


            line = scanner.nextLine();
        }

        System.out.print("Shot targets: " + shotTargets + " -> ");
        for (int number : list) {
            System.out.print(number + " ");
        }
    }
}
