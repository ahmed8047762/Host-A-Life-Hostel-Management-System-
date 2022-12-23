package ApplicationUI;

import java.sql.*;

public class Student_DB
{
    public Connection con;

    public Student_DB()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsdb", "root", "1234");
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

    }

    public void write(String name, String roll_num, int room, int seat)
    {
        try
        {
            String query = "INSERT INTO students (name ,roll_no,room_id,seat_no) VALUES (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, roll_num);
            stmt.setInt(3, room);
            stmt.setInt(4, seat);
            int rows = stmt.executeUpdate();
            if (rows > 0)
            {
                System.out.println("Student was added...");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

        public boolean check_student(String id)
    {
           // Student student = new Student();
            Statement stm;
            try
            {

                stm = con.createStatement();
                String query = "Select * from students";
                ResultSet rs = stm.executeQuery(query);
                while (rs.next())
                {
                    if (rs.getString("id").equals(id))
                        return true;
                }

            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            return false;
        }

        public Student read(int id)
    {
    //    Student student = new Student();
        Statement stm;
        try
        {

            stm = con.createStatement();
            String query = "Select * from students where id = "+id;
            ResultSet rs = stm.executeQuery(query);
            if (rs.next())
            {
               Student.getInstance().setId(rs.getInt(0));
                Student.getInstance().setName(rs.getString(1));
                System.out.println(Student.getInstance().getId());
                return Student.getInstance();
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return Student.getInstance();
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
    public void update(String s_id,String r_id,String seat) {
        int seat_no = Integer.parseInt(seat);
        try {
            String query = "UPDATE students set room_id = "+r_id+", seat_no = " + seat_no +" where id = "+s_id ;
            PreparedStatement stmt = con.prepareStatement(query);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student is added...");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
