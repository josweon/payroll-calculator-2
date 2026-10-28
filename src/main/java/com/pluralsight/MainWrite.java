package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainWrite {

    public static void main(String[] args) {
        try {
            String filePath = "src/main/resources/";
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the name of the file to be process: ");
            String fileName = scanner.nextLine();
            String readFile = filePath + fileName;

            BufferedReader bufReader = new BufferedReader(new FileReader(readFile));

            String input;
//            bufReader.readLine();

            while ((input = bufReader.readLine()) != null) {
                System.out.println(input);
            }

            bufReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR - fileName not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR - Invalid read/write operation" + e.getMessage());
        }
    }
}
