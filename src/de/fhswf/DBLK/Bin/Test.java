package de.fhswf.DBLK.Bin;

import de.fhswf.DBLK.Logic.BookingManager;
import de.fhswf.DBLK.Logic.IRBS;

import javax.swing.*;
import java.util.Scanner;

public class Test implements IRBS {
    public static void main(String[] args) {

        /**
         * Hier wird der User erstellt
         */
        Scanner sc = new Scanner(System.in);
        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JPasswordField confirmPassword = new JPasswordField();
        JTextField email = new JTextField();

        Object[] message = {"Username:", username, "Password:", password, "Confirm Password:", confirmPassword, "Email:", email};

        int option = JOptionPane.showConfirmDialog(null, message, "Create User", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            BookingManager.checkPW("" + username.getText(),"" + password.getPassword(),
                    "" + password.getPassword(), "" + email.getText());
        }else {
            System.out.println("Login canceled");
        }
    }
}
