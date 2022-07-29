package de.fhswf.DBLK.datamanagement;

import java.util.Date;

public class Booking {

/**
 * @author Christoph
 */

    /**
     * variables
     */
    private static int uniqueID = 0;
    private int bookingID; // unique ID reset when app starts again --> safe into Database --> load after restart
    private int timeBlock;
    private Date date;
    private String roomName;
    private String username;

    /**
     * constructor Booking
     *
     * @param date
     * @param roomName
     * @param timeBlock
     * @param username  later addable, for example seats
     */
    public Booking(Date date, String roomName, int timeBlock, String username) {
        this.date = date;
        this.roomName = roomName;
        this.timeBlock = timeBlock;
        this.bookingID = uniqueID++;
        this.username = username;
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

    public int getBookingID(){
        return bookingID;
    }


    public void printMe() {
        System.out.println("BuchungsID " + bookingID + "Datum: " + date + "Block: " + timeBlock);
    }
    public static void main(String[] args) {

    }
}//class
