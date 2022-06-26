package de.fhswf.DBLK.DataManagement;

/**
 * @author Christoph
 */

import java.util.ArrayList;

public class RoomDB implements IRoomPersistence{

    private String roomName;
    // protected String[] rooms;  // not needed --> ArrayList


    //create list of rooms
    ArrayList<String> roomList = new ArrayList<String>();

    public RoomDB (String roomName){
        this.roomName=roomName;
        roomList.add(roomName);   // When a new room is created add it to the roomList
        // more Room information like seats possible
    }


    @Override
    public void deleteRoom(String roomName) {
  // delete object? overwrite with null und run System.gc() <-- not recommended and does leave open space in  ArrayList
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
    public  ArrayList getRoomList(){
    return roomList;
    }
}
