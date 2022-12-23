package ApplicationUI;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class RegisterStudent_controller
{
    Main m = new Main();
    @FXML
    private Button button;

    @FXML
    private Button return_button;
    @FXML
    private TextField Roll_num;

    @FXML
    private Label error_label;

    @FXML
    private TextField name;

    public void register_student(javafx.event.ActionEvent actionEvent)throws IOException {
        error_label.setText("");
        if (name.getText().isEmpty() || name.getText() == null)
        {
            error_label.setText("Kindly enter details!");
        }
        if (Roll_num.getText().isEmpty() || Roll_num.getText() == null)
        {
            error_label.setText("Kindly enter details!");
        }
        else
        {
            error_label.setText("Student has been successfully registered");
          //  Hostel hostel = new Hostel();
            Hostel.getInstance().register_student(name.getText(), Roll_num.getText(),0,0);
        }
    }
    public void return_back() throws IOException {
        m.changeScene("welcome.fxml");
    }
}
