package Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class Appointment extends JFrame implements ActionListener {
    private JLabel number,Name,doctor,time,date;
    private JTextField N,T,d,doc;
    private JButton Booked,Cancel;
    private Container color;
    private Font f;
    private Double charge;

    public Appointment(){

        this.setBounds(450,300,600,600);
        this.setTitle("Booking Appointment");
        color = this.getContentPane();
        color.setLayout(null);
        color.setBackground(Color.orange);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f = new Font("Arial",Font.BOLD,18);

        int size = MainPage.allticket.size();
        int n = 1001;

        if(size>0) {
            n = n + size;
        }

        number = new JLabel("Tickets " + n);
        number.setBounds(50,50,150,50);
        number.setFont(f);

        Name = new JLabel("Name:");
        Name.setBounds(50,120,150,50);
        Name.setFont(f);

        doctor = new JLabel("Doctor:");
        doctor.setBounds(50,190,150,50);
        doctor.setFont(f);


        date = new JLabel("Date:");
        date.setBounds(50,260,150,50);
        date.setFont(f);

        time = new JLabel("Time:");
        time.setBounds(50,330,150,50);
        time.setFont(f);

        color.add(number);
        color.add(Name);
        color.add(doctor);
        color.add(date);
        color.add(time);
        color.add(Name);

        //N = new JTextField();
        //N.setFont(f);
        //N.setBounds(160,50,200,50);
        //color.add(N);



        N = new JTextField();
        N.setFont(f);
        N.setBounds(160,120,200,50);
        color.add(N);
        doc = new JTextField();
        doc.setFont(f);
        doc.setBounds(160,190,200,50);
        color.add(doc);

        d = new JTextField();
        d.setFont(f);
        d.setBounds(160,260,200,50);
        color.add(d);

        T = new JTextField();
        T.setFont(f);
        T.setBounds(160,330,200,50);
        color.add(T);



        Cancel = new JButton("Cancel");
        Cancel.addActionListener(this);
        Cancel.setBounds(260,400,100,50);
        color.add(Cancel);

        Booked = new JButton("Book");
        Booked.addActionListener(this);
        Booked.setBounds(160,400,100,50);

        color.add(Booked);






        setVisible(true);





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean flag = false;
        boolean check = false;
        int size = MainPage.allticket.size();
        int number = 1001;

        if(size>0) {
            number = number + size;
        }


        String time = T.getText();
        String Name = N.getText();
        String date = d.getText();
        String doct = doc.getText();



        if(e.getSource() == Booked){

            for (int k = 0; k<MainPage.doctor.size();k++) {
                RegistrationDoctor d = MainPage.doctor.get(k);
                    if (doct.equals(d.getName())) {
                        check = true;
                        break;

                    }
                }
                if (check) {
                    for (int i = 0; i < MainPage.allticket.size(); i++) {

                        Ticket t = MainPage.allticket.get(i);
                        if (time.equals(t.getTime()) & date.equals(t.getDate())) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        JOptionPane.showMessageDialog(null, "Sorry the time slot on that day is not available!!!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ticket " + number + "!\nbooked:");

                        Ticket t;
                        t = new Ticket(number, Name, doct, date, time, 0);
                        MainPage.allticket.add(t);


                        try {
                            PrintWriter q = new PrintWriter("patientsDetails.txt");
                            for (int i = 0; i < MainPage.allticket.size(); i++) {
                                Ticket T = MainPage.allticket.get(i);
                                q.println(T.getNumber());
                                q.println(T.getName());
                                q.println(T.getDoctor());
                                q.println(T.getTime());
                                q.println(T.getCharge());

                                q.println();
                            }
                            q.close();
                            setVisible(false);
                            AdminPage back = new AdminPage();
                            back.setVisible(true);
                        } catch (Exception ex) {

                            System.out.println("Error input");

                        }

                    }


                }
                else{
                    JOptionPane.showMessageDialog(null,"doctor does not exist please select right doctor");
                }

            }



        else{
            setVisible(false);
            AdminPage back = new AdminPage();
            back.setVisible(true);
        }
    }
}

