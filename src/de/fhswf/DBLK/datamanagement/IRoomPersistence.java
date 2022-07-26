package de.fhswf.DBLK.datamanagement;

import java.util.ArrayList;

public interface IRoomPersistence {



//Methods
public void addRoom(Room newRoom);
public void deleteRoom (String roomName);
public Room[] getRoomList();  // possible not usable like this
public void loadRoomDatabase();
public void saveRoomDatabase();

}
