package ApplicationUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class welcome_controller {

    Main m = new Main();
    @FXML
    private Button button;

    @FXML
    void Register_Student_Screen(ActionEvent event) throws IOException {
        m.changeScene("Register_Student.fxml");
    }
    @FXML
    void Room_Availability_Screen(ActionEvent event)throws IOException
    {
        m.changeScene("Room_Availability.fxml");
    }
    @FXML
    void Allocate_Room_Screen(ActionEvent event)throws IOException
    {
        m.changeScene("Allocate_Room.fxml");
    }
    @FXML
    void Manage_Mess_Screen(ActionEvent event)throws IOException
    {
        m.changeScene("Manage_Mess.fxml");
    }
    @FXML
    void return_back(ActionEvent event)throws  IOException
    {
        m.changeScene("login_admin.fxml");
    }

}
