package Assignment;

import sample.Customer;
import sample.Sample;
import week4Lab.Main;
import week4Lab.customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class AdminPage extends JFrame implements ActionListener {

    private JButton Registration,Report,Appoinment,home,search,delete,customer;
    private Container color;
    JPanel panel = new JPanel();

    public AdminPage(){

        setSize(900,430);
        setLocation(300,100);
        panel.setBackground(Color.blue);
        GridLayout layout = new GridLayout(2,2);
        layout.setHgap(25);
        layout.setVgap(25);
        panel.setLayout(layout);
        color = getContentPane();
        color.setBackground(Color.blue);
        color.add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());




        ImageIcon Reg = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/Regitration.jpg");
        ImageIcon App = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/adminapp.jpg");
        ImageIcon Rep = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/search.png");
        ImageIcon h = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/home.jpg");
        ImageIcon R = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/Report.png");
        ImageIcon d = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/delete.jpg");

        /*Registration.setBounds(40,100,100,60);
        Appoinment.setBounds(40,150,100,60);
        Report.setBounds(40,200,100,60);
        home.setBounds(80,100,100,60);
        search.setBounds(80,150,100,60);
        delete.setBounds(80,200,100,60);*/





        Registration = new JButton(Reg);
        Appoinment = new JButton(App);
        Report = new JButton(R);
        home = new JButton(h);
        search = new JButton(Rep);
        delete = new JButton(d);
        customer = new JButton("Customer");





        Registration.addActionListener(this);
        Appoinment.addActionListener(this);
        Report.addActionListener(this);
        home.addActionListener(this);
        search.addActionListener(this);
        delete.addActionListener(this);
        customer.addActionListener(this);



        panel.add(Registration);
        panel.add(Appoinment);
        panel.add(Report);
        panel.add(search);
        panel.add(delete);
        panel.add(home);
        panel.add(customer);

        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() ==Registration){
            setVisible(false);
            adminDoctor second = new adminDoctor();
            second.setVisible(true);

            }


        else if(e.getSource() == Appoinment){

                String name = JOptionPane.showInputDialog("Patients name:");
                boolean flag = false;
                for (int i =0;i<MainPage.Registration.size();i++) {
                    registrationCustomer t = MainPage.Registration.get(i);
                    if (name.equals(t.getName())) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {

                        setVisible(false);
                        Appointment app = new Appointment();
                        app.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Resister before booking");

                }


        }



        else if(e.getSource() == search){
            setVisible(false);
            Report Rep = new Report();

            Rep.setVisible(true);

        }
        else if(e.getSource() == Report){

            setVisible(false);
            Reportall re = new Reportall();
            re.setVisible(true);


        }
        else if(e.getSource() == delete){
            setVisible(false);
            delete d = new delete();
            d.setVisible(true);

        }
        else if(e.getSource() == customer){
            setVisible(false);
            customerRegistration r = new customerRegistration();
            r.setVisible(true);
        }
        else{

            try{
                PrintWriter p = new PrintWriter("CustomerRegister.txt");
                for(int i =0; i <MainPage.Registration.size();i++){

                    registrationCustomer R =MainPage.Registration.get(i);
                    p.println(R.getName());
                    p.println(R.getPassword());
                    p.println(R.getData1());
                    p.println(R.getData2());
                    p.println(R.getData3());
                    p.println();

                }
                p.close();

                setVisible(false);
                HomePage Home = new HomePage();
                Home.setVisible(true);

            }catch (Exception ex){

                System.out.println("Error input");
            }


        }


    }
}
