package Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Report extends JFrame implements ActionListener {

    private JButton Search,Exit,Unpaid;
    private Container color;

    JPanel panel = new JPanel();


    public Report(){
        //this.setBounds(450,300,500,400);
        setSize(700,230);
        setLocation(300,100);
        this.setTitle("REPORT");

        panel.setBackground(Color.green);
        GridLayout layout = new GridLayout(1,2);
        layout.setHgap(25);
        layout.setVgap(25);
        panel.setLayout(layout);
        color = getContentPane();
        color.setBackground(Color.green);
        color.add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());




        ImageIcon ex = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/home.png");
        Exit = new JButton(ex);
        Exit.addActionListener(this);

        ImageIcon se = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/paid.png");
        ImageIcon  Un = new ImageIcon("C:/Users/Nawshad/IdeaProjects/week4/src/Assignment/unpaid.png");

        Search = new JButton(se);
        Unpaid = new JButton(Un);

        Search.addActionListener(this);
        Unpaid.addActionListener(this);




        panel.add(Search);
        panel.add(Unpaid);
        panel.add(Exit);

        setVisible(true);






    }


    @Override
    public void actionPerformed (ActionEvent e) {
        if(e.getSource() == Search){


            Search se = new Search();
            se.setVisible(true);


        }
        else if(e.getSource() == Unpaid){

            Unpaid Un = new Unpaid();
            Un.setVisible(true);




        }

        else {
            setVisible(false);
            AdminPage AD = new AdminPage();
            AD.setVisible(true);
        }

    }
}
