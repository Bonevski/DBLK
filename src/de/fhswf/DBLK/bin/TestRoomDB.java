package de.fhswf.DBLK.bin;

import de.fhswf.DBLK.datamanagement.Room;
import de.fhswf.DBLK.datamanagement.RoomDB;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestRoomDB {

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


       testdb.loadRoomDatabase();
       System.out.println(testdb2.toString());

    }//end main


}//end Class
