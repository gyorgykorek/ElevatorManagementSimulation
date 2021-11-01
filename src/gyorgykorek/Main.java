package gyorgykorek;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;



public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Elevator Manager v1.0.0 - Korek György");
        primaryStage.getIcons().add(new Image("file:elevator.png"));
        primaryStage.setScene(new Scene(root, 780, 580));
        primaryStage.show();
        primaryStage.resizableProperty().setValue(false);
    }

    //statikus változók
    //Liftet használó aktuális utasok listája
    static ArrayList<Person> plist= new ArrayList<>();

    //Lift lista
    static ArrayList<Elevator> elist = new ArrayList<>();

    //Aktuális emelet száma (lift hívásakor)
    static int floorrequest;

    //Aktuális emelet
    static int floorindex;

    public static void main(String[] args){

        //2 lift külön tárolása osztályként, eid = lift azonosítója (1 vagy 2)
        Elevator lift1 = new Elevator();
        lift1.setEid(1);

        //Program valódi környezet kialakításának érdekében a kezdeti szinten random adja a 2 liftnek
        Random rnd = new Random();
        lift1.setActualfloor(rnd.nextInt(10-0)+0);
        elist.add(lift1);

        Elevator lift2 = new Elevator();
        lift2.setEid(2);
        lift2.setActualfloor(rnd.nextInt(10-0)+0);
        elist.add(lift2);

        //JavaFx Gui indítása, Controller.java a folyamati vezérlő
        launch(args);


    }
}
