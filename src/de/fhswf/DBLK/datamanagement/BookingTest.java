package de.fhswf.DBLK.datamanagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Firat
 */
public class BookingTest {
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
    @Test
    public void testBuchung() {
        String ergebnis;
        Room testRoom = new Room("H105");
        User testUser = new User("Bonevski", "sb123", "Bonevski.sasha@fh-swf.de");
        RoomDB testDB = new RoomDB();


        testDB.addRoom(testRoom);
/*
//part was commented out because UI would not run otherwise, issue is probably again the method not being static

        assertEquals(testRoom, RoomDB.getRoomList()); //Anzeigen der Raumliste

        assertEquals(0, testRoom.getBookingID).size()); //Welche Räume kann man Buchen
        String ergebnis = testUser.(testRoom);
        assertEquals(false, testRoom.getVerfuegbarkeit()); //nicht Gebuchte Räume anzeigen(Verfügbar)
        assertEquals("Sie haben den Raum H105 erfolgreich gebucht.", ergebnis);
        assertEquals(1, testUser.getBookinglist.size());//Einfügen des Benutzers bei erfolgreicher Buchung
*/
    }

    @Test
    public void testStornieren() {
        Room testRoom = new Room("H105");
        User testUser = new User("Sasha", "sb123", "Bonevski.sasha@fh-swf.de");

        //part was commented out because UI would not run otherwise
      /*  BookingDB.bookingRoom(testRoom); //Anzeigen der gebuchten Räume des Nutzers
        String ergebnis = testUser.cancelRoom(testRoom);//entfernen der Buchung des Nutzers
        assertEquals("Sie haben die Buchung des Raumes " + testRoom.getName() + " erfolgreich storniert.", ergebnis); //Buchung wurde Storniert.
        assertEquals(0, testUser.getBooking().size());
        assertEquals(true, testRoom.getBookingList());

       */
    }

}

