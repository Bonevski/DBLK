package de.fhswf.DBLK.DataManagement;

/**
 * @author Christoph
 */

//file save
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Room {



    private String roomName;



    /**
     * constructor Room
     * @param roomName
     * later addable, for example seats
     */
    public Room(String roomName) {
        this.roomName = roomName;
    }


    /**
     * Getter/Setter
     */

    public String getRoomName(){
        return roomName;
    }

    public String setRoomName(String newRoomName){
        this.roomName=newRoomName;
        return roomName;
    }


    public void printMe() {
        System.out.println("Raum: " + roomName);
    }

    /**
     * only for TestStoreLoadFiles
     * delete if issue resolved
     */

@Override
    public String toString() {
        return ("Name: " + roomName);
    }
}
