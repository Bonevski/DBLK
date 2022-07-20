package de.fhswf.DBLK.bin;



import de.fhswf.DBLK.datamanagement.Room;
import de.fhswf.DBLK.datamanagement.RoomDB;

//exceptions
import java.io.*;

//file save

//file load


public class TestStoreLoadFiles implements Serializable {

    /**
     * @author Christoph
     */


    /**
     * write object to file
     * https://attacomsian.com/blog/java-write-object-to-file
     */


    public static void main(String[] args) {


        //store file

        //create file
        try {
                FileOutputStream fosroomdb = new FileOutputStream(new File("RoomDB.dat"));
             ObjectOutputStream oosroomdb = new ObjectOutputStream(fosroomdb);

            // create a new room object
            //Room h105 = new Room("H105"); //creation takes place below

            //create new room list --> static / non static error if roomList entered through main
            RoomDB blub = new RoomDB();


            // room is created and directly added into room list
            blub.addRoom(new Room("h105")); //

            // write object to file
            oosroomdb.writeObject(blub); //toString zum schreiben


//open file
            FileInputStream fisroomdb = new FileInputStream(new File("RoomDB.dat"));
            ObjectInputStream oisroomdb = new ObjectInputStream(fisroomdb);

            // Read objects
            Room pr1 = (Room) oisroomdb.readObject();


            System.out.println(pr1.toString());
            // Room.printMe(pr1); static not static error..


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }//main1

/*
    public static void main(String[] args) {

        Person p1 = new Person("John", 30, "Male");
        Person p2 = new Person("Rachel", 25, "Female");

        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.dat"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(p1);
            o.writeObject(p2);

            o.close();
            f.close();

            FileInputStream fi = new FileInputStream(new File("myObjects.dat"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Person pr1 = (Person) oi.readObject();
            Person pr2 = (Person) oi.readObject();

            System.out.println(pr1.toString());
            System.out.println(pr2.toString());

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }//main2

 */
}
