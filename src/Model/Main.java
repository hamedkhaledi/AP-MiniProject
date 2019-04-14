package Model;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PageLoader.initStage(primaryStage);
        new PageLoader().load("../View/sample.fxml");

    }


    public static void main(String[] args) {
        launch(args);
    }

    {//TODO
        Student TEMP1 = new Student();
        TEMP1.Username = "c";
        TEMP1.Password = "c";
        Admin.Students.add(TEMP1);
        Teacher Temp = new Teacher();
        Temp.Username = "a";
        Temp.Password = "a";
        ClassRoom ClassTemp = new ClassRoom();
        ClassTemp.Name = "Class1";
        Temp.classRooms.add(ClassTemp);
        Temp.classRooms.get(0).Students.add(TEMP1);
        Admin.Teachers.add(Temp);
        Teacher Temp2 = new Teacher();
        Temp2.Username = "b";
        Temp2.Password = "b";
        Admin.Teachers.add(Temp2);
        Student TEMP2 = new Student();
        TEMP2.Username = "d";
        TEMP2.Password = "d";
        Admin.Students.add(TEMP2);

    }
}
