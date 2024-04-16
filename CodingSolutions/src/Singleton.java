/**
  SINGLETON PATTERN ->
 * Should be used when a class must have a single instance available.
 * Disables all means of creating objects of a class except for the special static creation method.
 * Returns the existing instance if it has already been created.
 * Its code needs to be adapted to handle multiple threads.
 */

public class Singleton {
    //First step is to create a private static field inside singleton and create instance
    //this volatile keyword ensures that multiple thread are being handle the singleton instance correctly
    private static volatile Singleton instance;
    //create any attributes to the singleton class
    private String data; //in case of db we may store username or password like this
    //then we need to constructor to create an object based on this class
    //and make sure the access level of this constructor is set to private
    private Singleton(){
        //inside we can initialise all the attributes of our object
        //this.data = data;
    }
    //we made the constructor private because we only need access to it
    // using a public static method inside a singleton class
    //Usually we name it getInstance which refer to single instance
    public static Singleton getInstance() {
        //since class is volatile variable must be accessed everytime by reading it directly from the main memory
        //Which makes system to check twice one from if statement and another from return statement
        //to access the variable once we can store this in local variable(result) first time when we retrieve it.
        Singleton result = instance;
        //every thread has to wait before returning.so it can be solved by DOUBLE_CHECKED_LOCKED_IDIOM
        //this will improve performance of code by limiting synchronization to the construction of new instance
        //by skipping synchronization when retrieving an already-created instance
        if (result == null) {
            //since there is a multi-thread problem where two thread can access same instance at same time
            // and may return two instance for the class. So, we have to wrap the singleton class with
            //Synchronized block
            synchronized (Singleton.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Singleton();
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Singleton obj1 =  Singleton.getInstance();

    }

}
