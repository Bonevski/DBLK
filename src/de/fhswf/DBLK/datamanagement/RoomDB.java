package de.fhswf.DBLK.datamanagement;

/**
 * @author Christoph
 * lot of code taken from Sasha and refactored
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class RoomDB implements IRoomPersistence, Serializable {


    /**
     * variables
     */
    //create Array of rooms
    private Room[] roomList;


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
            // Ansonsten genau an dieser Stelle einen neuen User einfügen
            roomList[firstFreeIndex] = new Room(newRoom.roomName);
        //}

    }


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


    }


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
        return ("RaumListe: " + output);
    }


    /**
     * access to roomList from interface
     */
    @Override
    public Room[] getRoomList() {
        return roomList;
    }


}//class
