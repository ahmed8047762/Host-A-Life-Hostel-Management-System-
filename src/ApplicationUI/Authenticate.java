package ApplicationUI;

import java.sql.*;

public class Authenticate {

    private static Authenticate instance = null;
    private Authenticate()
    {

    }
    public static synchronized Authenticate getInstance()
    {
        if(instance == null)
        {
            instance = new Authenticate();
        }
        return instance;
    }
    public boolean authentication(String id, String pw)
    {
        boolean status = false;
        int ID = 0;
        String UN = "", PW = "";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hmsdb","root","1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from students");
            while(rs.next())
            {
                ID = rs.getInt("id");
                UN = rs.getString("name");
                PW = rs.getString("roll_no");

                if(PW.equals(pw) && id.equals(UN))
                {
                    Main.setStudid(ID);
                    //System.out.println(ID+" "+UN+"  "+PW);
                    status=true;
                }
            }
            if(status == false)
            {
                System.out.println("wrong ID & PASSWORD");
                //System.out.println(ID+" "+UN+"  "+PW);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
}
