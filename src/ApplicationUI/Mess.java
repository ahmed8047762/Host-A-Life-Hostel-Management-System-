package ApplicationUI;

import java.sql.*;
import java.util.Hashtable;
import java.util.List;

public class Mess {
    Mess_DB mess_db = new Mess_DB();
    private int item_id;
    private String item_name;
    private int item_price;
    private static Mess instance = null;
    private Mess()
    {

    }
    public static synchronized Mess getInstance()
    {
        if(instance == null)
        {
            instance = new Mess();
        }
        return instance;
    }

    private Hashtable<String, Integer> itemNprice = new Hashtable<String, Integer>();
    private Hashtable<Integer, String> idNname = new Hashtable<Integer, String>();
    public Hashtable<String, Integer> itemNpricetablereturner()
    {
        String itemname;
        int itemprice;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hmsdb","root","1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from mess");
            while(rs.next())
            {
                itemNprice.put(rs.getString("item_name"),rs.getInt("item_price"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return itemNprice;
    }


    public void add_item(String name,int price)
    {
        mess_db.add_item(name,price);
    }
    public boolean check_item(String name)
    {
        return mess_db.check_item(name);
    }
    public boolean check_item_id(int id)
    {
        return mess_db.check_item_id(id);
    }
    public void update_item(int id,int price)
    {
        mess_db.update(id,price);
    }
    public void remove_item(int id)
    {
        mess_db.remove_item(id);
    }
}
