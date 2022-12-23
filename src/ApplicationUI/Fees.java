package ApplicationUI;

import java.sql.*;
import java.util.Iterator;
import java.util.Set;

public class Fees {

    private static Fees instance = null;
    private Fees()
    {

    }
    public static synchronized Fees getInstance()
    {
        if(instance == null)
        {
            instance = new Fees();
        }
        return instance;
    }
    public boolean addtofees(String item)
    {
        Integer price;
        Boolean itemfound = false;
        Boolean feesadded = false;
        String itemname;
        Integer itemprice,actualitemsprice = null;
        Integer tempstudid=null,tempstudfees=null,currentstudentfees=0;

        Set<String> keys = Mess.getInstance().itemNpricetablereturner().keySet();

        Iterator<String> itr = keys.iterator();

        while (itr.hasNext()) {
            String key = itr.next();

            if (key.equals(item)) {
                itemfound = true;
                try {
                    try
                    {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hmsdb","root","1234");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from mess");
                        while(rs.next())
                        {
                            itemname = rs.getString("item_name");
                            itemprice = rs.getInt("item_price");

                            if(item.equals(itemname))
                            {
                                actualitemsprice = itemprice;
                                itemfound=true;
                            }
                        }
                        if(itemfound == false)
                        {
                            System.out.println("wrong item entered");
                        }
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    //.....................................................


                    try
                    {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hmsdb","root","1234");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from students");
                        while(rs.next())
                        {
                            tempstudid = rs.getInt("id");
                            tempstudfees = rs.getInt("fees");

                            if(tempstudid.equals(Main.getStudid()))
                            {
                                currentstudentfees = tempstudfees;
                            }
                        }
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }


                    //..................................................
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hmsdb", "root", "1234");
                    String sql = "UPDATE students SET fees = ? WHERE id = ?";

                    PreparedStatement statement = con.prepareStatement(sql);

                    statement.setInt(1,actualitemsprice+currentstudentfees);
                    statement.setInt(2,Main.getStudid());
                    statement.executeUpdate();
                    System.out.println("Fees updated");
                    feesadded = true;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            if (itemfound == false) {
                System.out.println("Entered wrong item");
            }
        }
        return feesadded;
    }
    Integer calculatefees()
    {
        Integer tempstudid = null;
        Integer tempstudfees = null;
        Integer currentstudentfees = null;
        Boolean idfound = false;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hmsdb","root","1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from students");
            while(rs.next())
            {
                tempstudid = rs.getInt("id");
                tempstudfees = rs.getInt("fees");

                if(tempstudid.equals(Main.getStudid()))
                {
                    currentstudentfees = tempstudfees;
                    idfound = true;
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(idfound == false)
        {
            currentstudentfees = -1;
        }
        return currentstudentfees;
    }
    Boolean payfees(Integer amount,String accno)
    {
        Integer balance = null;
        boolean feestatus = false;
        Boolean balancefound = false;
        System.out.println("amount = "+amount);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hmsdb", "root", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from bank");
            while (rs.next()) {
                if(accno.equals(rs.getString("accno")))
                {
                    balance = rs.getInt("balance");
                    System.out.println("balance = "+balance);
                    balancefound = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(balancefound == false)
        {

            feestatus = false;
        }

        if(balancefound == true && balance >= amount)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hmsdb", "root", "1234");
                String sql1 = "UPDATE bank SET balance = ? WHERE accno = ?";
                String sql2 = "UPDATE students SET fees = ? WHERE id = ?";

                PreparedStatement statement1 = con.prepareStatement(sql1);
                PreparedStatement statement2 = con.prepareStatement(sql2);

                statement1.setInt(1,balance-amount);
                statement1.setString(2,accno);
                statement1.executeUpdate();
                System.out.println("Student Bank balance updated");

                statement2.setInt(1,0);
                statement2.setInt(2,Main.getStudid());
                statement2.executeUpdate();
                System.out.println("Student Fees reset to 0");
                feestatus = true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            feestatus = false;
            //System.out.println("Student Bank balance less than current fees");
        }
        return feestatus;
    }
}
