package de.fhswf.DBLK.DataManagement;

import de.fhswf.DBLK.Bin.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;


/**
 * @author Sasha
 */
public class UserDB implements IUserPersistence{

    private ArrayList<User> users;

    //Erzeugung eines neuen Objektes
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
    void addUser(User newUser){
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
        User user;
        // Iterator um die ArrayList zu durchlaufen
        // Zeiger der die Elemente einer Menge durchläuft
        Iterator<User> iter = this.users.iterator();
        // solange es noch Elemente in der ArrayList gibt...
        while (iter.hasNext()) {
            // ...sich den nächsten Eintrag nehmen...
            user = iter.next();

            // ...und überprüfen ob der Name mit dem zu entfernenden Namen übereinstimmt...
            if(user.getUsername().equals(username)) {
                // ...wenn, dann diesen Eintrag aus der ArrayList entfernen
                iter.remove();
            } // if
        } // while
    }

    /**
     * Gibt den anzulegenden User aus
     * (Kontrolle der Daten)
     */
    void printMe() {
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

    @Override
    public UserDB getUser(String username) {
        return null;
    }

    @Override
    public String getPassword(UserDB username) {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }
}
