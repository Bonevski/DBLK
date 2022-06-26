package de.fhswf.DBLK.UI;

import de.fhswf.DBLK.Logic.BookingManager;

import javax.swing.*;
import java.util.Scanner;

/**
 * @author Sasha
 */
public class UI {

    /**
     * User Login
     */
    static String login() {
        String str = "";
        JTextField username = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {"Username:", username, "Password:", password};

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (username.getText().equals("Bonevski") && password.getText().equals("Test")) {
                // Login successful
                str = "Login successful!";
            } else {
                // Login failed
                str = "Login failed!";
            }
        } else {
            str = "Login canceled!";
        }
        return str;
    }

    /**
     * User wird hier erstellt
     *
     * @return
     */
    static void createUser() {

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JPasswordField confirmPassword = new JPasswordField();
        JTextField email = new JTextField();

        Object[] message = {"Username:", username, "Password:", password, "Confirm Password:", confirmPassword, "Email:", email};

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            BookingManager.check("" + password,
                    "" + confirmPassword, "" + email);
        } else {
            System.out.println("Login canceled");
        }
    }

    public static void main(String[] args) {

        /**
         * Hier wird das Menü ausgewählt
         */
        System.out.println("Bitte geben Sie ein: ");
        System.out.println("'1' --> Login | '2' --> User erstellen");
        Scanner sc = new Scanner(System.in);

        int log = Integer.parseInt(sc.nextLine());

        /**
         * Switch-Case für das Login
         */
        switch (log) {
            case 1:
                login();
                System.out.println("Bitte wähle ein Punkt aus:");
                System.out.println("1 für Raum anzeigen");
                System.out.println("2 für Raum buchen");
                System.out.println("3 für Raum stornieren");
                int var = Integer.parseInt(sc.nextLine());

                /**
                 * Switch-Case für die Auswahl
                 */
                switch (var) {
                    case 1:
                        System.out.println("Raum anzeigen:");
                        // Methode Raumanzeigen aufrufen
                        break;
                    case 2:
                        System.out.println("Raum buchen:");
                        // Methode Raumbuchen aufrufen
                        break;
                    case 3:
                        System.out.println("Raum stornieren:");
                        // Methode Raumstornierung aufrufen
                        break;
                    default:
                        System.out.println("Keine gültige Auswahl (1, 2, 3) getroffen.");
                }
                break;

            /**
             * Switch-Case für User erstellen
             */
            case 2:
                createUser();
                System.out.println("Bitte wähle ein Punkt aus:");
                System.out.println("1 für Raum anzeigen");
                System.out.println("2 für Raum buchen");
                System.out.println("3 für Raum stornieren");
                var = Integer.parseInt(sc.nextLine());

                /**
                 * Switch-Case für die Auswahl
                 */
                switch (var) {
                    case 1:
                        System.out.println("Raum anzeigen:");
                        // Methode Raumanzeigen aufrufen
                        break;
                    case 2:
                        System.out.println("Raum buchen:");
                        // Methode Raumbuchen aufrufen
                        break;
                    case 3:
                        System.out.println("Raum stornieren:");
                        // Methode Raumstornierung aufrufen
                        break;
                    default:
                        System.out.println("Keine gültige Auswahl (1, 2, 3) getroffen.");
                }
                break;
        }

    }
}
