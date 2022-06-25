package de.fhswf.DBLK.DataManagement;


/**
 * @author Sasha
 */
public class UserDB implements IUserPersistence{

    private String username;
    private String email;
    private String password;
    //private int authCode;    // gedacht zur Authentifizierung per E-Mail

    /**
     * Konstruktor User
     * @param username
     * @param password
     * @param email
     */
    public UserDB(String username, String password, String email){
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
    static int newCode(){
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
     * (Kontrolle der Daten)
     */
    public void printMe(){
        System.out.println("User: " + username + " | ID: " + password + " | Email: " + email);

    }
    public static void main(String[] args){
        System.out.println(newCode());
    }

    @Override
    public UserDB getUser(String username) {
        return null;
    }

    @Override
    public String getPassword(UserDB username) {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }
}
