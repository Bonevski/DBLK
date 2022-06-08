package de.fhswf.DBLK.DataManagement;

/**
 * @author Sasha
 */
public class User implements IUserPersistence{

    private String name;
    private int ID;
    private String email;
    private String password;
    private int authCode;

    User(String name, int ID, String email, String password, int authCode){
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.password = password;
        this.authCode = (int) Math.random() + 1;
    }
    String getUser(User name){
        return name + "";
    }
    public static void main(String[] args){

    }

}
