package de.fhswf.DBLK.datamanagement;

import java.io.Serializable;

/**
 * @author Christoph
 */



public class Room implements Serializable {



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
