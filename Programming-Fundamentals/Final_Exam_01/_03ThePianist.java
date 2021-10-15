package com.company;

import java.util.*;

public class _03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String,String>> collection = new LinkedHashMap<>();

        int initialPianists = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < initialPianists; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            Map<String, String> composerAndKey = new HashMap<>();
            composerAndKey.put(tokens[1],tokens[2]);
            collection.put(tokens[0],composerAndKey);
        }

        String command = scanner.nextLine();
        while(!command.equals("Stop")){
            String[] tokens = command.split("\\|");
            String action = tokens[0];

            switch (action){
                case"Add":
                    String piece = tokens[1];
                    String composer = tokens[2];
                    String key = tokens[3];
                    if (collection.containsKey(piece)){
                        System.out.printf("%s is already in the collection!\n", piece);
                    }else {
                        Map<String, String> newMap = new HashMap<>();
                        newMap.put(composer,key);
                        collection.put(piece, newMap);
                        System.out.printf("%s by %s in %s added to the collection!\n", piece,composer,key);
                    }
                    break;
                case "Remove":
                    String pieceToRemove = tokens[1];
                    if (collection.containsKey(pieceToRemove)){
                        collection.remove(pieceToRemove);
                        System.out.printf("Successfully removed %s!\n", pieceToRemove);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", pieceToRemove);
                    }
                    break;
                case "ChangeKey":
                    String pieceToChangeKey = tokens[1];
                    String newKey = tokens[2];
                    if (!collection.containsKey(pieceToChangeKey)){
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", pieceToChangeKey);
                    }else {
                        System.out.printf("Changed the key of %s to %s!\n", pieceToChangeKey, newKey);
                        for (Map.Entry<String, Map<String, String>> entry : collection.entrySet()) {
                            for (Map.Entry<String, String> value : entry.getValue().entrySet()) {
                                if (entry.getKey().equals(pieceToChangeKey)){
                                    value.setValue(newKey);
                                    break;
                                }
                            }

                        }

                    }
                    break;
                default:
                    break;
            }



            command = scanner.nextLine();
        }


        collection.entrySet().stream()
                .sorted(Map.Entry.<String, Map<String,String>>comparingByKey()
                .thenComparing(Map.Entry.comparingByKey()))
                .forEach(s -> {
                    for (Map.Entry<String, String> value : s.getValue().entrySet()) {
                        System.out.printf("%s -> Composer: %s, Key: %s\n", s.getKey(), value.getKey(), value.getValue());
                    }
                });










    }
}
