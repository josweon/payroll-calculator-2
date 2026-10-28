package com.pluralsight;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainWrite {

    public static void main(String[] args) {
        try {
            String filePath = "src/main/resources/";
            Scanner scanner = new Scanner(System.in);

            // read file
            System.out.print("Enter the name of the file to be process: ");
            String fileName = scanner.nextLine().trim();
            String readFile = filePath + fileName;

            BufferedReader bufReader = new BufferedReader(new FileReader(readFile));

            // write file
            System.out.print("Enter the name of the payroll file to create: ");
            String fileNameWrite = scanner.nextLine().trim();
            String writeFile = filePath + fileNameWrite;
            FileWriter fileWriter = new FileWriter(writeFile);

            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            String input;
//            bufReader.readLine();

            while ((input = bufReader.readLine()) != null) {
                String[] tokens = input.split(Pattern.quote("|"));

                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

            }

            bufReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR - fileName not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR - Invalid read/write operation" + e.getMessage());
        }
    }
}
