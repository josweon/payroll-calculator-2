package com.pluralsight;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainWrite {

    public static void main(String[] args) {

            String filePath = "src/main/resources/";
            Scanner scanner = new Scanner(System.in);

            // read file
            System.out.print("Enter the name of the file to be process: ");
            String fileName = scanner.nextLine().trim();
            String readFile = filePath + fileName;

        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(readFile));

            // write file
            System.out.print("Enter the name of the payroll file to create: ");
            String fileNameWrite = scanner.nextLine().trim();
            String writeFile = filePath + fileNameWrite;

            FileWriter fileWriter = new FileWriter(writeFile);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            bufReader.readLine();

            if (fileNameWrite.contains(".json")) {
                bufWriter.write("[\n");
            }
            String input;

            while ((input = bufReader.readLine()) != null) {
                StringBuilder inputWriter = new StringBuilder();
                String[] tokens = input.split(Pattern.quote("|"));

                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                if (fileNameWrite.contains(".json")) {
                    bufWriter.write(jsonFormatter(employee));
                    // magic number :/
                    if (employee.getEmployeeId() == 80){
                        bufWriter.write("\n");
                    } else {
                        bufWriter.write(",\n");
                    }
                } else {
                    inputWriter.append(employee.getEmployeeId());
                    inputWriter.append("|");
                    inputWriter.append(employee.getName());
                    inputWriter.append("|");
                    inputWriter.append(employee.getGrossPay());
                    inputWriter.append("\n");

                    bufWriter.write(inputWriter.toString());
                }
            }

            if (fileNameWrite.contains(".json")) {
                bufWriter.write("]");
            }
            bufReader.close();
            bufWriter.close();

            System.out.println("Success!");

        } catch (FileNotFoundException e) {
            System.out.println("ERROR - fileName not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR - Invalid read/write operation" + e.getMessage());
        }

    }
    public static String jsonFormatter(Employee employee) {
        String parseJson = String.format("\t{ \"id\": %d, \"name\": \"%s\", \"grossPay\": %.2f }",
                employee.getEmployeeId(),
                employee.getName(),
                employee.getGrossPay());
        return parseJson;
    }
}
