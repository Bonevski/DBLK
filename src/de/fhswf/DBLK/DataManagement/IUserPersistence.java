package de.fhswf.DBLK.DataManagement;

import java.util.ArrayList;

/**
 * @author Sasha
 */
public interface IUserPersistence {

    void printMe();

    public void addUser(User newUser);


    void removeUser(String username);
    //public String getUsername();
   // public String getPassword();

    //ArrayList<User> getUsers();
}
