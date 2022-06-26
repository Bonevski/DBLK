package de.fhswf.DBLK.DataManagement;


/**
 * @author Sasha
 */

/**
 * Klasse für ein User
 */
public class User {

    private String username;
    private String email;
    private String password;
    private int authCode;
    private String role; //Admin oder User

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
        System.out.println("Username: " + username + " | Passwort: " + password + " | Email: " + email);
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
        user.printMe();
    }
}
