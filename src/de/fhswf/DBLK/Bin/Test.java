package de.fhswf.DBLK.Bin;


import de.fhswf.DBLK.DataManagement.User;
import de.fhswf.DBLK.DataManagement.UserDB;

import javax.swing.*;

/**
 * @author Sasha
 */
public class Test {

    /**
     * Debugging
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Datenbank erstellen...");
        UserDB db = new UserDB();

        db.addUser(new User("Bonevski", "sb123", "Bonevski.sasha@fh-swf.de"));
        db.addUser(new User("Knips", "ck123", "Knips.chris@fh-swf.de"));
        db.addUser(new User("Lange", "sl123", "Lange.stefan@fh-swf.de"));
        db.addUser(new User("Demir", "fd123", "Demir.firat@fh-swf.de"));



        System.out.println("=======DEBUGGING=======");
        System.out.println("----User hinzufügen----");
        db.toString(); // Ausgabe in der Konsole

    }
}
