package ApplicationUI;

import java.sql.Array;

public class Room
{
    Room_DB room_db = new Room_DB();
    private int id;
    private String seat1;
    private String seat2;
    private String seat3;

    private static Room instance = null;

    private Room()
    {

    }
    public static Room getInstance()
    {

        if (instance == null)
        {
            instance = new Room();
        }
        return instance;
    }




    public int[] check_room_availability(int id)
    {
        Room r = new Room();
        int room[]=new int[]{1,1,1};
        r = room_db.read(id);
            if(r.seat1 == null || r.seat1.isEmpty())
                room[0]=0;
            if (r.seat2 == null || r.seat2.isEmpty())
                room[1]=0;
            if (r.seat3 == null || r.seat3.isEmpty())
                room[2]=0;

        return room;
    }
    public boolean check_room_id(String id)
    {
        return room_db.check_room_id(id);
    }
    public boolean check_room(String id)
    {
        return room_db.reading_student_in_seats(id);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeat1() {
        return seat1;
    }

    public void setSeat1(String seat1) {
        this.seat1 = seat1;
    }

    public String getSeat2() {
        return seat2;
    }

    public void setSeat2(String seat2) {
        this.seat2 = seat2;
    }

    public String getSeat3() {
        return seat3;
    }

    public void setSeat3(String seat3) {
        this.seat3 = seat3;
    }
}
