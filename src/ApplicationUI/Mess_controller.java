package ApplicationUI;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;

public class Mess_controller
{
    @FXML
    private Label label_item_add_name;
    @FXML
    private Label label_item_add_price;
    @FXML
    private Label label_item_del_id;
    @FXML
    private Label label_item_update_id;
    @FXML
    private Label label_item_update_price;
    @FXML
    private TextField text_item_add_name;
    @FXML
    private TextField text_item_add_price;
    @FXML
    private TextField text_item_del_id;
    @FXML
    private TextField text_item_up_id;
    @FXML
    private TextField text_item_up_price;
    @FXML
    private Button add;
    @FXML
    private Button del;
    @FXML
    private Button update;
    @FXML
    private Button return_button;
    @FXML
    private TableView<items> table;
    Main m = new Main();
   // Hostel hostel = new Hostel();
    public void add_item()
    {
        boolean check = false;
        if (text_item_add_name.getText().isEmpty() || text_item_add_name.getText() == null)
        {
            label_item_add_name.setText("Please enter item name!");
        }
        if (text_item_add_price.getText().isEmpty() || text_item_add_price.getText() == null)
        {
            label_item_add_price.setText("Please enter item price!");
        }
        else
        {
            label_item_add_name.setText("");
            label_item_add_price.setText("");
            int price = Integer.parseInt(text_item_add_price.getText());
            check = Hostel.getInstance().check_item(text_item_add_name.getText());
            if (check == true)
            {
                label_item_add_name.setText("This Item already exits in Mess!");
            }
            else
            {
                label_item_add_name.setText("");
                Hostel.getInstance().add_item(text_item_add_name.getText(), price);

            }
        }
    }
    public void update()
    {
        boolean check = false;

        if(text_item_up_id.getText().isEmpty() || text_item_up_id.getText() == null)
        {
            label_item_update_id.setText("Please enter item id!");
        }
        if (text_item_up_price.getText().isEmpty() || text_item_up_price.getText() == null)
        {
            label_item_update_price.setText("Please enter item price!");
        }
        else
        {
            int item_id = Integer.parseInt(text_item_up_id.getText());
            int item_price = Integer.parseInt(text_item_up_price.getText());


            check = Hostel.getInstance().check_item_id(item_id);
            if (check == true) {
                Hostel.getInstance().update_item(item_id, item_price);
                label_item_update_id.setText("The Item is successfully updated!");

            } else {
                label_item_update_id.setText("The item with this id doesn't exists");
            }
        }
    }
    public void remove_item()
    {
        if(text_item_del_id.getText().isEmpty() || text_item_del_id.getText() == null)
        {
            label_item_del_id.setText("Please enter item id");
        }
        else
        {
            boolean check = false;
            int id = Integer.parseInt(text_item_del_id.getText());

            label_item_del_id.setText("");
            check = Hostel.getInstance().check_item_id(id);
            if(check == false)
            {
                label_item_del_id.setText("Item with this id doesn't exist!");
            }
            else
            {
                label_item_del_id.setText("Item is successfully removed!");
                Hostel.getInstance().remove_item(id);
            }

        }
    }

    public void return_back()throws IOException
    {
        m.changeScene("welcome.fxml");
    }
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

}
