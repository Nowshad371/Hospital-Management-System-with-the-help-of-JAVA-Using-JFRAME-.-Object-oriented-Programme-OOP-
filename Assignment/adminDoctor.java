package Assignment;

import javax.accessibility.AccessibleAction;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class adminDoctor extends JFrame implements ActionListener {

    private JButton doctor;
    private JButton admin;
    private JButton back;

    private Container color;
    JPanel panel = new JPanel();

    public adminDoctor(){

        setSize(700,230);
        setLocation(300,100);

        panel.setBackground(Color.black);
        GridLayout layout = new GridLayout(1,2);
        layout.setHgap(25);
        layout.setVgap(25);
        panel.setLayout(layout);
        color = getContentPane();
        color.setBackground(Color.black);
        color.add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());



        ImageIcon Doc = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/People-Doctor-Male-icon.png");
        ImageIcon Ad = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/download.png");
        ImageIcon Ex = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/free-user-logout-icon-304-thumb.png");



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        admin = new JButton(Ad);
        doctor = new JButton(Doc);
        back = new JButton(Ex);

        // admin.setBounds(50,50,150,50);
        //doctor.setBounds(100,50,150,50);
        //back.setBounds(150,50,150,50);


        panel.add(admin);
        panel.add(doctor);
        panel.add(back);


        back.addActionListener(this);
        admin.addActionListener(this);
        doctor.addActionListener(this);


        setVisible(true);




    }














    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == admin){
            setVisible(false);
            MyFrame my = new MyFrame();
            my.setVisible(true);

        }

    else if(e.getSource() == doctor){
            setVisible(false);
            doctorJframe doc = new doctorJframe();
            doc.setVisible(true);

        }

    else{
            try{
                PrintWriter p = new PrintWriter("adminRegister.txt");
                for(int i =0; i <MainPage.Register.size();i++){

                    Registration R =MainPage.Register.get(i);
                    p.println(R.getName());
                    p.println(R.getPassword());
                    p.println(R.getData1());
                    p.println(R.getData2());
                    p.println(R.getData3());
                    p.println();

                }
                p.close();
                PrintWriter q = new PrintWriter("DoctorDetail.txt");
                for(int i = 0; i< MainPage.doctor.size(); i++){
                    RegistrationDoctor t = MainPage.doctor.get(i);
                    q.println(t.getName());
                    q.println(t.getPassword());
                    q.println(t.getData1());
                    q.println(t.getData2());
                    q.println(t.getData3());
                    q.println();
                }
                q.close();
                setVisible(false);
                AdminPage ad = new AdminPage();
                ad.setVisible(true);

            }catch (Exception ex){

                System.out.println("Error input");
            }
        }
    }

}
