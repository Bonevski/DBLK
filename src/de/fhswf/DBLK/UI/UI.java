package de.fhswf.DBLK.UI;
import java.util.Scanner;

public class UI {

       public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Hallo, bitte wähle ein Punkt aus:");
        System.out.println("1 für Raumanzeige");
        System.out.println("2 für Raumbuchung");
        System.out.println("3 für Raumstornierung");

        int var = Integer.parseInt(sc.nextLine());

        switch (var) {
            case 1:
                System.out.println("Raumanzeige:");
                break;
            case 2:
                System.out.println("Raumbuchung:");
                break;
            case 3:
                System.out.println("Raumstornierung:");
                break;
            default:
                System.out.println("Keine gueltige Auswahl (1, 2, 3) getroffen.");
        }
    }
}
