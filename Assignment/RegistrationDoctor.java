package Assignment;

public class RegistrationDoctor {

    private String name;
    private String password;
    private String data1;
    private String data2;
    private String data3;


    public RegistrationDoctor(String name, String password,String data1,String data2,String data3) {
        this.name = name;
        this.password = password;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }

    public RegistrationDoctor(String name, String data1, String data2, String data3) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }
}
