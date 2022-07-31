package de.fhswf.DBLK.datamanagement;

/**
 * @author Christoph
 * code for addRoom() and deleteRoom() taken from Sasha and refactored
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RoomDB implements IRoomPersistence, Serializable {


    /**
     * variables
     */
    //create Array of rooms
    public Room[] roomList;


    /**
     * constructor roomList
     * (creates empty Array with space for 500 rooms)
     */
    public RoomDB() {
        roomList = new Room[500];
    }


    /**
     * adds existing room to roomList
     *
     * @param newRoom
     */
    @Override
    public void addRoom(Room newRoom) {
        //List<User> list = Arrays.asList(users);
        // if room already exist throw error
        //if (list.contains(newUser)) {
        //    System.out.println("User existiert bereits!");
        //JOptionPane.showMessageDialog(null, "This User already exists!", "ERROR", JOptionPane.ERROR_MESSAGE);
        //}else {
        int firstFreeIndex = -1;
        // first free space in array
        for (int i = 0; i < roomList.length; i++) {
            if (roomList[i] == null) {
                // found
                firstFreeIndex = i;
                break;
            }
        }
        // If  firstFreeIndex still = -1 --> Database is full
        if (firstFreeIndex == -1)
            throw new IllegalArgumentException("The Database is full!");
        else
            // create new room at first empty slot in array
            roomList[firstFreeIndex] = new Room(newRoom.roomName);
        //}

    }//end addRoom()


   /* old version with Arraylist
        // check, if room already exists
        if (this.roomList.contains(newRoom)) {
            // throw Exception, if room does already exist
            throw new IllegalArgumentException("Der Raum existiert bereits!");
        }
        this.roomList.add(newRoom);
    }
*/

    /**
     * deletes room from room list.
     *
     * @param roomName
     */

    @Override
    public void deleteRoom(String roomName) {
        for (int i = 0; i < roomList.length; i++) {
            // check for null so not NullPointerExceptions gets thrown
            if ((roomList[i] != null) && (roomList[i].roomName == roomName)) {
                roomList[i] = null;
                return;
            }
        }
        throw new IllegalArgumentException("Der Raum wurde nicht gefunden!");

       /* old version with ArrayList
        //if(checkAdmin(username) == true) {

        Room room;
        // Iterator um die ArrayList zu durchlaufen
        // Zeiger der die Elemente einer Menge durchläuft
        Iterator<Room> iter = this.roomList.iterator();
        // solange es noch Elemente in der ArrayList gibt...
        while (iter.hasNext()) {
            // ...sich den nächsten Eintrag nehmen...
            room = iter.next();

            // ...und überprüfen ob der Name mit dem zu entfernenden Namen übereinstimmt...
            if (room.getRoomName().equals(roomName)) {
                // ...wenn, dann diesen Eintrag aus der ArrayList entfernen
                iter.remove();
            } // if
        } // while
        //}else{
        //    System.out.println("No Permissions!");
        //}
        */


    }//end deleteRoom()


    /**
     * returns created room   //toString alternative?
     * (data control)
     */
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < roomList.length; i++) {
            // check for null so not NullPointerExceptions gets thrown and empty slots get jumped
            if (roomList[i] != null) {
                output += roomList[i] + "\n";
            }
        }
        return ("Liste aller Raeume:\n" + output);
    }//end toString()


    /**
     * access to roomList from interface
     */
    @Override
    public Room[] getRoomList() {
        return roomList;
    }//end getRoomList()


    /**
     * loads the current persistent roomList
     */
    @Override
    public void loadRoomDatabase() {
        try {
            //load file
            FileInputStream fisroomdb = new FileInputStream(new File("RoomDB.txt"));
            ObjectInputStream oisroomdb = new ObjectInputStream(fisroomdb);

            // Read objects into existing empty array
            roomList = (Room[]) oisroomdb.readObject();
           // System.out.println(roomList.toString()); //testoutput


        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//end loadRoomDatabase()


    /**
     * saves the current roomList persistent
     */
    @Override
    public void saveRoomDatabase() {
        try {

            //create file
            FileOutputStream fosroomdb = new FileOutputStream(new File("RoomDB.dat"));
            ObjectOutputStream oosroomdb = new ObjectOutputStream(fosroomdb);


            oosroomdb.writeObject(roomList); // write array of objects to file
            //System.out.println(roomList.toString()); //testoutput


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Error initializing stream");
        }
    } //end saveRoomDatabase()


}//class
