package de.fhswf.DBLK.DataManagement;

/**
 * @author Sasha
 */
public interface IUserPersistence {

public UserDB getUser (String username);
public String getPassword (UserDB username);
public void setPassword (String password);
}
