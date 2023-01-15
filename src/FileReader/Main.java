package FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static String fileName = "D:\\J\\TaskFromCodeWars\\src\\FileReader\\art.txt";
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(fileName);
           int data = fr.read();
           while (data!=-1){
               System.out.print((char)data);
               data=fr.read();
           }
           fr.close();



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
