package Assignment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class update extends JFrame implements ActionListener {


    private Panel y1, y1c, y1s, yn, yp, y2, yd1, yd2, yd3;
    private Button a;
    private Button e;
    private Button d;
    private Button q;

    private Label name, pin, data1, data2, data3;

    private TextField n, p, d1, d2, d3;
    private DefaultTableModel z;
    private JTable z1;

    public update() {
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
        pin = new Label("Pin", Label.CENTER);
        data1 = new Label("gender", Label.CENTER);
        data2 = new Label("Dob", Label.CENTER);
        data3 = new Label("address", Label.CENTER);


        n = new TextField(20);
        p = new TextField(20);
        d1 = new TextField(20);
        d2 = new TextField(20);
        d3 = new TextField(20);


        yn = new Panel();
        yp = new Panel();
        yd1 = new Panel();
        yd2 = new Panel();
        yd3 = new Panel();

        y1c.add(name);
        y1c.add(pin);
        y1c.add(data1);
        y1c.add(data2);
        y1c.add(data3);


        yn.add(n);
        y1c.add(yn);

        yp.add(p);
        y1c.add(yp);


        yd1.add(d1);
        y1c.add(yd1);

        yd2.add(d2);
        y1c.add(yd2);

        yd3.add(d3);
        y1c.add(yd3);


        y1.add(y1c, BorderLayout.CENTER);

        y1s = new Panel();

        a = new Button("Add");
        e = new Button("Edit");
        d = new Button("Delete");
        q = new Button("Quit");
        a.addActionListener(this);
        e.addActionListener(this);
        d.addActionListener(this);
        q.addActionListener(this);
        y1s.add(a);
        y1s.add(e);
        y1s.add(d);
        y1s.add(q);
        y1.add(y1s, BorderLayout.SOUTH);
        add(y1);
        y2 = new Panel();

        String name = JOptionPane.showInputDialog("Name");

        int size = MainPage.doctor.size();
        String[][] data = new String[size][5];

        for (int i = 0; i < MainPage.doctor.size(); i++) {
            RegistrationDoctor a = MainPage.doctor.get(i);
            if(name.equals(a.getName())){

                data[i][0] = a.getName();
                data[i][1] = "" + a.getPassword();
                data[i][2] = "" + a.getData1();
                data[i][3] = "" + a.getData2();
                data[i][4] = "" + a.getData3();

            }



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
                DoctorPage D = new DoctorPage();
                D.setVisible(true);
                //System.exit(0);
            } catch (Exception ex) {

            }
        } else if (e.getSource() == a) {
            String name = n.getText();
            boolean found = false;

            for (int i = 0; i < MainPage.doctor.size(); i++) {

                RegistrationDoctor a = MainPage.doctor.get(i);

                if (name.equals(a.getName())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                String pin = p.getText();
                String da1 = d1.getText();
                String da2 = d2.getText();
                String da3 = d3.getText();

                RegistrationDoctor a = new RegistrationDoctor(name, pin, da1, da2, da3);
                MainPage.doctor.add(a);

                DefaultTableModel model = (DefaultTableModel) z1.getModel();
                model.addRow(new Object[]{name, pin,da1,da2,da3});
            } else {
                JOptionPane.showMessageDialog(null, "User exists!");
            }
        } else {
            RegistrationDoctor current = null;
            String name = n.getText();
            boolean found = false;
            int i = 0;
            if (e.getSource() == e) {
                for (i = 0; i < MainPage.doctor.size(); i++) {
                    RegistrationDoctor a = MainPage.doctor.get(i);

                    if (name.equals(a.getName())) {
                        found = true;
                        current = a;
                        break;
                    }
                }
                if (found) {
                    String pin = p.getText();
                    String da1 = d1.getText();
                    String da2 = d2.getText();
                    String da3 = d3.getText();


                    current.setPassword(pin);
                    current.setData1(da1);
                    current.setData2(da2);
                    current.setData3(da3);

                    DefaultTableModel model = (DefaultTableModel) z1.getModel();
                    model.setValueAt(pin, i,1);
                    model.setValueAt(da1,i,2);
                    model.setValueAt(da2,i,3);
                    model.setValueAt(da3,i,4);

                } else {
                    JOptionPane.showMessageDialog(null, "User not exists!");
                }
            } else {
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

}

