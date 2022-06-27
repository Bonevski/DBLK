package de.fhswf.DBLK.DataManagement;

/**
 * @author Christoph
 */


import java.util.ArrayList;
import java.util.Iterator;

public class RoomDB implements IRoomPersistence {

    public String roomName;
    // protected String[] rooms;  // not needed --> ArrayList


    //create list of rooms
    public ArrayList<RoomDB> roomList = new ArrayList<RoomDB>();

    public RoomDB(String roomName) {
        this.roomName = roomName;
    }

    /**
     * Fügt einen neuen Rom der roomList hinzu
     * @param newRoom
     */
    void addRoom(RoomDB newRoom){
        // überprüfen, ob der Raum schon existiert
        if(this.roomList.contains(newRoom)) {
            // Exception (Fehler) werfen, wenn der Usernamen schon existiert
            throw new IllegalArgumentException("Der User ist bereits registriert!");
        }
        this.roomList.add(newRoom);
    }



    /*
        @Override
        public void deleteRoom(String roomName) {


            roomList.remove(roomName);
            // delete object? overwrite with null und run  System.gc() <-- not recommended and does leave open space in  ArrayList
        }
    */

    public String getRoomName(){
        return roomName;
    }

    @Override
    public void deleteRoom(String roomName) {
        RoomDB room;
        // Iterator um die ArrayList zu durchlaufen
        // Zeiger der die Elemente einer Menge durchläuft
        Iterator<RoomDB> iter = this.roomList.iterator();
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
    }



/* not needed
    @Override
    public RoomDB getRoom(String roomName) {
        return null;
    }

    @Override
    public void setRoom(String roomName) {
    }
*/


    /**
     * access to roomList from interface
     */
    public ArrayList getRoomList() {
        return roomList;
    }
}
