package librarysystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {

    public static String folderDirectory = System.getProperty("user.dir") + "\\bookList.txt";

    public static void writeFile(ArrayList<book1> bookList) {

        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < bookList.size(); i++) {
                printToFile.println(bookList.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<book1> readFile() {
        ArrayList<book1> bookList = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null){
                String[] bookDetails = lineFromFile.split(", ");
                book1 a =new book1(bookDetails[0], bookDetails[1], bookDetails[2], Double.parseDouble(bookDetails[3]), bookDetails[4]);
                bookList.add(a);
            }
            read.close();
            
        }catch (Exception e){
            System.out.println("Erro: " + e);
    }
        return bookList;
    }
            }
     