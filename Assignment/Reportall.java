package Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reportall extends JFrame implements ActionListener {

    private JButton paid,unpaid,Exit,list;
    private Container color;
    JPanel panel = new JPanel();

    public Reportall(){
        //this.setBounds(450,300,500,400);

        this.setTitle("REPORT");


        /*setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        color = this.getContentPane();
        //color.setLayout(null);
        color.setBackground(Color.white);*/



        setSize(700,430);
        setLocation(300,100);
        panel.setBackground(Color.yellow);
        GridLayout layout = new GridLayout(2,2);
        layout.setHgap(25);
        layout.setVgap(25);
        panel.setLayout(layout);
        color = getContentPane();
        color.setBackground(Color.yellow);
        color.add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        ImageIcon ex = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/home.png");
        Exit = new JButton(ex);
        Exit.addActionListener(this);

        ImageIcon se = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/paid.png");
        ImageIcon  Un = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/unpaid.png");

        unpaid = new JButton(Un);
        paid = new JButton(se);
        paid.addActionListener(this);
        unpaid.addActionListener(this);
        paid.addActionListener(this);
        list = new JButton("list");
        list.addActionListener(this);

        panel.add(paid);
        panel.add(unpaid);
        panel.add(list);
        panel.add(Exit);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == paid){

            paidReport p = new paidReport();
            p.setVisible(true);

        }
        else if(e.getSource() == unpaid){

            unpaidReport un = new unpaidReport();
            un.setVisible(true);



        }
        else if(e.getSource() == list){
            setVisible(false);
            list l = new list();
            l.setVisible(true);

        }
        else{
            setVisible(false);
            AdminPage ad = new AdminPage();
            ad.setVisible(true);

        }
    }
}
