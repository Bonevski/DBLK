package de.fhswf.DBLK.datamanagement;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {

/**
 * @author Christoph / Stefan
 */

    /**
     * variables
     */
    public static int uniqueID = 0;
    public String bookingID; // unique ID reset when app starts again --> safe into Database --> load after restart
    public int timeBlock;
    public Date date;
    public String roomName;
    public String userName;



    /**
     * constructor Booking
     *
     * @param date
     * @param roomName
     * @param timeBlock
     * @param username  later addable, for example seats
     */
    public Booking(String bookingID,  Date date, String roomName, int timeBlock,  String username) {
        this.bookingID = bookingID;
        this.date = date;
        this.roomName = roomName;
        this.timeBlock = timeBlock;
        this.userName = username;
    }


    /**
     * Getter/Setter
     */
    public Date getDate() {
        return date;
    }

    public int getTimeBlock(){
        return timeBlock;
    }

    public String getBookingID(){
        return bookingID;
    }


    public void printMe() {
        System.out.println("BuchungsID " + bookingID + "Datum: " + date + "Block: " + timeBlock);
    }
    public static void main(String[] args) {

    }
}//class
