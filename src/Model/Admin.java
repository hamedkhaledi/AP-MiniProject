package Model;

public class Admin {
    public String UserName = "admin";
    public String Password = "admin";
    public static Admin admin = new Admin();

    public static Admin getAdmin() {
        return admin;
    }

    public Admin() {

    }
}
