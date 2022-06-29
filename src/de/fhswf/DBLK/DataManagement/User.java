package de.fhswf.DBLK.DataManagement;


/**
 * @author Sasha
 */

import java.util.ArrayList;

/**
 * Klasse für ein User
 */
public class User implements IUserPersistence{

    private static String username;
    private static String email;
    private static String password;
    private int authCode;
    private static String role; //Admin oder User

    /**
     * Konstruktor User
     * @param username
     * @param password
     * @param email
     */
    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    //    this.authCode = newCode();
    }

    /**
     * Getter/Setter
     */
    public String getUsername(){
        return this.username;
    }

    String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    @Override
    public ArrayList<User> getUsers() {
        return null;
    }

    void setPassword(String password){
        this.password = password;
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
    public String toString() {
        return "Username: " + username + " | Passwort: " + password + " | Email: " + email;
    }

    /**
     * Überprüfung ob Admin oder nicht
     * @param username
     * @return
     */
    public static boolean checkAdmin(String username){
        if(username.contains("A_")){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Debugging
     * @param args
     */
    public static void main(String[] args){
        User user = new User("Bonevski", "Test", "Bonevski.sasha@fh-swf.de");
        user.toString();
    }

    @Override
    public void addUser(User newUser) {

    }
}
