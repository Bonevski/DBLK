package de.fhswf.DBLK.DataManagement;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * @author Sasha
 */
public class UserDB implements IUserPersistence {

    private ArrayList<User> users;


    /**
     * Konstruktor User
     * (Erzeugt eine leere Liste von Usern)
     */
    public UserDB() {
        // leere Liste von Usern
        this.users = new ArrayList<User>();
    }

    /**
     * Fügt einen neuen User der Liste hinzu
     *
     * @param newUser
     */
    public void addUser(User newUser) {
        // überprüfen, ob der Username schon existiert (Doppeluser
        // verhindern)
        if (this.users.contains(newUser)) {
            // Exception (Fehler) werfen, wenn der Username schon existiert
            throw new IllegalArgumentException("Der User ist bereits registriert!");
        }
        this.users.add(newUser);
    }

    @Override
    public String getPassword() {
        return null;
    }


    /**
     * Entfernt ein User aus der Liste. (entfernt alle User, die den
     * jeweiligen Namen haben)
     *
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
    public String toString() {

        // StringBuilder ist Class um Strings zu "bauen"
        StringBuilder sb = new StringBuilder();

        sb.append("Datenbank der User: ");

        // die gesamte ArrayList durchlaufen und alle User hinzufügen
        for (User users : this.users) {
            sb.append(users);
            sb.append("\n");
        } // for

        sb.append("\n");

        // den gebauten String in eine Zeichenkette konvertieren
        return sb.toString();
    }

    /**
     * Methode liefert auch einen String, welcher die DB repräsentiert, doch
     * der Aufbau ist etwas übersichtlicher. (tabellarisch)
     */
    public String getPrintString() {
        StringBuilder sb = new StringBuilder();

        sb.append("' User: ");
        sb.append(this.users.size());
        sb.append("\nUsers:\n");
        sb.append("User\tPassword\t\t\tEmail\n");

        for (User users : this.users) {
            sb.append(users.getUsername());
            sb.append("\t");// zwischen den einzelnen Attributen der User wird ein TabStop eingefügt
            sb.append(users.getPassword());
            sb.append("\t");
            sb.append(users.getEmail());
            sb.append("\t\n");
        } // for

        sb.append("\n");

        return sb.toString();
    }// getPrintString

    /**
     * Gibt das Rennen tabellarisch auf der Konsole aus.
     */
    public void print() {
        System.out.println(getPrintString());
    }

    /**
     * Gibt alle User zurück
     *
     * @return
     */
    @Override
    public ArrayList<User> getUsers() {
        return this.users;
    }

    public static void main(String[] args) {
        //System.out.println(User.newCode());
        System.out.println("Datenbank erstellen...");
        UserDB db = new UserDB();

        /*
        Fehler: es wird nur der letzte User hinzugefügt
         */

        db.addUser(new User("Knips", "ck123", "Knips.chris@fh-swf.de"));
        db.addUser(new User("Lange", "sl123", "Lange.stefan@fh-swf.de"));
        db.addUser(new User("Demir", "fd123", "Demir.firat@fh-swf.de"));
        db.addUser(new User("Bonevski", "sb123", "Bonevski.sasha@fh-swf.de"));

        db.print();
    }
}
