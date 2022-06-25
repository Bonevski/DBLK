package de.fhswf.DBLK.Logic;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Sasha
 */

public class BookingManager implements IRBS {
    protected Date[] days;
    protected ArrayList<Integer> planPerDay = new ArrayList<Integer>();


   /*
    /**
     * Wenn Platz in der Datenbank ist, wird ein neuer User erzeugt und in
     * die Datenbank eingefügt. Wenn die DB voll ist, wird eine Fehlermeldung
     * ausgegeben
     *
     * @param name
     * @param id
     * @param email
     */
    /*void addUser(String name, int id, String email) {
        int firstFreeIndex = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                // Gefunden!
                firstFreeIndex = i;
                break;
            }
        }
        // Wenn firstFreeIndex immernoch -1 ist, wurde kein freies Feld
        // gefunden -> bedeutet, die Datenbank ist voll
        if (firstFreeIndex == -1)
            System.out.println("Datenbank ist voll!");
        else
            // Ansonsten genau an dieser Stelle einen neuen User einfügen
            users[firstFreeIndex] = new UserDB(name, id, email);
    }

    /**
     * Der User mit der übergebenen ID wird aus der Datenbank
     * gelöscht. Wenn die ID nicht gefunden wird, wird eine
     * Fehlermeldung ausgegeben
     *
     * @param id
     */
    /*
    void removeUser(int id) {
        for (int i = 0; i < users.length; i++) {
            // Auch hier die Überprüfung auf null, damit keine
            // NullPointerExceptions geworfen werden
            if ((users[i] != null) && (users[i].id == id)) {
                users[i] = null;
                return;
            }
        }
        System.out.println("User wurde nicht gefunden!");
    }*/

    public static String checkPW(String username, String password, String confirmPassword, String email) {
       String check = "";
        if (username.equals("" + username) && (password.equals(password)) && confirmPassword.equals(password) && email.contains("@fh-swf.de")) {
            check = "Login successful";
        } else {
            check = "Login failed";
        }
        return check;
    }

    public static void main(String[] args) {

    }
}
