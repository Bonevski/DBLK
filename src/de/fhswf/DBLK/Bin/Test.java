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

        JTextField username = new JTextField(); // Eingabefeld für Username
        JTextField password = new JPasswordField(); // Eingabefeld für Password (mit ***)
        JTextField email = new JTextField(); // Eingabefeld für Email

        // Benennung der Eingabefelder
        Object[] message = {"Username:", username, "Password:", password, "Email:", email};


        //Beispiel durchlauf um i<2 User zu erstellen
        for (int i = 0; i < 2; i++) {
            // Emailvoragbe  "@fh-swf.de"
            email.setText("@fh-swf.de");

            int option = JOptionPane.showConfirmDialog(null, message, "Create User", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {

                // User wird mit den Attributen im Konstruktor in die DB hinzugefügt
                db.addUser(new User(username.getText(), password.getText(), email.getText()));

            }
            // Textfelder = Empty
            username.setText("");
            password.setText("");
        }

        System.out.println("=======DEBUGGING=======");
        System.out.println("----User hinzufügen----");
        db.printMe(); // Ausgabe in der Konsole

        System.out.println();
        System.out.println("-----User entfernen-----");
        System.out.println("------------------------");

        JTextField username2 = new JTextField(); // Eingabefeld für Username2

        Object[] message2 = {"Username:", username2}; // Benennung
        int option = JOptionPane.showConfirmDialog(null, message2, "Remove User", JOptionPane.OK_OPTION);


        db.removeUser(username2.getText()); // User (mit dem Usernamen2) wird aus der DB entfernt
        db.printMe(); // Ausgabe in der Konsole

    }
}
