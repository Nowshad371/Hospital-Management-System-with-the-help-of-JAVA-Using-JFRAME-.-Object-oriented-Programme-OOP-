package Assignment;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class Search extends JFrame implements ActionListener {
        private Button Enter;

        public Search(){

            this.setBounds(450,300,200,100);
            this.setTitle("SEARCH");

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new FlowLayout());
            Enter = new Button("Enter");
            Enter.addActionListener(this);
            add(Enter);
            setVisible(true);





        }
        private static Scanner x;

        public static void readrecord(String name, String filepath) {
            boolean found = false;
            String ticket = "";
            String name1 = "";
            String time = "";
            String charge = "";


            try {
                x = new Scanner(new File(filepath));

                while (x.hasNext() && !found) {
                    ticket = x.next();
                    name1 = x.next();
                    time = x.next();
                    charge = x.next();
                    if (name1.equals(name)) {

                        found = true;
                    }
                }
                if (found) {
                    JOptionPane.showMessageDialog(null, "Ticket: " + ticket + "\nName: " + name1 + "\n" + "time: " + time + "\n" + "charge:  " + charge);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Record not found");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR");

            }
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Enter){

            String filepath = "PaidDetails.txt";
            String name = JOptionPane.showInputDialog("name");
            readrecord(name,filepath);


        }
        else{
            JOptionPane.showMessageDialog(null,"Wrong input");
        }
    }
}


