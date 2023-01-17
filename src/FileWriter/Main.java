package FileWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileWriter fr;

        {
            try {
                fr = new FileWriter("D:\\J\\TaskFromCodeWars\\src\\FileWriter\\filewriter.txt");
                fr.write("Ahoj toto je novy text");
                fr.append("\n De to dobre sdsasda");
                fr.close();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
