package de.fhswf.DBLK.datamanagement;
import de.fhswf.DBLK.bin.RoomDBTest;

/**
 * @author Firat
 */
public class BuchungTest implements IBookingDB {

        //Erstellen des Arrays der Buchungslisten
        public Booking[] bookingList;
    {


        public ooking() {
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

    //Test vorgang
    public void testBuchung() {
       public String ergebnis;
        Raum testRoom = new Room("H105", 1, true);
        Benutzer testUser = new User("Bonevski","sb123","Bonevski.sasha@fh-swf.de");

        assertEquals(true, RoomDBTest.getRoomlist()); //Bei positiver Eingabe, Anzeigen der Raumliste
        assertEquals(0, testUser.getBooking).size()); //Welche Räume kann man Buchen
        String ergebnis = testUser.(testRoom);
        assertEquals(false, testRoom.getVerfuegbarkeit()); //nicht Gebuchte Räume anzeigen(Verfügbar)
        assertEquals("Sie haben den Raum H105 erfolgreich gebucht.", ergebnis);
        assertEquals(1, testUser.getbookingList().size());//Einfügen des Benutzers bei erfolgreicher Buchung
    }

    @Test
    public void testStornieren() {
        Raum testRoom = new Room("H105", true);
        Benutzer testUser = new User("Sasha","sb123","Bonevski.sasha@fh-swf.de";
        testNutzer.bucheRaum(testRoom); //Anzeigen der gebuchten Räume des Nutzers
        String ergebnis = testUser.cancleRoom(testRoom);//entfernen der Buchung des Nutzers
        assertEquals("Sie haben die Buchung des Raumes " + testRoom.getName() + " erfolgreich storniert.", ergebnis); //Buchung wurde Storniert.
        assertEquals(0, testUser.getBooking().size());
        assertEquals(true, testRoom.getBookinglist());
    }
}
}