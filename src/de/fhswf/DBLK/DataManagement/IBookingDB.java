package de.fhswf.DBLK.DataManagement;

import java.util.Date;


public interface IBookingDB {

public String setBooking(Date date, String roomName, int timeBlock,
             String userName);
public String getBooking(Date date, String roomName, int timeBlock,
             String userName);

static void setBooking(Date bookDate,String bookRoom, String bookUser){

}
}
