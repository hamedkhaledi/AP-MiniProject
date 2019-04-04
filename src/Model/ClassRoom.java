package Model;


import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    public String Name;
    public int NumberOfUnits;
    public int Capacity;
    public Days Day;
    public time Time;
    public List<Student> Students = new ArrayList<Student>();

    public enum Days {
        Saturday, Sunday, Monday, Tuesday, Wednesday
    }

    public enum time {
        Eight_Ten, Ten_Twelve, Two_Four
    }
}
