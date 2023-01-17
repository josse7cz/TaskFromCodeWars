package JOptionPanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter your name");
        JOptionPane.showMessageDialog(null,"Your name is "+name+". Hello "+name);

        int age;

        try {
            age= Integer.parseInt(JOptionPane.showInputDialog("Zadejte věk"));
            JOptionPane.showMessageDialog(null, "Váš věk je: "+age);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Zvolené věk není číslo. Program bude ukončen.");

        }




    }
}
