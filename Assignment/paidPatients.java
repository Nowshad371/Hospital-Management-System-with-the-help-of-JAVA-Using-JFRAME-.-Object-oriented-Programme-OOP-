package Assignment;

public class paidPatients extends Ticket {


    public paidPatients(int nu, String n,String doc,String d, String t, double c) {
        super(nu,n,doc,d,t, c);
    }


    @Override
    public String getDoctor() {
        return super.getDoctor();
    }

    @Override
    public void setDoctor(String doctor) {
        super.setDoctor(doctor);
    }

    @Override
    public String getDate() {
        return super.getDate();
    }

    @Override
    public void setDate(String date) {
        super.setDate(date);
    }

    @Override
    public int getNumber() {
        return super.getNumber();
    }

    @Override
    public void setNumber(int number) {
        super.setNumber(number);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getTime() {
        return super.getTime();
    }

    @Override
    public void setTime(String time) {
        super.setTime(time);
    }

    @Override
    public double getCharge() {
        return super.getCharge();
    }

    @Override
    public void setCharge(double charge) {
        super.setCharge(charge);
    }
}

