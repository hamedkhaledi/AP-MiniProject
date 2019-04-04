package Model;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    public String UserName = "admin";
    public String Password = "admin";
    public static Admin admin = new Admin();
    public static List<Teacher> Teachers = new ArrayList<Teacher>();
    public static List<Student> Students = new ArrayList<Student>();

    public static Admin getAdmin() {
        return admin;
    }

    public Admin() {

    }
}
