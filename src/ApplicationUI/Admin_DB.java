package ApplicationUI;

import java.sql.*;

public class Admin_DB
{
    public Connection con;

    public Admin_DB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsdb", "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void write()
    {
        try
        {
            String query = "INSERT INTO admin (password, username) VALUES (?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, "123");
            stmt.setString(2, "Usman");
            int rows = stmt.executeUpdate();
            if (rows > 0)
            {
                System.out.println("Admin was added...");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public Admin read()
    {
        Admin admin = new Admin();
        Statement stm;
        try
        {

            stm = con.createStatement();
            String query = "Select * from admin where password = '123' AND username = 'Usman'";
            ResultSet rs = stm.executeQuery(query);
            if (rs.next())
            {
                admin.setPass(rs.getString(2));
                admin.setName(rs.getString(1));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return admin;
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
