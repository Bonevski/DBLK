package de.fhswf.DBLK.datamanagement;

/**
 * @author Sasha
 */
public interface IUserPersistence {

    void printMe();

    public void addUser(User newUser);
    void removeUser(String username);
    public void loadUserDatabase();
    public void saveUserDatabase();
    //public String getUsername();
   // public String getPassword();

    //ArrayList<User> getUsers();
}
