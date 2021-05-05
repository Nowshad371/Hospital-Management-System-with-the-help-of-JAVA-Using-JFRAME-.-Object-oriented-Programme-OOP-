package Assignment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class delete extends JFrame implements ActionListener {


    private Panel y1, y1c, y1s, yn, yp, y2, yd1, yd2, yd3;
    private Button d;
    private Button q;

    private Label name;

    private TextField n;
    private DefaultTableModel z;
    private JTable z1;

    public delete() {
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



        n = new TextField(20);



        yn = new Panel();
        yp = new Panel();
        yd1 = new Panel();
        yd2 = new Panel();
        yd3 = new Panel();

        y1c.add(name);


        yn.add(n);
        y1c.add(yn);




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


        int size = MainPage.doctor.size();
        String[][] data = new String[size][5];

        for (int i = 0; i < MainPage.doctor.size(); i++) {
            RegistrationDoctor a = MainPage.doctor.get(i);

            data[i][0] = a.getName();
            data[i][1] = "" + a.getPassword();
            data[i][2] = "" + a.getData1();
            data[i][3] = "" + a.getData2();
            data[i][4] = "" + a.getData3();
        }
        String[] columnNames = {"Name", "Pin", "gender", "DOB", "address"};

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
                PrintWriter p1 = new PrintWriter("DoctorDetail.txt");
                for (int i = 0; i < MainPage.doctor.size(); i++) {


                    RegistrationDoctor a = MainPage.doctor.get(i);
                    p1.println(a.getName());
                    p1.println(a.getPassword());
                    p1.println(a.getData1());
                    p1.println(a.getData2());
                    p1.println(a.getData3() + "\n");
                }
                p1.close();
                setVisible(false);
                AdminPage ad = new AdminPage();
                ad.setVisible(true);

                //System.exit(0);
            } catch (Exception ex) {

            }
        } else {
            boolean found = false;
            RegistrationDoctor current = null;
            String name = n.getText();
            int i = 0;

            for (i = 0; i < MainPage.doctor.size(); i++) {
                RegistrationDoctor a = MainPage.doctor.get(i);

                if (name.equals(a.getName())) {
                    found = true;
                    current = a;
                    MainPage.doctor.remove(current);
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


