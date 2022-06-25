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
    void login() {
        JTextField username = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {"Username:", username, "Password:", password};

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (username.getText().equals("Bonevski") && password.getText().equals("h")) {
                System.out.println("Login successful");
            } else {
                System.out.println("login failed");
            }
        } else {
            System.out.println("Login canceled");
        }
    }

    /**
     * User wird hier erstellt
     *
     * @return
     */
    void createUser() {

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
        System.out.println("Bitte geben Sie Ihre Rolle ein: ");
        System.out.println("'1' --> Student | '2' --> Admin");
        Scanner sc = new Scanner(System.in);

        int role = Integer.parseInt(sc.nextLine());

        /**
         * Switch-Case für die Rollen
         */
        switch (role) {
            case 1:
                System.out.println("Rolle: Student");
                System.out.println("Bitte wähle ein Punkt aus:");
                System.out.println("1 für Raum anzeigen");
                System.out.println("2 für Raum buchen");
                System.out.println("3 für Raum stornieren");
                int varStudent = Integer.parseInt(sc.nextLine());

                /**
                 * Switch-Case für die Auswahl für
                 * die Rolle "Student"
                 */
                switch (varStudent) {
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

            case 2:
                System.out.println("Rolle: Admin");
                System.out.println("Bitte wähle ein Punkt aus: ");
                System.out.println("1 für User hinzufügen");
                System.out.println("2 für User entfernen");
                int varAdmin = Integer.parseInt(sc.nextLine());

                /**
                 * Switch-Case für die Auswahl für
                 * die Rolle "Admin"
                 */
                switch (varAdmin) {
                    case 1:
                        System.out.println("User hinzufügen:");
                        // Methode addUser aufrufen
                        break;
                    case 2:
                        System.out.println("User entfernen:");
                        // Methode removeUser aufrufen
                        break;
                    default:
                        System.out.println("Keine gültige Auswahl (1, 2) getroffen.");
                }
                break;
            default:
                System.out.println("Keine gültige Auswahl (1, 2) getroffen.");
        }

    }
}
