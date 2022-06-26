package de.fhswf.DBLK.DataManagement;

import java.util.ArrayList;

public interface IRoomPersistence {



//Methods
public void deleteRoom (String roomName);

/* not needed:
public RoomDB getRoom (String roomName);
public void setRoom (String roomName);
 */

public  ArrayList getRoomList();

}
