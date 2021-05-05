package Assignment;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class paidReport extends JFrame {
    JTextArea textArea = new JTextArea();
    JButton displayButton = new JButton("Display");


    public paidReport(){
        this.setSize(400,300);
        JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(textArea,BorderLayout.CENTER);
        flowPanel.add(displayButton);
        add(flowPanel,BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        displayButton.addActionListener(event ->readfile("PaidDetails.txt"));
        setVisible(true);
    }




    private void readfile(String filename) {


        String file = " ";
        int numRecord = 0;
        try {
            FileReader fileReader = new FileReader(filename);
            Scanner inFile = new Scanner(fileReader);

            while (inFile.hasNext() == true) {

                file = file + inFile.nextLine() + "\n";

                numRecord++;
            }
            inFile.close();
            fileReader.close();

            file = file + numRecord + "Records read" + "\n";
            textArea.setText(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            textArea.setText("error file issue");
        }

    }


}
