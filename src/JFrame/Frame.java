package JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {

    public void window(){
        JFrame jf = new JFrame("Ahoj JFrame");
        JButton jb = new JButton("OK");
        jb.setBounds(50,50,200,80);
        jf.setVisible(true);
        jf.setSize(300,200);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.add(jb);
        jf.setLayout(null);

        jb.addActionListener(new ActionListener() {
            int count=0;
            @Override
            public void actionPerformed(ActionEvent e) {

                count++;
                jb.setText(String.format("Pressed %d times", count));
                jf.getContentPane().setBackground(new Color(50,count*10,count*10));
            }

        });
    }
}
