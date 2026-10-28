package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("employees.csv"));
            System.out.println(bufReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
