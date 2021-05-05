package Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class DoctorPage extends JFrame implements ActionListener {

    private JButton profile,Appointment,Home,next,queue;
    private Container color;
    public DoctorPage(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.green);
        GridLayout layout = new GridLayout(2,2);
        layout.setHgap(25);
        layout.setVgap(25);
        panel.setLayout(layout);

        setSize(750,430);
        setLocation(450,300);
        color = getContentPane();
        color.setBackground(Color.green);
        color.add(panel);

        // setBounds(100, 100, 1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        ImageIcon pro = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/pro.jpg");
        ImageIcon App = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/que.png");
        ImageIcon home = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/home.jpg");
        ImageIcon ne = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/next.jpg");


        profile = new JButton(pro);
        Appointment = new JButton(App);
        Home = new JButton(home);
        next = new JButton(ne);
        queue = new JButton("TOTAL PATIENTS IN QUEUE");



        profile.addActionListener(this);
        Appointment.addActionListener(this);
        Home.addActionListener(this);
        next.addActionListener(this);
        queue.addActionListener(this);


        panel.add(profile);
        panel.add(Appointment);
        panel.add(next);
        panel.add(queue);

        panel.add(Home);
        setVisible(true);

    }




    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == profile) {

            setVisible(false);
            update up = new update();
            up.setVisible(true);

            /*file f = new file();
            f.setVisible(true);*/


        } else if (e.getSource() == Appointment) {

            int number = 0;
            for (int i = 0; i < MainPage.allticket.size(); i++) {

                Ticket t = MainPage.allticket.get(i);
                number = number + 1;
                JOptionPane.showMessageDialog(null, "\nIN A QUEUE  " + number + "\nTicket:   " + t.getNumber() + "\nname:    " + t.getName() + "\ndoctor:     " + t.getDoctor() + "\ndate:      " + t.getDate() +  "\ntime:   " + t.getTime() + "\nCharge:  " + t.getCharge());


            }

            if (number == 0) {
                JOptionPane.showMessageDialog(null, "No Patient in the Queue..");

            }


        } else if (e.getSource() == next) {
            boolean flag = false;
            boolean doctorName = false;
            String name1 = JOptionPane.showInputDialog("DoctorName");
            for (int d = 0; d < MainPage.allticket.size(); d++) {
                Ticket doc = MainPage.allticket.get(d);
                if (name1.equals(doc.getDoctor())) {

                    doctorName = true;
                    break;
                }


            }
            if (doctorName) {


                String name = JOptionPane.showInputDialog("PatientsName:");


                for (int i = 0; i < MainPage.allticket.size(); i++) {
                    Ticket t = MainPage.allticket.get(i);
                    if (name.equals(t.getName())) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    for (int i = 0; i < MainPage.allticket.size(); i++) {
                        Ticket t = MainPage.allticket.get(i);

                        Double charge = Double.valueOf(JOptionPane.showInputDialog("Enter Amount: "));
                       
                        t.setCharge(charge);
                        paidPatients P;
                        P = new paidPatients(t.getNumber(), t.getName(), t.getDoctor(), t.getDate(), t.getTime(), t.getCharge());
                        MainPage.paid.add(P);
                        MainPage.allticket.remove(i);


                        try {
                            PrintWriter q = new PrintWriter("paidDetails.txt");

                            for (int j = 0; j < MainPage.paid.size(); j++) {
                                paidPatients f = MainPage.paid.get(j);
                                q.println(f.getNumber());
                                q.println(f.getName());
                                q.println(f.getDoctor());
                                q.println(f.getTime());
                                q.println(f.getCharge());
                                q.println();
                            }
                            q.close();
                        } catch (Exception ex) {

                            System.out.println("Error input");

                        }

                    }
                }
                    else{
                    JOptionPane.showMessageDialog(null, "patients name doesn't match");

                    }

            } else {
                JOptionPane.showMessageDialog(null, "Doctor name doesn't match");

            }



            } else if (e.getSource() == queue) {
                setVisible(false);
                queue q = new queue();
                q.setVisible(true);
            } else {
                setVisible(false);
                HomePage Home = new HomePage();
                Home.setVisible(true);


            }

        }
    }

