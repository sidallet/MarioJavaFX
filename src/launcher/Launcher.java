package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.manager.Manager;
import viewManage.ManagerView;


public class Launcher extends Application {
    private  static Manager man;
    private  static ManagerView manView;

    static {
        try {
            man = new Manager();
            manView = new ManagerView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Manager getManager() {
        return man;
    }
    public static ManagerView getManagerView() {
        return manView;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        //ManagerView managerView = new ManagerView();
        Parent racine = FXMLLoader.load(getClass().getResource("/FXML/MainWindow.fxml"));
        Scene scene = new Scene(racine);
        scene.getStylesheets().add(getClass().getResource("/CSS/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();



    }



}

