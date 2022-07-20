package de.fhswf.DBLK.datamanagement;

import java.util.Date;


public interface IBookingDB {

public String setBooking(Date date, String roomName, int timeBlock,
             String username);
public String getBooking(Date date, String roomName, int timeBlock,
             String username);

static void setBooking(Date bookDate,String bookRoom, String bookUser){

}
}
