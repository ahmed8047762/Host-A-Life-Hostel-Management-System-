package ApplicationUI;

public class Student
{
    private String name;
    private String roll_num;
    private  int id;

    private static Student instance = null;

    private Student()
    {

    }
    public static synchronized Student getInstance()
    {
        if(instance == null)
        {
            instance = new Student();
        }
        return instance;
    }

    Student_DB studentDb = new Student_DB();
    Room_DB room_db = new Room_DB();

    public boolean authentication(String id, String pw)
    {
        return Authenticate.getInstance().authentication(id,pw);
    }
    public boolean addtofees(String item)
    {
        return Fees.getInstance().addtofees(item);
    }
    Integer calculatefees()
    {
        Integer fees = Fees.getInstance().calculatefees();
        return fees;
    }
    Boolean payfees(Integer amount,String accno)
    {
        boolean feestatus;
        feestatus = Fees.getInstance().payfees(amount,accno);
        return feestatus;
    }
    public String getName() {
        return name;
    }

    public String getRoll_num() {
        return roll_num;
    }

    public void setRoll_num(String roll_num) {
        this.roll_num = roll_num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean check_student(String id)
    {
        return studentDb.check_student(id);
    }
    public void Allocate_Room(String id, String room_id, String seat_num)
    {
        studentDb.update(id, room_id, seat_num);
        room_db.update(id,room_id,seat_num);
    }
    public void register_student(String n, String r, int room, int seat)
    {
        this.name= n;
        this.roll_num=r;
        studentDb.write(name,roll_num,room,seat);
    }}
