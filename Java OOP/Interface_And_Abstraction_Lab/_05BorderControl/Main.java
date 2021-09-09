package _05BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> identifiableList = new ArrayList<>();

        String command = reader.readLine();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");

            if (tokens.length == 2){
                Robot robot = new Robot(tokens[0],tokens[1]);
                identifiableList.add(robot);
            }else {
                Citizen citizen = new Citizen(tokens[0],Integer.parseInt(tokens[1]), tokens[2]);
                identifiableList.add(citizen);
            }
            command = reader.readLine();
        }

        String postfix = reader.readLine();

        for (Identifiable identifiable : identifiableList){
            if (identifiable.getId().endsWith(postfix)){
                System.out.println(identifiable.getId());
            }
        }

    }
}
