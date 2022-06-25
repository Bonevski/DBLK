package de.fhswf.DBLK.DataManagement;

public class RoomDB implements IRoomPersistence{

    private String roomName;
    protected String[] rooms;

    public RoomDB (String roomName){
        this.roomName=roomName;
    }


    @Override
    public void deleteRoom(String roomName) {

    }

    @Override
    public RoomDB getRoom(String roomName) {
        return null;
    }

    @Override
    public void setRoom(String roomName) {

    }
}
