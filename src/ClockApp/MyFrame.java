package ClockApp;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyFrame extends JFrame{
    JLabel jLabel = new JLabel();
    JFrame jf = new JFrame();

    MyFrame() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("My Date App");
        jf.setSize(350, 200);
        jf.setLayout(new FlowLayout());
        jLabel.setText(getCurrentLocalDateTimeStamp());
        jf.add(jLabel);
        jf.setVisible(true);
        setMyTime();
//        JOptionPane.showMessageDialog(null,getCurrentLocalDateTimeStamp());
//        System.out.println(getCurrentLocalDateTimeStamp());


    }

    private static void setMyTime() {
        while(true){
            


        }


    }

    public static String getCurrentLocalDateTimeStamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }




}
