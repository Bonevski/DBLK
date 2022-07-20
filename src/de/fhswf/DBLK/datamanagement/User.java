package de.fhswf.DBLK.datamanagement;


/**
 * @author Sasha
 */

/**
 * Klasse für einen User
 */
public class User{

    String username;
    String email;
    String password;
    //int authCode;
    //String role; //Admin oder User

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
        //this.authCode = newCode();
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
