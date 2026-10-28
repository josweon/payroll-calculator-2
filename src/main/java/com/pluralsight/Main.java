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

                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                // Test
                System.out.println(employeeId);
                System.out.println(name);
                System.out.println(hoursWorked);
                System.out.println(payRate);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
