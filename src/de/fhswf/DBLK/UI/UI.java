package de.fhswf.DBLK.UI;

import java.util.Scanner;

/**
 * @author Sasha
 */
public class UI {

    public static void main(String[] args) {

        /**
         * Hier wird das Menü ausgwehählt
         */
        System.out.println("Bitte geben Sie Ihre Rolle ein: ");
        System.out.println("'1' --> Student | '2' --> Admin");
        Scanner sc = new Scanner(System.in);

        int role = Integer.parseInt(sc.nextLine());

        switch (role) {
            case 1:
                System.out.println("Rolle: Student");
                System.out.println("Bitte wähle ein Punkt aus:");
                System.out.println("1 für Raumanzeige");
                System.out.println("2 für Raumbuchung");
                System.out.println("3 für Raumstornierung");
                int varStudent = Integer.parseInt(sc.nextLine());

                switch (varStudent) {
                    case 1:
                        System.out.println("Raumanzeige:");
                        // Methode Raumanzeigen aufrufen
                        break;
                    case 2:
                        System.out.println("Raumbuchung:");
                        // Methode Raumbuchen aufrufen
                        break;
                    case 3:
                        System.out.println("Raumstornierung:");
                        // Methode Raumstornierung aufrufen
                        break;
                    default:
                        System.out.println("Keine gültige Auswahl (1, 2, 3) getroffen.");
                }
                break;

            case 2:
                System.out.println("Rolle: Admin");
                System.out.println("Bitte wähle ein Punkt aus: ");
                System.out.println("1 für addUser");
                System.out.println("2 für removeUser");
                int varAdmin = Integer.parseInt(sc.nextLine());
                switch (varAdmin) {
                    case 1:
                        System.out.println("addUser wird ausgeführt:");
                        // Methode addUser aufrufen
                        break;
                    case 2:
                        System.out.println("removeUser wird ausgeführt:");
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
