package FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static String fileName = "D:\\J\\TaskFromCodeWars\\src\\FileReader\\art.txt";
    public static void main(String[] args) {

            File file = new File("D:\\J\\TaskFromCodeWars\\src\\FileReader\\art.txt");
        try {
            FileReader fr = new FileReader(fileName);

            if (file.exists()) {
                System.out.println("The file exist");
            } else {
                System.out.println("File doesnt exist");
            }

            int data = fr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read();
            }
            fr.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
