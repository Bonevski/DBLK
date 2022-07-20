package de.fhswf.DBLK.DataManagement;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sasha
 */
public class UserDB implements IUserPersistence {

    private User[] users;


    /**
     * Konstruktor User
     * (Erzeugt eine leere Liste von Usern)
     */
    public UserDB() {
        users = new User[30000];
    }

    /**
     * Gibt alle User auf der Konsole aus
     */
    @Override
    public void printMe() {
        for (User u : users) {
            // Felder im Array, die keinen Eintrag haben, werden ignoriert
            if (u != null) {
                u.printMe();
            }
        }
    }


    /**
     * Fügt einen neuen User dem Array hinzu
     * Hier: leider ohne überprüfung ob Doppelregistrierung
     *
     * @param newUser
     */
    @Override
    public void addUser(User newUser) {

        //List<User> list = Arrays.asList(users);

        // Wenn der User bereits existiert Fehlermeldung
        //if (list.contains(newUser)) {
        //    System.out.println("User existiert bereits!");
            //JOptionPane.showMessageDialog(null, "This User already exists!", "ERROR", JOptionPane.ERROR_MESSAGE);
        //}else {
            int firstFreeIndex = -1;
            // Im Array wird das erste freie Feld gesucht
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    // Gefunden!
                    firstFreeIndex = i;
                    break;
                }
            }
            // Wenn firstFreeIndex immer noch -1 ist, wurde kein freies Feld
            // gefunden -> bedeutet, die Datenbank ist voll
            if (firstFreeIndex == -1)
                throw new IllegalArgumentException("The Database is full!");
            else
                // Ansonsten genau an dieser Stelle einen neuen User einfügen
                users[firstFreeIndex] = new User(newUser.username, newUser.password, newUser.email);
        //}

    }


    /**
     * Der User mit dem übergebenen Usernamen wird aus der Datenbank
     * gelöscht. Wenn der Username nicht gefunden wird, wird eine
     * Fehlermeldung ausgegeben
     * Hier: eher für Admin
     *
     * @param username
     */
    @Override
    public void removeUser(String username) {
        for (int i = 0; i < users.length; i++) {
            // Auch hier die Überprüfung auf null, damit keine
            // NullPointerExceptions geworfen werden
            if ((users[i] != null) && (users[i].username == username)) {
                users[i] = null;
                return;
            }
        }
        throw new IllegalArgumentException("This user was not found!");
    }


    public static void main(String[] args) {
        System.out.println("Create Database...");
        UserDB db = new UserDB();

        User b = new User("Bonevski", "sb123", "Bonevski.sasha@fh-swf.de");
        User l = new User("Lange", "sl123", "Lange.stefan@fh-swf.de");
        User k = new User("Knips", "ck123", "Knips.chris@fh-swf.de");
        User d = new User("Demir", "fd123", "Demir.firat@fh-swf.de");



        db.addUser(b);
        db.addUser(l);
        db.addUser(k);
        db.addUser(d);
        db.printMe();

        System.out.println("Remove...");
        db.removeUser("Bonevski");
        db.printMe();
        System.out.println("Check if the User already exists...");
        db.addUser(l);
    }

}
