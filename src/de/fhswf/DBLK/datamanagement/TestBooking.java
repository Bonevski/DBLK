package de.fhswf.DBLK.datamanagement;
import de.fhswf.DBLK.datamanagement.RoomDB;

import org.junit.Assertions;
import org.Junit.jupiter.api.Test;
import org.junit.jupiter.api;
/**
 * @author Firat
 */
public class BuchungTest  {
/*
        //Erstellen des Arrays der Buchungslisten
        public Booking[] bookingList;
    {


        public BookingDB() {
            bookingList = new book[500];
        }
    }



        public void addBooking(book newBook) {

            int firstFreeIndex = -1;
            // first free space in array
            for (int i = 0; i < booking.length; i++) {
                if (bookingList[i] == null) {
                    // found
                    firstFreeIndex = i;
                    break;
                }
            }
            //Wenn keine Buchung mehr Verfügbar ist.
            if (firstFreeIndex == -1)
                throw new IllegalArgumentException("Keine Buchung mehr Verfügbar.");
            else
                // Ansonsten eine Buchung hinzufügen
                bookingList[firstFreeIndex] = new book(newBook.booking);
            //}

        }//end addBooking()
 */
    //Test vorgang
    public void testBuchung() {
        String ergebnis;
        Room testRoom = new Room("H105");
        User testUser = new User("Bonevski","sb123","Bonevski.sasha@fh-swf.de");
        RoomDB testDB = new RoomDB();


        testDB.addRoom(testRoom);

        assertEquals(testRoom, RoomDB.getRoomList()); //Bei positiver Eingabe, Anzeigen der Raumliste
        /*
        assertEquals(0, testUser.getBookingList).size()); //Welche Räume kann man Buchen
        String ergebnis = testUser.(testRoom);
        assertEquals(false, testRoom.getVerfuegbarkeit()); //nicht Gebuchte Räume anzeigen(Verfügbar)
        assertEquals("Sie haben den Raum H105 erfolgreich gebucht.", ergebnis);
        assertEquals(1, testUser.getBookingList().size());//Einfügen des Benutzers bei erfolgreicher Buchung
        */
    }


   /* public void testStornieren() {
        Room testRoom = new Room("H105");
        User testUser = new User("Sasha","sb123","Bonevski.sasha@fh-swf.de";
        testUser.bucheRaum(testRoom); //Anzeigen der gebuchten Räume des Nutzers
        String ergebnis = testUser.cancelRoom(testRoom);//entfernen der Buchung des Nutzers
        assertEquals("Sie haben die Buchung des Raumes " + testRoom.getName() + " erfolgreich storniert.", ergebnis); //Buchung wurde Storniert.
        assertEquals(0, testUser.getBooking().size());
        assertEquals(true, testRoom.getBookingList());
    }
    */

}

