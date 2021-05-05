package Assignment;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MainPage {

    public static HomePage first = new HomePage();



    static ArrayList<Registration> Register = new ArrayList<>();
    static ArrayList<RegistrationDoctor>doctor = new ArrayList<>();
    static ArrayList<Ticket> allticket = new ArrayList<>();
    static ArrayList<paidPatients>paid = new ArrayList<>();
    static ArrayList<registrationCustomer> Registration = new ArrayList<>();


    public static void main(String[] args) {


        try {
            Scanner s = new Scanner(new File("adminRegister.txt"));
            while (s.hasNext()) {

                String x1 = s.nextLine();
                String x2 = s.nextLine();
                String x3 = s.nextLine();
                String x4 = s.nextLine();
                String x5 = s.nextLine();
                s.nextLine();

                Registration R = new Registration(x1,x2,x3,x4,x5);

                Register.add(R);
            }


        }catch (Exception e){

            System.out.println("Error in read!!!");

        }
        try {
            Scanner s = new Scanner(new File("DoctorDetail.txt"));
            while (s.hasNext()) {

                String n = s.nextLine();
                String p = s.nextLine();
                String g = s.nextLine();
                String d = s.nextLine();
                String a = s.nextLine();
                s.nextLine();

                RegistrationDoctor D = new RegistrationDoctor(n,p,g,d,a);

                doctor.add(D);


            }


        }catch (Exception e){

            System.out.println("Error in read!!!");

        }
        try {
            Scanner s = new Scanner(new File("patientsDetails.txt"));
            while (s.hasNext()) {
                int num = Integer.parseInt(s.nextLine());
                String n = s.nextLine();
                String d = s.nextLine();
                String d1 = s.nextLine();
                String t = s.nextLine();
                Double c = Double.parseDouble(s.nextLine());
                s.nextLine();

                Ticket T = new Ticket(num,n,d,d1,t,c);
                allticket.add(T);


            }


        }catch (Exception e){

            System.out.println("Error in read!!!");

        }

        try {
            Scanner s = new Scanner(new File("paidDetails.txt"));
            while (s.hasNext()) {
                int num = Integer.parseInt(s.nextLine());
                String name = s.nextLine();
                String d1 = s.nextLine();
                String d = s.nextLine();
                String time = s.nextLine();
                Double charge = Double.parseDouble(s.nextLine());
                s.nextLine();

                paidPatients P = new paidPatients(num,name,d1,d,time,charge);
                paid.add(P);


            }


        }catch (Exception e){

            System.out.println("Error in read!!!");

        }

        try {
            Scanner s = new Scanner(new File("CustomerRegister.txt"));
            while (s.hasNext()) {

                String name = s.nextLine();
                String d = s.nextLine();
                String d1 = s.nextLine();
                String d2 = s.nextLine();
                String d3 = s.nextLine();
                s.nextLine();

                registrationCustomer P = new registrationCustomer(name,d,d1,d2,d3);
                Registration.add(P);


            }


        }catch (Exception e){

            System.out.println("Error in read!!!");

        }


    }

}





