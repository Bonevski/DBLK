package de.fhswf.DBLK.datamanagement;
//* Stefan Lange nach Vorlage Chris Knips*

import java.io.Serializable;

public interface IBookingDB Implements Serializable{



    //Methods
    public void addBooking(Booking newBooking);
    public void deleteBooking (String Booking);
    public Booking[] getBookingList();  // possible not usable like this
    public void loadBookingDatabase();
    public void saveBookingDatabase();

}
