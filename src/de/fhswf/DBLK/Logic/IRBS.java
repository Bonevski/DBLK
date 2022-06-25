package de.fhswf.DBLK.Logic;

import java.util.Date;

public interface IRBS {

public String listAllRooms (Date date);
public String bookRoom (Date date, String roomName, int timeBlock);
public String cancelRoom (Date date, String roomName, int timeBlock);
public String createAccount (String userName, String mail, String password);
public void loginAccount (String userName, String password);
public void createRoom (String roomName);
public void deleteRoom (String roomName);
}
