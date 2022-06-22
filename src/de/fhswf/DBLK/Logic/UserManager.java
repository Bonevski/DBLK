package de.fhswf.DBLK.Logic;

import de.fhswf.DBLK.DataManagement.IUserPersistence;
import de.fhswf.DBLK.DataManagement.User;

public class UserManager {

    private IUserPersistence[] users;

    UserManager(int size){
        users = new User[size];
    }
    /**
     * Gibt alle User auf der konsole aus
     */
    void printMe() {
        for (IUserPersistence u : users) {
            // Felder im Array, die keinen Eintrag haben, werden ignoriert
            if (u != null) {
                u.printMe();
            }
        }
    }
    /**
     * Wenn Platz in der Datenbank ist, wird ein neuer User erzeugt und in
     * die Datenbank eingefügt. Wenn die DB voll ist, wird eine Fehlermeldung
     * ausgegeben
     *
     * @param name
     * @param id
     * @param email
     */
    void addUser(String name, int id, String email) {
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
            // Ansonsten genau an dieser Stelle einen neuen Student einfügen
            users[firstFreeIndex] = new User(name, id, email);
    }

    /**
     * Der User mit der übergebenen ID wird aus der Datenbank
     * gelöscht. Wenn die ID nicht gefunden wird, wird eine
     * Fehlermeldung ausgegeben
     *
     * @param id
     */
    /* void removeUser(int id) {
        for (int i = 0; i < users.length; i++) {
            // Auch hier die Überprüfung auf null, damit keine
            // NullPointerExceptions geworfen werden
            if ((users[i] != null) && (users[i].id == id)) {
                users[i] = null;
                return;
            }
        }
        System.out.println("Student wurde nicht gefunden!");

    }*/
}

