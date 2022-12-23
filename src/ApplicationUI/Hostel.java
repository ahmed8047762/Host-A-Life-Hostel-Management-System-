package ApplicationUI;

public class Hostel {
    //Student s = new Student();
    private String name;
    private String location;
    private static Hostel instance = null;
    private Hostel()
    {
        this.name = "\0";
        this.location = "\0";
    }
    public static synchronized Hostel getInstance()
    {
        if(instance == null)
        {
            instance = new Hostel();
        }
        return instance;
    }
    public void mainfunction()
    {
        System.out.println("hello");
    }
    public boolean authentication(String id, String pw)
    {
        return Student.getInstance().authentication(id,pw);
    }
    public boolean addtofees(String item)
    {
        return Student.getInstance().addtofees(item);
    }
    Integer calculatefees()
    {
        Integer fees = Student.getInstance().calculatefees();
        return fees;
    }
    Boolean payfees(Integer amount,String accno)
    {
        boolean feestatus;
        feestatus = Student.getInstance().payfees(amount,accno);
        return feestatus;
    }

    //Check room Availability Use-case 1
    public int[] check_room_availability(int id)
    {
        return Room.getInstance().check_room_availability(id);
    }
    public boolean check_room_id(String id)
    {
        return Room.getInstance().check_room_id(id);
    }
    public boolean check_student(String id)
    {
        return Student.getInstance().check_student(id);
    }
    public boolean check_room(String id)
    {
        return Room.getInstance().check_room(id);
    }

    //Register Student Use-case 2
    public void register_student(String n, String r, int room, int seat)
    {
        Student.getInstance().register_student(n,r,room,seat);
    }
    //Allocate Room Use-case 3
    public void Allocate_Room(String id,String room_id,String seat_num)
    {
        Student.getInstance().Allocate_Room(id, room_id, seat_num);
    }
    //Manage Mess Use-case 4
    public void add_item(String name,int price)
    {
        Mess.getInstance().add_item(name,price);
    }
    public void remove_item(int id)
    {
        Mess.getInstance().remove_item(id);
    }
    public void update_item(int id,int price)
    {
        Mess.getInstance().update_item(id,price);
    }
    public boolean check_item(String name)
    {
        return Mess.getInstance().check_item(name);
    }
    public boolean check_item_id(int id)
    {
        return Mess.getInstance() .check_item_id(id);
    }

}