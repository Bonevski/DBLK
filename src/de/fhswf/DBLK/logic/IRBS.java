package de.fhswf.DBLK.logic;

import java.util.Date;

public interface IRBS {
public static void runRBS(){
   BookingManager.mainMenu();
}

public String listAllRooms (Date date);
public String bookRoom (Date date, String roomName, int timeBlock);
public String cancelRoom (Date date, String roomName, int timeBlock);
// public static void createUser(); //problem --> static need a body here, if non static, following references will not work
public void loginAccount ();
public void createRoom();
public void deleteARoom();
}
