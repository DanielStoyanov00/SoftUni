package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        List<Songs> song = new ArrayList<>();

        for (int i = 0; i < number; i++) {

            String[] data = scanner.nextLine().split("_");


            Songs songs = new Songs(data[0], data[1], data[2]);

            songs.setTypeList(data[0]);
            songs.setName(data[1]);
            songs.setTime(data[2]);

            song.add(songs);

        }

        String typeList = scanner.nextLine();

        if (typeList.equals("all")) {
            for (Songs para : song) {
                System.out.println(para.getName());
            }
        } else {
            for (Songs para : song) {
                if (para.getTypeList().equals(typeList)) {
                    System.out.println(para.getName());
                }
            }
        }


    }


    static class Songs {
        String typeList;
        String name;
        String time;


        public Songs(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getTypeList() {
            return typeList;
        }

        public String getName() {
            return name;
        }

        public String getTime() {
            return time;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }


}
