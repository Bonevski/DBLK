package de.fhswf.DBLK;

import javax.swing.*;

/**
 * @author Sasha
 */
public class Main {

    public static void main(String[] args) {
        /**
         * Hier wird der Login versucht
         */
        JTextField username = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {"Username:", username, "Password:", password};

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (username.getText().equals("Bonevski") && password.getText().equals("Test")) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
        } else {
            System.out.println("Login canceled");
        }
    }
}
