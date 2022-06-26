package de.fhswf.DBLK.Logic;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Sasha
 */

public class BookingManager implements IRBS {
    protected Date[] days;
    protected ArrayList<Integer> planPerDay = new ArrayList<Integer>();



    /**
     * Check ob Passwort eingabe identisch ist und ob
     * es eine @fh-swf.de Mail ist
     * @param password
     * @param confirmPassword
     * @param email
     * @return
     */
    public static String check(String password, String confirmPassword, String email) {
        if (password.equals(confirmPassword) && email.contains("@fh-swf.de")) {
            return "Login successful!";
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

    }

    @Override
    public String listAllRooms(Date date) {
        return null;
    }

    @Override
    public String bookRoom(Date date, String roomName, int timeBlock) {
        return null;
    }

    @Override
    public String cancelRoom(Date date, String roomName, int timeBlock) {
        return null;
    }

    @Override
    public String createAccount(String userName, String mail, String password) {
        return null;
    }

    @Override
    public void loginAccount(String userName, String password) {

    }

    @Override
    public void createRoom(String roomName) {

    }

    @Override
    public void deleteRoom(String roomName) {

    }
}
