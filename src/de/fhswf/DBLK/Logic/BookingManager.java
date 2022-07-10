package de.fhswf.DBLK.Logic;

import de.fhswf.DBLK.DataManagement.User;
import de.fhswf.DBLK.DataManagement.UserDB;


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
            } else {
                JOptionPane.showMessageDialog(null, "Login failed!", "ERROR", JOptionPane.ERROR_MESSAGE);
                login();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login canceled!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * User wird hier erstellt
     * Überprüfung des Passworts plus E-mail
     */
    /*
     Fehler: Nach erfolgreichem User erstellen und aufrufen von mainMenue()
     kommt nach Drücken des Cancel Buttons trotzdem Fehler
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
                        // db.printMe(); --> User wird in die DB eingefügt
                        mainMenue();
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
        }

    }

    /**
     * SubMenü erstellt
     * Auswahl zwischen den 3 Möglichkeiten
     * Anzeigen | Buchen | Stornieren
     */
    public static void subMenue() {
        String choose = JOptionPane.showInputDialog(null, "Please select an item:\n" +
                "['1' -> Show Room | '2' ->  Book room | '3' -> Cancel room]");
        if (choose.contains("1")) {
            JOptionPane.showMessageDialog(null, "Show room:");
            // Methode Show
        } else if (choose.contains("2")) {
            JOptionPane.showMessageDialog(null, "Book room:");
            // Methode Book
        } else if (choose.contains("3")) {
            JOptionPane.showMessageDialog(null, "Cancel room:");
            // Methode Cancel
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect!", "ERROR", JOptionPane.ERROR_MESSAGE);
            mainMenue();
        }
    }

    /**
     * Hauptmenü erstellt
     * Auswahl zwischen User erstellen und Login
     */
    public static void mainMenue() {
        String choose = JOptionPane.showInputDialog(null, "Please select an item: \n '1' -> Login | '2' -> Create User");
        //int men = Integer.parseInt(aus);

        if (choose.contains("1")) {
            login();
            subMenue();
        } else if (choose.contains("2")) {
            createUser();
            subMenue();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect!", "ERROR", JOptionPane.ERROR_MESSAGE);
            mainMenue();
        }
    }

    public static void runRBS() {
        mainMenue();

    }

    public static void main(String[] args) {
        //mainMenue();
        //subMenue();
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
