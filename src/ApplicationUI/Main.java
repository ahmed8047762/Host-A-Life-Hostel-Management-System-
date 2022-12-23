package ApplicationUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stg;
    public static void make_admin()
    {
        Admin_DB db = new Admin_DB();
        db.write();
    }
    public static Integer getStudid() {
        return studid;
    }

    public static void setStudid(Integer studid) {
        Main.studid = studid;
    }

    private static Integer studid = null;


    @Override
    public void start(Stage primaryStage) {
        try {
            stg = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("Starting_Screen.fxml"));
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setTitle("Host-A-Life");
            primaryStage.setScene(scene);
            primaryStage.show();
            root.requestFocus();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Main.class.getResource(fxml));
        Scene scene = new Scene(pane,600,400);
        stg.setScene(scene);
        //stg.getScene().setRoot(pane);
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
        //System.out.println("hello");
        //obj.mainfunction();
    }
}
