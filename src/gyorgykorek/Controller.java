package gyorgykorek;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Random;

public class Controller extends Main{
    //Buttons
    public Button btnLifthivas;
    public Button btnAllomasmegadas;
    public Button btnLifthivas1;
    public Button btnLifthivas11;
    public Button processClear;
    public Button logclearBtn;

    //Sliders
    public Slider Slider1;
    public Slider Slider2;

    //Szövegek
    public Label allomasNoticeLabel;
    public Label CelLabel;
    public Label allomas1label;
    public Label allomas2label;
    public Label allomas3label;
    public Label allomas4label;
    public Label allomas5label;


    //Textfield
    public TextField actualfloorField;
    public TextField TFallomas;
    public TextField actualpersonField;
    public TextField actualKG;
    public TextArea logField;
    public TextArea liftProcess;
    //allomasok
    public TextField tfallomas1;
    public TextField tfallomas2;
    public TextField tfallomas3;
    public TextField tfallomas4;
    public TextField tfallomas5;


    //FXML indításakor inicializáló metódus
    public void initialize(){
        System.out.println("Elevator Management 1.0.0");
        sliders();
        String liftproc = "Lift 1 : "+Main.elist.get(0).getActualfloor()+" emeleten.\r\nLift 2 : "+Main.elist.get(1).getActualfloor()+" emeleten.";
        liftProcess.setText(liftproc);

    }

    //Sliderek kezdő pozíciójának meghatározása (initialize hívja meg)
    public void sliders(){
        Slider1.setValue(Main.elist.get(0).getActualfloor());
        Slider2.setValue(Main.elist.get(1).getActualfloor());
        Slider1.setStyle("-fx-control-inner-background: gray;");
        Slider2.setStyle("-fx-control-inner-background: gray;");
    }

    //Segítség menüpont alatti gombok funkcióinak megnyitása
    public void emailSend(){
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://mail.google.com/mail/?view=cm&fs=1&to=korekgyorgy@gmail.com&su=Elevator_Manager_1.0.0_visszajelzés&body=BODY&cc=korekgyorgy@icloud.com"));
            logField.setStyle("-fx-text-inner-color: green;");
            logField.setText(logField.getText()+"E-mail megnyitva. Köszönöm a visszajelzést!\n");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    public void linkedinOpen(){
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.linkedin.com/in/gy%C3%B6rgy-korek/"));
            logField.setStyle("-fx-text-inner-color: blue;");
            logField.setText(logField.getText()+"LinkedIn profilom megnyitva,több Java és PowerPlatform projectem megtalálható publikációk/projektek alatt!\n");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    public void readmeClick(){
        try {
            File myFile = new File("Elevator_ManagerFx_dokumentacio_BPVKMQ.pdf");
            Desktop.getDesktop().open(myFile);
            logField.setStyle("-fx-text-inner-color: green;");
            logField.setText(logField.getText()+"JavaFx alapú Elevator Manager dokumentációja megnyitva!\n");
        } catch (IOException ex) {
        }
    }

    //Log/Process TextArea ürítése
    public void processclearClick(){
        liftProcess.setText("");
    }
    public void logclearClick(){
        logField.setText("");
    }

    //Lift hívása button
    public void liftHandleButtonClick(){
        try {
            if (actualfloorField.getText().isEmpty()||actualpersonField.getText().isEmpty()||actualKG.getText().isEmpty()){
                logField.setStyle("-fx-text-inner-color: red;");
                logField.setText(logField.getText()+"Üresen hagytad a mezőket vagy betűket írtál be, kérlek töltsd ki megfelelően!\n"); }
            else if(Integer.parseInt(actualfloorField.getText())>10 || Integer.parseInt(actualfloorField.getText())<0){
                logField.setStyle("-fx-text-inner-color: red;");
                logField.setText(logField.getText()+"Helytelen értéket adtál meg a szintnek, kérlek 0-10 közötti számot adj meg!\n");
            }
            else if (Integer.parseInt(actualKG.getText())>999 || Integer.parseInt(actualKG.getText())<1){
                logField.setStyle("-fx-text-inner-color: red;");
                logField.setText(logField.getText()+"Helytelen értéket adtál meg a össztömegnek, 0kg-al, vagy 999kg fölött nem indul el a lift!\n");
            }
            else if (Integer.parseInt(actualpersonField.getText())>5 || Integer.parseInt(actualpersonField.getText())<1){
                logField.setStyle("-fx-text-inner-color: red;");
                logField.setText(logField.getText()+"Üresen nem indul el a lift, valamint 5 fő felett sem!\n");
            }
            else{
                if (Integer.parseInt(actualpersonField.getText())==1){
                    tfallomas1.visibleProperty().setValue(true);
                    allomas1label.setVisible(true);
                }
                else if (Integer.parseInt(actualpersonField.getText())==2){
                    tfallomas1.visibleProperty().setValue(true);
                    allomas1label.setVisible(true);
                    tfallomas2.visibleProperty().setValue(true);
                    allomas2label.setVisible(true);
                }
                else if (Integer.parseInt(actualpersonField.getText())==3){
                    tfallomas1.visibleProperty().setValue(true);
                    allomas1label.setVisible(true);
                    tfallomas2.visibleProperty().setValue(true);
                    allomas2label.setVisible(true);
                    tfallomas3.visibleProperty().setValue(true);
                    allomas3label.setVisible(true);
                }
                else if (Integer.parseInt(actualpersonField.getText())==4){
                    tfallomas1.visibleProperty().setValue(true);
                    allomas1label.setVisible(true);
                    tfallomas2.visibleProperty().setValue(true);
                    allomas2label.setVisible(true);
                    tfallomas3.visibleProperty().setValue(true);
                    allomas3label.setVisible(true);
                    tfallomas4.visibleProperty().setValue(true);
                    allomas4label.setVisible(true);
                }
                else if (Integer.parseInt(actualpersonField.getText())==5){
                    tfallomas1.visibleProperty().setValue(true);
                    allomas1label.setVisible(true);
                    tfallomas2.visibleProperty().setValue(true);
                    allomas2label.setVisible(true);
                    tfallomas3.visibleProperty().setValue(true);
                    allomas3label.setVisible(true);
                    tfallomas4.visibleProperty().setValue(true);
                    allomas4label.setVisible(true);
                    tfallomas5.visibleProperty().setValue(true);
                    allomas5label.setVisible(true);
                }
                //Első 3 gomb letiltása
                actualpersonField.setEditable(false);
                actualKG.setEditable(false);
                actualfloorField.setEditable(false);

                logField.setStyle("-fx-text-inner-color: green;");
                logField.setText(logField.getText()+"Add meg kérlek a célállomást!\n");
                Slider1.setValue(Main.elist.get(0).getActualfloor());
                CelLabel.visibleProperty().setValue(true);
                Main.floorrequest = Integer.parseInt(actualfloorField.getText());
                btnLifthivas.setDisable(true);
                btnLifthivas1.setDisable(false);
            }
        } catch (Exception e) {
            logField.setStyle("-fx-text-inner-color: red;");
            logField.setText(logField.getText()+"Kérlek ne betűket adj meg értéknek!\n");
        }


    }

    //Állomás megadás button
    public void allomasMegadasClick() throws InterruptedException {
        logField.setStyle("-fx-text-inner-color: green;");
        Person obj = new Person();
        Person obj2 = new Person();
        Person obj3 = new Person();
        Person obj4 = new Person();
        Person obj5 = new Person();
        try {

            if (tfallomas1.getText().isEmpty()&&Integer.parseInt(actualpersonField.getText())==1||tfallomas2.getText().isEmpty()&&Integer.parseInt(actualpersonField.getText())==2||tfallomas3.getText().isEmpty()&&Integer.parseInt(actualpersonField.getText())==3||tfallomas4.getText().isEmpty()&&Integer.parseInt(actualpersonField.getText())==4||tfallomas5.getText().isEmpty()&&Integer.parseInt(actualpersonField.getText())==5){
                plist.clear();
                logField.setStyle("-fx-text-inner-color: red;");
                logField.setText(logField.getText()+"Valamelyik állomás mezője üres. Adj meg értéket 0-10 között!\n");
            }

            else if (Integer.parseInt(actualpersonField.getText())==1&&Integer.parseInt(tfallomas1.getText())>=0&&Integer.parseInt(tfallomas1.getText())<11){
                plist.clear();
                obj.setPid(0);
                obj.setDestination(Integer.parseInt(tfallomas1.getText()));
                plist.add(obj);
                destinationOK();
                logField.setText("A lift leszállított sikeresen 1 utast.");
            }
            else if (Integer.parseInt(actualpersonField.getText())==2&&Integer.parseInt(tfallomas1.getText())>=0&&Integer.parseInt(tfallomas1.getText())<11&&Integer.parseInt(tfallomas2.getText())>=0&&Integer.parseInt(tfallomas2.getText())<11){
                plist.clear();
                obj.setPid(0);
                obj.setDestination(Integer.parseInt(tfallomas1.getText()));
                plist.add(obj);
                obj2.setPid(1);
                obj2.setDestination(Integer.parseInt(tfallomas2.getText()));
                plist.add(obj2);
                destinationOK();
                logField.setText("A lift leszállított sikeresen 2 utast.");
            }
            else if (Integer.parseInt(actualpersonField.getText())==3&&Integer.parseInt(tfallomas1.getText())>=0&&Integer.parseInt(tfallomas1.getText())<11&&Integer.parseInt(tfallomas2.getText())>=0&&Integer.parseInt(tfallomas2.getText())<11&&Integer.parseInt(tfallomas3.getText())>=0&&Integer.parseInt(tfallomas3.getText())<11){
                plist.clear();
                obj.setPid(0);
                obj.setDestination(Integer.parseInt(tfallomas1.getText()));
                plist.add(obj);
                obj2.setPid(1);
                obj2.setDestination(Integer.parseInt(tfallomas2.getText()));
                plist.add(obj2);
                obj3.setPid(2);
                obj3.setDestination(Integer.parseInt(tfallomas3.getText()));
                plist.add(obj3);
                destinationOK();
                logField.setText("A lift leszállított sikeresen 3 utast.");
            }
            else if (Integer.parseInt(actualpersonField.getText())==4&&Integer.parseInt(tfallomas1.getText())>=0&&Integer.parseInt(tfallomas1.getText())<11&&Integer.parseInt(tfallomas2.getText())>=0&&Integer.parseInt(tfallomas2.getText())<11&&Integer.parseInt(tfallomas3.getText())>=0&&Integer.parseInt(tfallomas3.getText())<11&&Integer.parseInt(tfallomas4.getText())>=0&&Integer.parseInt(tfallomas4.getText())<11){
                plist.clear();
                obj.setPid(0);
                obj.setDestination(Integer.parseInt(tfallomas1.getText()));
                plist.add(obj);
                obj2.setPid(1);
                obj2.setDestination(Integer.parseInt(tfallomas2.getText()));
                plist.add(obj2);
                obj3.setPid(2);
                obj3.setDestination(Integer.parseInt(tfallomas3.getText()));
                plist.add(obj3);
                obj4.setPid(3);
                obj4.setDestination(Integer.parseInt(tfallomas4.getText()));
                plist.add(obj4);
                destinationOK();
                logField.setText("A lift leszállított sikeresen 4 utast.");
            }
            else if (Integer.parseInt(actualpersonField.getText())==5&&Integer.parseInt(tfallomas1.getText())>=0&&Integer.parseInt(tfallomas1.getText())<11&&Integer.parseInt(tfallomas2.getText())>=0&&Integer.parseInt(tfallomas2.getText())<11&&Integer.parseInt(tfallomas3.getText())>=0&&Integer.parseInt(tfallomas3.getText())<11&&Integer.parseInt(tfallomas4.getText())>=0&&Integer.parseInt(tfallomas4.getText())<11&&Integer.parseInt(tfallomas5.getText())>=0&&Integer.parseInt(tfallomas5.getText())<11){
                plist.clear();
                obj.setPid(0);
                obj.setDestination(Integer.parseInt(tfallomas1.getText()));
                plist.add(obj);
                obj2.setPid(1);
                obj2.setDestination(Integer.parseInt(tfallomas2.getText()));
                plist.add(obj2);
                obj3.setPid(2);
                obj3.setDestination(Integer.parseInt(tfallomas3.getText()));
                plist.add(obj3);
                obj4.setPid(3);
                obj4.setDestination(Integer.parseInt(tfallomas4.getText()));
                plist.add(obj4);
                obj5.setPid(4);
                obj5.setDestination(Integer.parseInt(tfallomas5.getText()));
                plist.add(obj5);
                destinationOK();
                logField.setText("A lift leszállított sikeresen 5 utast.");
            }
            else{
                logField.setStyle("-fx-text-inner-color: red;");
                logField.setText(logField.getText()+"Kérlek 0-10 közötti értéket adj meg!\n");
                plist.clear();
            }

        } catch (Exception e) {
            logField.setStyle("-fx-text-inner-color: red;");
            System.out.println(e);
            logField.setText(logField.getText()+"Kérlek 0-10 közötti értéket adj meg, ne betűket!\n");
            plist.clear();
        }

    }
    public void destinationOK() throws InterruptedException {
        tfallomas1.setEditable(false);
        tfallomas2.setEditable(false);
        tfallomas3.setEditable(false);
        tfallomas4.setEditable(false);
        tfallomas5.setEditable(false);
        btnAllomasmegadas.setDisable(true);
        btnLifthivas1.setDisable(true);
        btnLifthivas11.setVisible(true);
        decisiontree(elist);
    }
    //újra button
    public void returner(){
        actualfloorField.setText("");
        actualfloorField.setEditable(true);

        actualpersonField.setText("");
        actualpersonField.setEditable(true);

        actualKG.setText("");
        actualKG.setEditable(true);

        btnLifthivas.setDisable(false);

        tfallomas1.setText("");
        tfallomas1.setEditable(true);
        tfallomas1.visibleProperty().setValue(false);

        tfallomas2.setText("");
        tfallomas2.setEditable(true);
        tfallomas2.visibleProperty().setValue(false);

        tfallomas3.setText("");
        tfallomas3.setEditable(true);
        tfallomas3.visibleProperty().setValue(false);

        tfallomas4.setText("");
        tfallomas4.setEditable(true);
        tfallomas4.visibleProperty().setValue(false);

        tfallomas5.setText("");
        tfallomas5.setEditable(true);
        tfallomas5.visibleProperty().setValue(false);

        allomasNoticeLabel.setVisible(false);
        allomas1label.setVisible(false);
        allomas2label.setVisible(false);
        allomas3label.setVisible(false);
        allomas4label.setVisible(false);
        allomas5label.setVisible(false);
        logField.setText("");
        plist.clear();

    }

    //Folyamati vezérlő metódusok

    //Döntési ág, Lift1Way vagy Lift2Way metódus indítása
    public void decisiontree(ArrayList<Elevator> elist) throws InterruptedException {

        //Lift 2 indul
        if (Math.abs(elist.get(0).getActualfloor()-floorrequest)> Math.abs(elist.get(1).getActualfloor()-floorrequest)||Math.abs(elist.get(0).getActualfloor()-floorrequest)== Math.abs(elist.get(1).getActualfloor()-floorrequest)&&elist.get(1).getActualfloor()<floorrequest)
        {
            Main.elist.get(1).setActualPerson(Integer.parseInt(actualpersonField.getText()));
            Main.elist.get(1).setActualKG(Integer.parseInt(actualKG.getText()));
            elist.get(1).setAlltracker(elist.get(1).getAlltracker()+Math.abs(elist.get(1).getActualfloor()-floorrequest));
            Lift2Way(elist);
        }
        //Lift 1 indul
        else if(Math.abs(elist.get(0).getActualfloor()-floorrequest)< Math.abs(elist.get(1).getActualfloor()-floorrequest)||Math.abs(elist.get(0).getActualfloor()-floorrequest)== Math.abs(elist.get(1).getActualfloor()-floorrequest)&&elist.get(0).getActualfloor()<floorrequest||elist.get(0).getActualfloor() == elist.get(1).getActualfloor()){
            Main.elist.get(0).setActualPerson(Integer.parseInt(actualpersonField.getText()));
            Main.elist.get(0).setActualKG(Integer.parseInt(actualKG.getText()));
            elist.get(0).setAlltracker(elist.get(0).getAlltracker()+Math.abs(elist.get(0).getActualfloor()-floorrequest));
            Lift1Way(elist);
        }
    }

    //Plist indexfix, CalculateA indítása,for ciklus szerinti számban
    public void Lift1Way(ArrayList<Elevator>elist) throws InterruptedException {
        elist.get(0).setActualfloor(floorrequest);
        liftProcess.setText(liftProcess.getText()+"\n\n1. lift elindult a(z) "+floorrequest + " emeletre...");
        elist.get(0).setAlltracker(elist.get(0).getTracker()+elist.get(0).getAlltracker());
        if (elist.get(0).getActualKG()>elist.get(0).getMaximumKG()){
            System.out.println("A liftben tartózkodók össztömege magasabb mint a megengedett, nem indul el a lift!");
        }
        else if (elist.get(0).getActualPerson()>elist.get(0).getMaximumPerson()){
            System.out.println("Több mint 5 ember tartózkodik a liftben, nem indul el a lift!");
        }
        Person objfix = new Person();
        objfix.setPid(plist.size()+1);
        objfix.setDestination(99);
        plist.add(objfix);
        for (int i = 0; i < elist.get(0).getActualPerson(); i++) {
            calculateA(elist, plist);
            //Thread.sleep(2000);

        }


    }

    //Plist indexfix, CalculateB indítása,for ciklus szerinti számban
    public void Lift2Way(ArrayList<Elevator>elist) throws InterruptedException {
        elist.get(1).setActualfloor(floorrequest);
        liftProcess.setText(liftProcess.getText()+"\n\n2. lift elindult a(z) "+floorrequest + " emeletre...");
        elist.get(1).setAlltracker(elist.get(1).getTracker()+elist.get(1).getAlltracker());
        if (elist.get(1).getActualKG()>elist.get(1).getMaximumKG()){
            System.out.println("A liftben tartózkodók össztömege magasabb mint a megengedett, nem indul el a lift!");
        }
        else if (elist.get(1).getActualPerson()>elist.get(1).getMaximumPerson()){
            System.out.println("Több mint 5 ember tartózkodik a liftben, nem indul el a lift!");
        }
        Person objfix = new Person();
        objfix.setPid(plist.size()+1);
        objfix.setDestination(99);
        plist.add(objfix);
        for (int i = 0; i < elist.get(1).getActualPerson(); i++) {
            calculateB(elist, plist);
            //Thread.sleep(2000);

        }


    }

    //Lift1 ideális útjának kalkulációja és folyamati vezérlője
    public void calculateA(ArrayList<Elevator> elist, ArrayList<Person>plist) throws InterruptedException {

        //ideális út megtalálása
        int bestDestWayMIN = 99;
        floorindex = elist.get(0).getActualfloor();
        int destinationClearindex = 99;

        for (int i = 0; i < plist.size()-1; i++) {
            if (bestDestWayMIN>Math.abs(elist.get(0).getActualfloor()-plist.get(i).getDestination())){
                bestDestWayMIN = Math.abs(elist.get(0).getActualfloor()-plist.get(i).getDestination());
                floorindex = plist.get(i).getDestination();
                destinationClearindex = i;
            }
            else if (bestDestWayMIN==99){
                System.out.println("99 index");
            }

        }
        int DestFinal = floorindex;
        Slider1.setValue(floorindex);
        //Thread.sleep(1000);

        int DestWaySize = bestDestWayMIN;
        elist.get(0).setTracker(elist.get(0).getTracker()+DestWaySize);
        if (bestDestWayMIN == 99){
        }
        else
            plist.remove(destinationClearindex);
        elist.get(0).setActualfloor(DestFinal);
        liftProcess.setText(liftProcess.getText()+"\n"+floorindex + " emeletre, " + DestWaySize + " emelet megtételével.");
    }

    //Lift2 ideális útjának kalkulációja és folyamati vezérlője
    public void calculateB(ArrayList<Elevator> elist, ArrayList<Person>plist) throws InterruptedException {

        //ideális út megtalálása
        int bestDestWayMIN = 99;
        floorindex = elist.get(1).getActualfloor();
        int destinationClearindex = 99;

        for (int i = 0; i < plist.size()-1; i++) {
            if (bestDestWayMIN>Math.abs(elist.get(1).getActualfloor()-plist.get(i).getDestination())){
                bestDestWayMIN = Math.abs(elist.get(1).getActualfloor()-plist.get(i).getDestination());
                floorindex = plist.get(i).getDestination();
                destinationClearindex = i;
            }
            else if (bestDestWayMIN==99){
                System.out.println("99 index error");
            }

        }
        int DestFinal = floorindex;
        Slider2.setValue(floorindex);
        //Thread.sleep(1000);

        int DestWaySize = bestDestWayMIN;
        elist.get(1).setTracker(elist.get(1).getTracker()+DestWaySize);
        if (bestDestWayMIN == 99){
        }
        else
            plist.remove(destinationClearindex);
        elist.get(1).setActualfloor(DestFinal);
        liftProcess.setText(liftProcess.getText()+"\n"+floorindex + " emeletre, " + DestWaySize + " emelet megtételével.");
    }

}

