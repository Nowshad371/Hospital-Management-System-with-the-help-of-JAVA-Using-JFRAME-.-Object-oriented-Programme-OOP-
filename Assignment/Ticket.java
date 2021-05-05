package Assignment;

public class Ticket{
    private int number;
    private String name;
    private String doctor;
    private String time;
    private double charge;
    private String date;

    public Ticket(int nu,String n,String doc, String d, String t, double c) {
        this.doctor = doc;
        this.number = nu;
        this.name = n;
        this.time = t;
        this.charge = c;
        this.date = d;


    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getCharge() {
        return this.charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}