package ApplicationUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class feespaycontroller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    Main m = new Main();

    //Hostel h = new Hostel();

    @FXML
    private TextField accno;

    @FXML
    private TextField amnt;

    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    private Button signout;

    @FXML
    void payfee(ActionEvent event) {
        boolean feestatus;
        feestatus = Hostel.getInstance().payfees(calcandpayfeecontroller.getFees(),accno.getText().toString());
        if(feestatus == true)
        {
            label.setText("Fee Paid Successfully");
        }
        else {
            label.setText("Fee not Paid");
        }
    }
    @FXML
    void logout(ActionEvent event) throws IOException {
        m.changeScene("signin.fxml");
    }
    public void return_button(ActionEvent event)throws IOException
    {
        m.changeScene("calcandpayfee.fxml");
    }

    @FXML
    void initialize() {
        assert accno != null : "fx:id=\"accno\" was not injected: check your FXML file 'payfees.fxml'.";
        assert amnt != null : "fx:id=\"amnt\" was not injected: check your FXML file 'payfees.fxml'.";
        assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'payfees.fxml'.";

    }

}
