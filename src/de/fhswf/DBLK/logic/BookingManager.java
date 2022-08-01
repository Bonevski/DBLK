package de.fhswf.DBLK.logic;

import de.fhswf.DBLK.datamanagement.Room;
import de.fhswf.DBLK.datamanagement.RoomDB;
import de.fhswf.DBLK.datamanagement.User;
import de.fhswf.DBLK.datamanagement.UserDB;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;


/**
 * @author Sasha
 */

public class BookingManager implements IRBS {
    protected Date[] days;
    protected ArrayList<Integer> planPerDay = new ArrayList<Integer>();

    /**
     * Password check if password is valid or not
     * Passwort muss 8-15 Zeichen lang sein, Groß- und Kleinbuchstaben
     * Passwort muss eine Zahl beinhalten
     * Passwort darf nicht " " sein
     *
     * @param password
     * @return
     */

    public static boolean isValid(String password) {

        // Passwort Check ob es gültig ist
        // muss zwischen 8 und 15 Zeichen lang sein
        if (!((password.length() >= 8)
                && (password.length() <= 15))) {
            return false;
        }

        // darf keine leere Eingabe sein
        if (password.contains(" ")) {
            return false;
        }
        if (true) {
            int count = 0;
            // Zahlen von 0 bis 9 Prüfen
            for (int i = 0; i <= 9; i++) {
                // in ein String konvertieren
                String str1 = Integer.toString(i);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        }
        /*
        // Funktioniert  nicht wie ich es möchte!!
        // für Sonderzeichen
        if (!(password.contains("@") || password.contains("#")
                || password.contains("!") || password.contains("~")
                || password.contains("$") || password.contains("%")
                || password.contains("^") || password.contains("&")
                || password.contains("*") || password.contains("(")
                || password.contains(")") || password.contains("-")
                || password.contains("+") || password.contains("/")
                || password.contains(":") || password.contains(".")
                || password.contains(", ") || password.contains("<")
                || password.contains(">") || password.contains("?")
                || password.contains("|"))) {
            return false;
        }
        */
        if (true) {
            int count = 0;
            // muss mindestens einen Großbuchstaben enthalten
            for (int i = 65; i <= 90; i++) {
                char c = (char) i;
                String str1 = Character.toString(c);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        }

        if (true) {
            int count = 0;
            // muss mindestens einen Kleinbuchstaben enthalten
            for (int i = 97; i <= 122; i++) {
                char c = (char) i;
                String str1 = Character.toString(c);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * User Login
     */
    public static void login() {
        JTextField username = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {"Username:", username, "Password:", password};


        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (isValid(password.getText())) {
                JOptionPane.showMessageDialog(null, "Login successful!");
                subMenu();
            } else {
                JOptionPane.showMessageDialog(null, "Login failed!", "ERROR", JOptionPane.ERROR_MESSAGE);
                login();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login canceled!", "ERROR", JOptionPane.ERROR_MESSAGE);
            mainMenu();
        }
    }

    /**
     * User wird hier erstellt
     * Überprüfung des Passworts plus E-mail
     */

    public static void createUser() {

        // DB erstellen
        UserDB db = new UserDB();
        // Textfeld erstellen
        JTextField username = new JTextField();
        JTextField password = new JPasswordField();
        JTextField confirmPassword = new JPasswordField();
        JTextField email = new JTextField();


        Object[] message = {"Username:", username, "Password:", password, "Confirm Password:", confirmPassword, "Email:", email};

        // Emailvoragbe  "@fh-swf.de"
        email.setText("@fh-swf.de");
        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            // Check ob Anforderungen erfüllt werden
            if (isValid(password.getText())) {
                // Passwörter check, ob Sie übereinstimmen
                if (!password.getText().equals(confirmPassword.getText())) {
                    JOptionPane.showMessageDialog(null, "Passwords don't match!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    createUser();
                } else {
                    // Email überprüfen ob @fh-swf.de enthalten ist und mehr als 10 Zeichen
                    if (email.getText().length() > 10 && email.getText().contains("@fh-swf.de")) {
                        JOptionPane.showMessageDialog(null, "User was created");
                        // User in die DB einfügen
                        db.addUser(new User(username.getText(), password.getText(), email.getText()));
                        // Testausgabe ob der User angelegt wurde
                        // db.printMe(); //--> User wird in die DB eingefügt
                        mainMenu();
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong email!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        createUser();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Requirements not fulfilled!", "ERROR", JOptionPane.ERROR_MESSAGE);
                createUser();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Creating User canceled", "ERROR", JOptionPane.ERROR_MESSAGE);
            mainMenu();
        }

    }

    /**
     * @author Sasha und Christoph
     * SubMenü created
     * 5 possible choices
     * show booking | book | cancel booking | create room | delete room
     */
    //TODO static issue f.e.
    // Error: Non-static method  'createRoom()' cannot be referenced from a static context
    // if made static Override does not work, because static method needs a body in the interface
    // method create room
    public static void subMenu() {
        String choose = JOptionPane.showInputDialog(null, "Please select an item:\n" +
                "['1' -> Show Room | '2' ->  Book room | '3' -> Cancel room] | '4' -> Create room] | '5' -> delete room]");
        if (choose.contains("1")) {
            JOptionPane.showMessageDialog(null, "Show room:");
            //listAllRooms();
            // method show
        } else if (choose.contains("2")) {
            JOptionPane.showMessageDialog(null, "Book room:");
            //bookRoom();
            // method book
        } else if (choose.contains("3")) {
            JOptionPane.showMessageDialog(null, "Cancel room:");
            //cancelRoom();
            // method cancel
        } else if (choose.contains("4")) {
            JOptionPane.showMessageDialog(null, "create room:");
            // createRoom();

        } else if (choose.contains("5")) {
            JOptionPane.showMessageDialog(null, "delete room:");
            //deleteRoom(); // same error as createRoom()
            // method delete room
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect!", "ERROR", JOptionPane.ERROR_MESSAGE);
            mainMenu();
        }
    }


    /**
     * Hauptmenü erstellt
     * Auswahl zwischen User erstellen und Login
     */
    public static void mainMenu() {
        String choose = JOptionPane.showInputDialog(null, "Please select an item: \n '1' -> Login | '2' -> Create User");
        //int men = Integer.parseInt(aus);

        if (choose.contains("1")) {
            login();
        } else if (choose.contains("2")) {
            createUser();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect!", "ERROR", JOptionPane.ERROR_MESSAGE);
            mainMenu();
        }
    }

    public static void runRBS() {
        mainMenu();

    }

    public static void main(String[] args) {
        //mainMenue();
        //subMenu();
        //login();
        createUser();


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
    public void loginAccount() {

    }



    /**
     * @author Christoph
     * creates a new 'Room', adds it automatically to local room database
     * and saves the data into persistent room database
     */
    //ToDo check for admin rights, non static issue in subMenu and other classes
    @Override
    public void createRoom() {
        // create db
        RoomDB rooms = new RoomDB();
        //load persistent database
        rooms.loadRoomDatabase();

        // create Textfield
        JTextField roomName = new JTextField();

        Object[] message = {"Raumname:", roomName};

        int option = JOptionPane.showConfirmDialog(null, message, "Raum erzeugen", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            // Check if name is valid
            if (isValid(roomName.getText())) {
                // check if roomName has less than 7 characters
                if (roomName.getText().length() <= 6) {
                    JOptionPane.showMessageDialog(null, "Raumname darf nicht mehr als 7 Ziffern haben", "ERROR", JOptionPane.ERROR_MESSAGE);
                    createRoom();
                } else {
                    // create room, add room to database, save database persistent
                    rooms.addRoom(new Room(roomName.getText()));
                    rooms.saveRoomDatabase();
                    subMenu();
                }
            }
        }

    } //end createRoom()

    /**
     * @author Christoph
     * deletes an existing 'Room'from to local room database
     * and saves the data into persistent room database
     */
    //ToDo check for admin rights, non static issue in subMenu and other classes
    @Override
    public void deleteARoom() {
        // create db
        RoomDB rooms = new RoomDB();
        //load persistent database
        rooms.loadRoomDatabase();

        // create Textfield
        JTextField roomName = new JTextField();

        Object[] message = {"Raumname:", roomName};

        int option = JOptionPane.showConfirmDialog(null, message, "Raum löschen", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            // Check if name is valid
            if (isValid(roomName.getText())) {
                // check if roomName has less than 7 characters
                if (roomName.getText().length() <= 6) {
                    JOptionPane.showMessageDialog(null, "Raumname darf nicht mehr als 7 Ziffern haben", "ERROR", JOptionPane.ERROR_MESSAGE);
                    deleteARoom();
                } else {
                    // create room, add room to database, save database persistent
                    rooms.deleteRoom(roomName.getText());
                    rooms.saveRoomDatabase();
                    subMenu();
                }
            }
        }

    }//end deleteARoom()
}
