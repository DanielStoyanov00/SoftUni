package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(",\\s+");
        int number = Integer.parseInt(scanner.nextLine());

        List<Article> articles = new ArrayList<>();
        Article article = new Article(line[0], line[1], line[2]);

        for (int i = 0; i < number; i++) {
            String[] input = scanner.nextLine().split(": ");


            if (input[0].equals("Edit")) {
                article.setContent(input[1]);
            } else if (input[0].equals("ChangeAuthor")) {
                article.setAuthor(input[1]);
            } else if (input[0].equals("Rename")) {
                article.setTitle(input[1]);
            }


        }
        articles.add(article);

        for (Article art : articles) {
            System.out.print(art.totString());
        }


    }


    static class Article {
        String title;
        String content;
        String author;


        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }


        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String totString() {
            String result = String.format("%s - %s: %s", this.title, this.content, this.author);
            return result;
        }

    }


}
