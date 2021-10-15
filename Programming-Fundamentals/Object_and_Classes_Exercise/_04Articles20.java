package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Articles204 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());


        List<Article> articles = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            String[] line = scanner.nextLine().split(", ");
            Article article = new Article(line[0], line[1], line[2]);

            articles.add(article);


        }

        String command = scanner.nextLine();


        if (command.equals("title")) {
            articles.sort(Comparator.comparing(Article::getTitle));
        } else if (command.equals("content")) {
            articles.sort(Comparator.comparing(Article::getContent));
        } else if (command.equals("author")) {
            articles.sort(Comparator.comparing(Article::getAuthor));
        }

        for (Article current : articles) {
            System.out.println(current.getTitle() + " " + "-" + " " + current.getContent() + ":" + " " + current.getAuthor());
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

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }


    }

}
