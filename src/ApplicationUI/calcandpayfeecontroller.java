package ApplicationUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class calcandpayfeecontroller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private static Integer fees = null;

    public static Integer getFees() {
        return fees;
    }

    public static void setFees(Integer fees) {
        calcandpayfeecontroller.fees = fees;
    }

    Main m = new Main();



    //Hostel h = new Hostel();

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Label label1;

    @FXML
    private Label label2;
    @FXML
    private Button signout;

    @FXML
    void calcfees(ActionEvent event) {
        fees = Hostel.getInstance().calculatefees();
         if(fees != -1)
         {
             label1.setText("Fees = "+fees);
         }
         else
         {
             label1.setText("Wrong ID");
         }
    }

    @FXML
    void payfees(ActionEvent event) throws IOException {
        m.changeScene("payfees.fxml");
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        m.changeScene("signin.fxml");
    }
    public void return_button(ActionEvent event)throws IOException
    {
        m.changeScene("options.fxml");
    }
    @FXML
    void initialize() {
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'calcandpayfee.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'calcandpayfee.fxml'.";
        assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'calcandpayfee.fxml'.";
        assert label2 != null : "fx:id=\"label2\" was not injected: check your FXML file 'calcandpayfee.fxml'.";

    }

}