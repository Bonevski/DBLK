package de.fhswf.DBLK.bin;

import de.fhswf.DBLK.datamanagement.Room;
import de.fhswf.DBLK.datamanagement.RoomDB;

public class RoomDBTest {

    public static void main(String[] args) {


        RoomDB testdb = new RoomDB();
        RoomDB testdb2 = new RoomDB();

        Room h105 = new Room("H105");
        Room h106 = new Room("H106");
        Room h107 = new Room("H107");


        testdb.addRoom(h105);
        testdb.addRoom(h106);
        testdb.addRoom(h107);


        testdb.saveRoomDatabase();
        System.out.println(testdb.toString());


       testdb2.loadRoomDatabase();
       System.out.println(testdb2.toString());


    }//end main


}//end Class
