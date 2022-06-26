package de.fhswf.DBLK.Bin;


import de.fhswf.DBLK.DataManagement.User;
import de.fhswf.DBLK.DataManagement.UserDB;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {

        System.out.println("Datenbank erstellen...");
        UserDB db = new UserDB();

        JTextField username = new JTextField();
        JTextField password = new JPasswordField();
        JTextField email = new JTextField();
        Object[] message = {"Username:", username, "Password:", password, "Email:", email};

        /**
         * Beispiel durchlauf um i< User zu erstellen
         */
        for (int i = 0; i < 2; i++) {
            int option = JOptionPane.showConfirmDialog(null, message, "Create User", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {

                db.addUser(new User(username.getText(), password.getText(), email.getText()));

            }

        }
        System.out.println("=======DEBUGGING=======");
        System.out.println("----User hinzufügen----");
        db.printMe();

        System.out.println();
        System.out.println("-----User entfernen-----");
        System.out.println("------------------------");

        JTextField username2 = new JTextField();
        Object[] message2 = {"Username:", username2};
        int option = JOptionPane.showConfirmDialog(null, message2, "Remove User", JOptionPane.OK_CANCEL_OPTION);

        db.removeUser(username2.getText());
        db.printMe();

    }
}
