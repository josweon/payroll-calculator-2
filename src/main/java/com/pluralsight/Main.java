package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("employees.csv"));

            String input;
            bufReader.readLine();

            while ((input = bufReader.readLine()) != null) {
                String[] tokens = (bufReader.readLine()).split(Pattern.quote("|"));


            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
