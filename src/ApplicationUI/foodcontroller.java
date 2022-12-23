package ApplicationUI;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.Set;

import com.sun.javafx.stage.EmbeddedWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class foodcontroller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //Mess m = new Mess();
    Main m1 = new Main();
    //Hostel h = new Hostel();

    @FXML
    private Button button;

    @FXML
    private TextField entereditem;
    @FXML
    private TableView<items> table;
    @FXML
    private Label label;
    @FXML
    private Button signout;

    @FXML
    void initialize() {
        //assert itemname != null : "fx:id=\"itemname\" was not injected: check your FXML file 'mess.fxml'.";
        //assert itemprice != null : "fx:id=\"itemprice\" was not injected: check your FXML file 'mess.fxml'.";
        //assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'mess.fxml'.";

        Hashtable itemNprice = Mess.getInstance().itemNpricetablereturner();

        TableColumn<items, String> itemname=new TableColumn<>("Item Name");
        TableColumn<items, String> itemprice=new TableColumn<>("Item Price");
        itemname.setCellValueFactory(new PropertyValueFactory<>("itemname"));
        itemprice.setCellValueFactory(new PropertyValueFactory<>("itemprice"));

        table.getColumns().add(itemname);
        table.getColumns().add(itemprice);

        Set<String> setofkeys = itemNprice.keySet();

        for(String key : setofkeys)
        {
            table.getItems().add(new items(key,itemNprice.get(key).hashCode()));
        }
    }
    @FXML
    void itementered(ActionEvent event) {
        String item = entereditem.getText().toString();
        Boolean status;

        status = Hostel.getInstance().addtofees(item);

        if(status == true)
        {
            label.setText("Order has been placed successfully. Pick it up in 15 minutes");
        }
        else {
            label.setText("You entered wrong item. Type it again");
        }
    }
    @FXML
    void logout(ActionEvent event) throws IOException {
        m1.changeScene("options.fxml");
    }
}
