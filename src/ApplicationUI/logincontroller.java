package ApplicationUI;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class logincontroller {

    //Hostel h = new Hostel();
    Main m = new Main();
    private String ID,PW;
    @FXML private Button button;
    @FXML private TextField id;
    @FXML private TextField password;
    public void onbuttonpressed(ActionEvent event) throws IOException {
        boolean status;

        status = Hostel.getInstance().authentication(id.getText().toString(),password.getText().toString());
        //button.setVisible(false);
        //label.setVisible(true);
        if(status == true)
        {
            //ID = id.getText().toString();
            //PW = password.getText().toString();

            m.changeScene("options.fxml");
        }
        else
        {
            System.out.printf("unsuccessful login");
        }
    }
    public void return_button(ActionEvent event)throws IOException
    {
        m.changeScene("Starting_Screen.fxml");
    }
    /*public String getid()
    {
        return ID;
    }
    public String getpw()
    {
        return PW;
    }*/
}
