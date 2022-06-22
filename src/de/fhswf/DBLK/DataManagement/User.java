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
     * @param password
     * @param authCode
     */
    public User(String name, int id, String email/*, String password, int authCode*/){
        this.name = name;
        this.id = id;
        this.email = email;
        //this.password = password;
        //this.authCode = (int) Math.random() + 1;
    }

    /**
     * Gibt den anzulegenden User aus
     * (Kontrolle der Daten)
     */
    public void printMe(){
        System.out.println("User: " + name + " | ID: " + id + " | Email: " + email);

    }
    public static void main(String[] args){

    }

}
