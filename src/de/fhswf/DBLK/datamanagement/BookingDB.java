package de.fhswf.DBLK.datamanagement;

/**
 * @author Stefan
 * code taken from Chris and modified for Booking instead of Rooms
 * Thx Chris, i owe you one
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

public class BookingDB implements IBookingDB, Serializable {


    /**
     * variables
     */
    //create Array of Bookings
    public Booking[] bookingList;


    /**
     * constructor bookingList
     * (creates empty Array with space for 500 Bookings)
     */
    public BookingDB() {bookingList = new Booking[500];
    }


    /**
     * adds existing Booking to bookingList
     *
     * @param newBooking
     */
    @Override
    public void addBooking(Booking newBooking) {

                int firstFreeIndex = -1;
        // first free space in array
        for (int i = 0; i < bookingList.length; i++) {
            if (bookingList[i] == null) {
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
            bookingList[firstFreeIndex] = new Booking(newBooking.bookingName);
        //}

    }//end addBooking()


   /* old version with Arraylist
        // check, if Booking already exists
        if (this.bookingList.contains(newBooking)) {
            // throw Exception, if Booking does already exist
            throw new IllegalArgumentException("Der Raum existiert bereits!");
        }
        this.bookingList.add(newBooking);
    }
*/

    /**
     * deletes Booking from Booking list.
     *
     * @param bookingName
     */

    @Override
    public void deleteBooking(String bookingName) {
        for (int i = 0; i < bookingList.length; i++) {
            // check for null so not NullPointerExceptions gets thrown
            if ((bookingList[i] != null) && (bookingList[i].bookingName == bookingName)) {
                bookingList[i] = null;
                return;
            }
        }
        throw new IllegalArgumentException("Der Raum wurde nicht gefunden!");

       /* old version with ArrayList
        //if(checkAdmin(username) == true) {

        Booking room;
        // Iterator um die ArrayList zu durchlaufen
        // Zeiger der die Elemente einer Menge durchläuft
        Iterator<Room> iter = this.bookingList.iterator();
        // solange es noch Elemente in der ArrayList gibt...
        while (iter.hasNext()) {
            // ...sich den nächsten Eintrag nehmen...
            room = iter.next();

            // ...und überprüfen ob der Name mit dem zu entfernenden Namen übereinstimmt...
            if (room.getbookingName().equals(bookingName)) {
                // ...wenn, dann diesen Eintrag aus der ArrayList entfernen
                iter.remove();
            } // if
        } // while
        //}else{
        //    System.out.println("No Permissions!");
        //}
        */


    }//end deleteBooking()


    /**
     * returns created Booking   //toString alternative?
     * (data control)
     */
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < bookingList.length; i++) {
            // check for null so not NullPointerExceptions gets thrown and empty slots get jumped
            if (bookingList[i] != null) {
                output += bookingList[i] + "\n";
            }
        }
        return ("Liste aller Raeume:\n" + output);
    }//end toString()


    /**
     * access to bookingList from interface
     */
    @Override
    public Booking[] getbookingList() {
        return bookingList;
    }//end getbookingList()


    /**
     * loads the current persistent bookingList
     */
    @Override
    public void loadBookingDatabase() {
        try {
            //load file
            FileInputStream fisbookingdb = new FileInputStream(new File("BookingDB.dat"));
            ObjectInputStream oisbookingdb = new ObjectInputStream(fisbookingdb);

            // Read objects into existing empty array
            bookingList = (Booking[]) oisbookingdb.readObject();
            // System.out.println(bookingList.toString()); //testoutput


        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//end loadBookingDatabase()


    /**
     * saves the current bookingList persistent
     */
    @Override
    public void saveBookingDatabase() {
        try {

            //create file
            FileOutputStream fosbookingdb = new FileOutputStream(new File("BookingDB.dat"));
            ObjectOutputStream oosbookingdb = new ObjectOutputStream(fosbookingdb);


            oosbookingdb.writeObject(bookingList); // write array of objects to file
            //System.out.println(bookingList.toString()); //testoutput


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Error initializing stream");
        }

    } //end saveBookingDatabase()


}//class
