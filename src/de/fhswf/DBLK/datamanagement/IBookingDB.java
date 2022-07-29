package de.fhswf.DBLK.datamanagement;
//* Stefan Lange nach Vorlage Chris Knips*

public interface IBookingDB {



    //Methods
    public void addBooking(Booking newBooking);
    public void deleteBooking (String Booking);
    public Booking[] getBookingList();  // possible not usable like this
    public void loadBookingDatabase();
    public void saveBookingDatabase();

}
