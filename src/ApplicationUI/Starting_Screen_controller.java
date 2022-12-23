package ApplicationUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Starting_Screen_controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    Main m = new Main();
    @FXML
    void admin_screen(ActionEvent event) throws IOException
    {
        m.changeScene("login_admin.fxml");
    }

    @FXML
    void student_screen(ActionEvent event)throws IOException
    {
        m.changeScene("signin.fxml");
    }

    @FXML
    void initialize() {

    }

}
