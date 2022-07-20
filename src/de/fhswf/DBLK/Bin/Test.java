package de.fhswf.DBLK.Bin;


import de.fhswf.DBLK.DataManagement.User;
import de.fhswf.DBLK.DataManagement.UserDB;

import javax.swing.*;
import java.util.ArrayList;

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
        ArrayList<User> users = new ArrayList<User>();
        System.out.println("Datenbank erstellen...");
        UserDB db = new UserDB();

        User b = new User("Bonevski", "sb123", "Bonevski.sasha@fh-swf.de");
        User k = new User("Knips", "ck123", "Knips.chris@fh-swf.de");
        User l = new User("Lange", "sl123", "Lange.stefan@fh-swf.de");
        //User d = new User("Demir", "fd123", "Demir.firat@fh-swf.de");

        users.add(b);
        System.out.println(users.toString());
        users.add(k);
        users.add(l);
        //users.add(d);

        // Arraylist benötigt
        boolean itemExists = users.stream().anyMatch(c -> c.equals(b));
        System.out.println(itemExists);


        System.out.println("=======DEBUGGING=======");
        System.out.println("----User hinzufügen----");
        System.out.println(users.toString()); // Ausgabe in der Konsole

    }
}
