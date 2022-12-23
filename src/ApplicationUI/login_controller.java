package ApplicationUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class login_controller {

    Main m = new Main();
    Admin_DB db = new Admin_DB();
    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    public Button show_btn;

    public void Welcome_Screen() throws IOException {

        m.changeScene("welcome.fxml");
    }
    public void admin_check(javafx.event.ActionEvent actionEvent) throws IOException
    {
        Admin admin = new Admin();
        admin = db.read();
        String name = admin.getName();
        String pass = admin.getPass();
        if (name.equals(username.getText()) && pass.equals(password.getText()))
        {
                Welcome_Screen();
        }

    }
    public void return_button(ActionEvent event)throws IOException
    {
        m.changeScene("Starting_Screen.fxml");
    }
}
