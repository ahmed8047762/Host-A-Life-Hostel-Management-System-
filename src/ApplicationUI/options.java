package ApplicationUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class options {
    Main m = new Main();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button1;

    @FXML
    private Button button2;
    @FXML
    private Button signout;

    @FXML
    void calcandpayfeesoption(ActionEvent event) throws IOException {
        m.changeScene("calcandpayfee.fxml");
    }

    @FXML
    void messoption(ActionEvent event) throws IOException {
    m.changeScene("mess.fxml");
    }
    @FXML
    void logout(ActionEvent event) throws IOException {
        m.changeScene("signin.fxml");
    }
    public void return_button(ActionEvent event)throws IOException
    {
        m.changeScene("signin.fxml");
    }

    @FXML
    void initialize() {
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'options.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'options.fxml'.";
    }

}

