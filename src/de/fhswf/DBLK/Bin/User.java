package de.fhswf.DBLK.Bin;

import de.fhswf.DBLK.DataManagement.UserDB;

/**
 * @author Sasha
 */

/**
 * Klasse für ein User
 */
public class User {

    private String username;
    private int id;
    private String email;
    private String password;
    private int authCode;

    /**
     * Konstruktor User
     * @param username
     * @param id
     * @param email
     */
    public User(String username, int id, String email){
        this.username = username;
        this.id = id;
        this.email = email;
        this.authCode = newCode();
    }

    /**
     * Getter/Setter
     */
    public String getUsername(){
        return username;
    }

    String getEmail(){
        return email;
    }

    String getPassword(){
        return password;
    }

    String setPassword(String password){
        return password;
    }

    /**
     * Generiert einen 4-stelligen Code, welcher hier
     * der Authentifizierungscode ist
     * @return
     */
    public static int newCode(){
        String checkCode;
        int pinCode;
        do{
            pinCode = (int) (Math.random() * 9999);
            checkCode = "" + pinCode;
        }while(checkCode.length() != 4);
        return pinCode;
    }

    /**
     * Gibt den anzulegenden User aus
     */
    public void printMe() {
        System.out.println("Name: " + username + " | ID: " + id + " | Email: " + email);
    }

    public static void main(String[] args){
        User user = new User("Bonevski", 30153215, "Bonevski.sasha@fh-swf.de");
        user.printMe();
    }
}
