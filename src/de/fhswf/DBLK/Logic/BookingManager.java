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
     * User Login
     */
    public static void login() {
        UserDB users = new UserDB();
        JTextField username = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {"Username:", username, "Password:", password};


        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (!username.getText().isEmpty() && password.getText().equals(users.getPassword())) {
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
     kommt nach drücken des Cancel Buttons trotzdem subMenue()
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

            // Passwörter check ob es empty ist und übereinstimmt
            if (password.getText().isEmpty() || !password.getText().equals(confirmPassword.getText())) {
                JOptionPane.showMessageDialog(null, "Passwords don't match!", "ERROR", JOptionPane.ERROR_MESSAGE);
                createUser();
            } else {
                // Email überprüfen ob @fh-swf.de enthalten ist und mehr als 10 Zeichen
                if (email.getText().length() > 10 && email.getText().contains("@fh-swf.de")) {
                    JOptionPane.showMessageDialog(null, "User was created");
                    // User in die DB einfügen
                    db.addUser(new User(username.getText(), password.getText(), email.getText()));
                    // Testausgabe ob der User angelegt wurde
                    db.toString();
                    mainMenue();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong email!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    createUser();
                }
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
     * Hauptemnü erstellt
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
        login();
        //createUser();



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
