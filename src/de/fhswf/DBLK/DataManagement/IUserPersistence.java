package de.fhswf.DBLK.DataManagement;

/**
 * @author Sasha
 */
public interface IUserPersistence {

public UserDB getUser (String userName);
public String getPassword (UserDB userName);
public void setPassword (String password);
}
