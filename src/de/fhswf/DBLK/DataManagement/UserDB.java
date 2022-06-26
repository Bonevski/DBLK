package de.fhswf.DBLK.DataManagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

import static de.fhswf.DBLK.DataManagement.User.checkAdmin;


/**
 * @author Sasha
 */
public class UserDB implements IUserPersistence{

    private ArrayList<User> users;

    /**
     * Erzeugung eines neuen Objektes
     */
    Scanner sc;

    /**
     * Konstruktor User
     * (Erzeugt eine leere Liste von Usern)
     */
    public UserDB(){
        this.users = new ArrayList<User>();
        sc = new Scanner(System.in);
    }

    /**
     * Fügt einen neuen User der Liste hinzu
     * @param newUser
     */
    public void addUser(User newUser){
        // überprüfen, ob der Username schon existiert (Doppeluser
        // verhindern)
        if(this.users.contains(newUser)) {
            // Exception (Fehler) werfen, wenn der Usernamen schon existiert
            throw new IllegalArgumentException("Der User ist bereits registriert!");
        }
        this.users.add(newUser);
    }

    /**
     * Entfernt ein User aus der Liste. (entfernt alle User, die den
     * jeweiligen Namen haben)
     * @param username
     */
    public void removeUser(String username) {
        //if(checkAdmin(username) == true) {
            User user;
            // Iterator um die ArrayList zu durchlaufen
            // Zeiger der die Elemente einer Menge durchläuft
            Iterator<User> iter = this.users.iterator();
            // solange es noch Elemente in der ArrayList gibt...
            while (iter.hasNext()) {
                // ...sich den nächsten Eintrag nehmen...
                user = iter.next();
                // ...und überprüfen ob der Name mit dem zu entfernenden Namen übereinstimmt...
                if (user.getUsername().equals(username)) {
                    // ...wenn, dann diesen Eintrag aus der ArrayList entfernen
                    iter.remove();
                }
            }
        //}else{
        //    System.out.println("No Permissions!");
        //}
    }

    /**
     * Gibt den anzulegenden User aus
     * (Kontrolle der Daten)
     */
    public void printMe() {
        for (User u : users) {
            // Felder im Array, die keinen Eintrag haben, werden ignoriert
            if (u != null) {
                u.printMe();
            }
        }
    }



    public static void main(String[] args){
        System.out.println(User.newCode());
    }
}
