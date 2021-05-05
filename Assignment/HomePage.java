package Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class HomePage extends JFrame implements ActionListener {

    private JButton Doctor,Admin,Exit;
    private Container color;
    JPanel panel = new JPanel();
    public HomePage(){
        setSize(700,220);
        setLocation(450,300);
        panel.setBackground(Color.blue);
        GridLayout layout = new GridLayout(1,2);
        layout.setHgap(25);
        layout.setVgap(25);
        panel.setLayout(layout);
        color = getContentPane();
        color.setBackground(Color.blue);
        color.add(panel);
       // setBounds(100, 100, 1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());





        ImageIcon Doc = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/People-Doctor-Male-icon.png");
        ImageIcon Ad = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/download.png");
        ImageIcon Ex = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/free-user-logout-icon-304-thumb.png");



        Doctor = new JButton(Doc);
        Admin = new JButton(Ad);
        Exit = new JButton(Ex);



        Doctor.addActionListener(this);
        Admin.addActionListener(this);
        Exit.addActionListener(this);


        panel.add(Doctor);
        panel.add(Admin);
        panel.add(Exit);
        setVisible(true);



    }
    private static Scanner x;
    public static void readrecord(String password1,String name, String filepath) {
        boolean found = false;

        String name1 = "";
        String password = "";
        try {
            x = new Scanner(new File(filepath));

            while (x.hasNext() && !found) {

                name1 = x.next();
                password = x.next();
                if (name1.equals(name) && password.equals(password1)) {

                    found = true;
                }
            }
            if (found) {

                AdminPage ad = new AdminPage();
                ad.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Record not found");
                HomePage home = new HomePage();
                home.setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");

        }
    }
    public static void read(String password1,String name, String filepath) {
        boolean found = false;

        String name1 = "";
        String password = "";
        try {
            x = new Scanner(new File(filepath));

            while (x.hasNext() && !found) {

                name1 = x.next();
                password = x.next();
                if (name1.equals(name) && password.equals(password1)) {

                    found = true;
                }
            }
            if (found) {

                DoctorPage doc = new DoctorPage();
                doc.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Record not found");
                HomePage home = new HomePage();
                home.setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Admin){

            String filepath = "adminRegister.txt";
            String name = JOptionPane.showInputDialog("name");
            String password1 = JOptionPane.showInputDialog("password");
            readrecord(password1,name,filepath);
            /*adminDetails ad = new adminDetails();
            ad.setVisible(true);*/
            //MainPage.first.setVisible(false);
            //MainPage.adminHome.setVisible(true);
            setVisible(false);





        }

        else if(e.getSource() == Doctor){

            String filepath = "DoctorDetail.txt";
            String name = JOptionPane.showInputDialog("name");
            String password1 = JOptionPane.showInputDialog("password");
            read(password1,name,filepath);

            setVisible(false);

        }
        else{
            System.exit(0);
        }

    }
}
