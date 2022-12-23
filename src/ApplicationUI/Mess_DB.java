package ApplicationUI;

import java.sql.*;

public class Mess_DB {
    public Connection con;

    public Mess_DB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsdb", "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void add_item(String name, int price) {
        try {
            String query = "INSERT INTO mess (item_name,item_price) VALUES (?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, price);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Item is added...");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean check_item(String name) {
        boolean check = false;
        try {
            String query = "select * from mess";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("item_name").equals(name)) {
                    check = true;
                    return check;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return check;
    }

    public boolean check_item_id(int id)
    {
        boolean check = false;
        try {
            String query = "select * from mess";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getInt("id") == id)
                {
                    check = true;
                    return check;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return check;
    }
    public void remove_item(int id)
    {
        Statement stm;
        try
        {
            stm = con.createStatement();
            String query = "delete from mess where id = "+id;
            stm.executeUpdate(query);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public void writing(String name,String r_id,String seat)
    {
        int seat_no = Integer.parseInt(seat);
        try
        {
            String query = "INSERT INTO room (seat"+seat_no+") VALUES (?) where id = "+r_id;
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,name);
            int rows = stmt.executeUpdate();
            if (rows > 0)
            {
                System.out.println("Student is added...");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void update(int id,int price)
    {
        Statement stm;
        try
        {
            stm = con.createStatement();
            String query = "update mess set item_price = "+price+" where id = "+id;
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.executeUpdate();

        }
        catch (Exception e)
        {
            System.out.println(e);

        }
    }
    public Room read(int i)
    {
      //  Room room = new Room();
        Statement stm;
        try
        {

            stm = con.createStatement();
            String query = "Select * from room where id = "+i;
            ResultSet rs = stm.executeQuery(query);
            if (rs.next())
            {
                Room.getInstance().setId(rs.getInt(1));
                Room.getInstance().setSeat1(rs.getString(2));
                Room.getInstance().setSeat2(rs.getString(3));
                Room.getInstance().setSeat3(rs.getString(4));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return Room.getInstance();
    }
    public boolean reading_student_in_seats(String id)
    {
        Statement stm;
        try
        {
            boolean flag = false;
            stm = con.createStatement();
            String query = "Select * from room";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next())
            {
                if (rs.getString("seat_sid1").equals(id) || rs.getString("seat_sid2").equals(id) || rs.getString("seat_sid3").equals(id))
                {
                    return true;
                }
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public void close_connection()
    {
        try
        {
            con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
