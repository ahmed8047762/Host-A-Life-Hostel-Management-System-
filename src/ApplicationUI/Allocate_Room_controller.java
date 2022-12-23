package ApplicationUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Allocate_Room_controller
{

    @FXML
    private Label seat1;
    @FXML
    private Label seat2;
    @FXML
    private Label seat3;
    @FXML
    private TextField student_name;
    @FXML
    private Label sname;
    @FXML
    private TextField s_id;
    @FXML
    private Label sid;
    @FXML
    private TextField r_id;
    @FXML
    private Label rid;
    @FXML
    private TextField s_no;
    @FXML
    private Label seatno;
    @FXML
    private Button button;
    @FXML
    private Button r_button;

    Main m = new Main();
//    Hostel hostel = new Hostel();

    Student_DB student_db = new Student_DB();
    Room_DB room_db = new Room_DB();
   // Student s = new Student();
    public Allocate_Room_controller(){}

    public void check_room_availability()
    {
        if ((student_name.getText().isEmpty() || student_name.getText() == null))
        {
            student_name.setText("Please enter a name!");
        }
        if ((s_id.getText().isEmpty() || s_id.getText() == null))
        {
            s_id.setText("Please enter student id!");
        }
        if (r_id.getText().isEmpty() || r_id.getText() == null)
        {
            r_id.setText("Please enter room id!");
        }
        if (s_no.getText().isEmpty() || s_no.getText() == null)
        {
            s_no.setText("Please enter seat number!");
        }
        else {
            boolean check = false;
            int i = Integer.parseInt(s_no.getText());
            check = Hostel.getInstance().check_student(s_id.getText());
            System.out.println(Student.getInstance().getName());
            System.out.println(Student.getInstance().getId());
            if (check == false)
            {
                rid.setText("Student has not been registered!");
            } else
            {
                rid.setText("");
                int room[] = new int[]{};

                int id = Integer.parseInt(r_id.getText());
                room = Hostel.getInstance().check_room_availability(id);
                check = Hostel.getInstance().check_room(s_id.getText());
                if (check == true)
                    seat1.setText("This User has already existed room!");
                else {


                    seat1.setText("");
                    if (room[i - 1] == 1) {
                        seat1.setText("This Seat Is Already Occupied");
                    } else {
                        Hostel.getInstance().Allocate_Room(s_id.getText(), r_id.getText(), s_no.getText());
                        seat1.setText("Seat has been successfully allocated");
                    }
                }
            }
        }
    }
        public void return_back() throws IOException {
            m.changeScene("welcome.fxml");
        }
}
