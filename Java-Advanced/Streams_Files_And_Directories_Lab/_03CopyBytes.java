package com.company;

import java.io.*;

public class _03CopyBytes {
    public static void main(String[] args) throws IOException {

        InputStream input = new FileInputStream("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        OutputStream output = new FileOutputStream("output.txt");

        int oneByte = 0;
        while ((oneByte = input.read()) >= 0){
            if (oneByte == 10 || oneByte == 13){
                output.write(oneByte);
            }else {
                String digits = String.valueOf(oneByte);
                for (int i = 0; i < digits.length(); i++) {
                    output.write(digits.charAt(i));
                }
            }


        }
        output.close();



    }
}
