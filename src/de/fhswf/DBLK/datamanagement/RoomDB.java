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
    //create ArrayList of rooms
    private ArrayList<Room> roomList;
    // protected String[] rooms;  // not needed --> we will use an ArrayList



    /**
     * constructor roomList
     * (creates empty list of rooms)
     */
    public RoomDB() {
        this.roomList = new ArrayList<Room>();
    }


    /**
     * adds existing room to roomList
     *
     * @param newRoom
     */
    @Override
    public void addRoom(Room newRoom) {
        // check, if room already exists
        if (this.roomList.contains(newRoom)) {
            // throw Exception, if room does already exist
            throw new IllegalArgumentException("Der Raum exisitiert bereits!");
        }
        this.roomList.add(newRoom);
    }


    /**
     * deletes room from room list.
     *
     * @param roomName
     */

    @Override
    public void deleteRoom(String roomName) {
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
    }


    /**
     * returns created room   //toString alternative?
     * (data control)
     */
    public void printMe() {
        for (Room u : roomList) {
            // Felder im Array, die keinen Eintrag haben, werden ignoriert
            if (u != null) {
                u.printMe();
            }
        }
    }


    /**
     * access to roomList from interface
     */
    @Override
    public ArrayList getRoomList() {
        return roomList;
    }




}//class
