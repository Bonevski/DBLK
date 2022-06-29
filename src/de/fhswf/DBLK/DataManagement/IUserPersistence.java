package de.fhswf.DBLK.DataManagement;

import java.util.ArrayList;

/**
 * @author Sasha
 */
public interface IUserPersistence {

    public void addUser(User newUser);
    //public String getUsername();
    public String getPassword();

    ArrayList<User> getUsers();
}
