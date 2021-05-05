package Assignment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class queue extends JFrame implements ActionListener {


        private Panel y1, y1c, y1s, yn, yp, y2, yd1, yd2;

        private Button d;
        private Button q;

        private Label name;

        private TextField n;
        private DefaultTableModel z;
        private JTable z1;

        public queue() {
            //x = new JFrame();
            setSize(1000, 500);
            setLocation(300, 100);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(2, 1));
            y1 = new Panel();
            y1.setLayout(new BorderLayout());
            y1c = new Panel();
            y1c.setLayout(new GridLayout(2, 2));
            name = new Label("Name", Label.CENTER);


            //data3 = new Label("address", Label.CENTER);


            n = new TextField(20);
            //n.setBounds(150,300,400,50);
            //p = new TextField(20);
            //d1 = new TextField(20);




            yn = new Panel();
            yp = new Panel();
            yd1 = new Panel();
            yd2 = new Panel();
            //yd3 = new Panel();

            y1c.add(name);

            //y1c.add(data3);


            yn.add(n);
            y1c.add(yn);

            //yp.add(p);
            //y1c.add(yp);


            //yd1.add(d1);
            //y1c.add(yd1);

            /*yd2.add(d2);
            y1c.add(yd2);*/

            /*yd3.add(d3);
            y1c.add(yd3);*/


            y1.add(y1c, BorderLayout.CENTER);

            y1s = new Panel();

            d = new Button("Delete");
            q = new Button("Quit");
            d.addActionListener(this);
            q.addActionListener(this);

            y1s.add(d);
            y1s.add(q);
            y1.add(y1s, BorderLayout.SOUTH);
            add(y1);
            y2 = new Panel();


            int size = MainPage.allticket.size();
            String[][] data = new String[size][7];

            for (int i = 0; i < MainPage.allticket.size(); i++) {
                Ticket a = MainPage.allticket.get(i);
                registrationCustomer r = MainPage.Registration.get(i);
                data[i][0] = String.valueOf(a.getNumber());
                data[i][1] = "" + a.getName();
                data[i][2] = "" + a.getDoctor();
                data[i][3] = "" + r.getPassword();
                data[i][4] = "" + a.getDate();
                data[i][5] = "" + a.getTime();
                data[i][6] = "" + a.getCharge();


            }
            String[] columnNames = {"Number","Name","doctor","disease","date","time", "charge"};

            z = new DefaultTableModel(data, columnNames);
            z1 = new JTable(z);
            JScrollPane sp = new JScrollPane(z1);
            y2.add(sp);
            add(y2);
            setVisible(true);
        }


        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == q) {
                try {
                    PrintWriter p1 = new PrintWriter("patientsDetails.txt");
                    for (int i = 0; i < MainPage.allticket.size(); i++) {

                        registrationCustomer r = MainPage.Registration.get(i);
                        Ticket a = MainPage.allticket.get(i);
                        p1.println(a.getNumber());
                        p1.println(a.getName());
                        p1.println(a.getDoctor());
                        p1.println(r.getPassword());
                        p1.println(a.getDate());
                        p1.println(a.getTime());
                        p1.println(a.getCharge());
                        p1.println("\n");


                    }
                    p1.close();
                    setVisible(false);
                    DoctorPage ad = new DoctorPage();
                    ad.setVisible(true);
                    //System.exit(0);
                } catch (Exception ex) {

                }
            } else {
                Ticket current = null;
                String name = n.getText();
                boolean found = false;
                int i;
                for (i = 0; i < MainPage.allticket.size(); i++) {
                    Ticket a = MainPage.allticket.get(i);

                    if (name.equals(a.getName())) {
                        found = true;
                        current = a;
                        MainPage.allticket.remove(current);
                        break;
                    }
                }
                if (found) {
                    DefaultTableModel model = (DefaultTableModel) z1.getModel();
                    model.removeRow(i);
                } else {
                    JOptionPane.showMessageDialog(null, "User not exists!");
                }
            }
        }
    }







