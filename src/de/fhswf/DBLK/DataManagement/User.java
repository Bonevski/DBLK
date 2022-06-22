package de.fhswf.DBLK.DataManagement;

/**
 * @author Sasha
 */
public class User implements IUserPersistence{

    String name;
    int id;
    String email;
    String password;
    int authCode;

    /**
     * Konstruktor User
     * @param name
     * @param id
     * @param email
     */
    public User(String name, int id, String email){
        this.name = name;
        this.id = id;
        this.email = email;
        this.authCode = newCode();
    }

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
        System.out.println("User: " + name + " | ID: " + id + " | Email: " + email);

    }
    public static void main(String[] args){
        System.out.println(newCode());
    }

}
