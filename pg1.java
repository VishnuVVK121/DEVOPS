import java.io.*;

class Sample implements Serializable { 
    int id;
    String username;
    transient int password;  

    Sample(int id, String username, int password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}

class pg22 {
    public static void main(String[] args) {
        try {
            Sample s1 = new Sample(18, "swetha", 1234);  

            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("serial"));
            o.writeObject(s1); 
            o.close();  

            System.out.println("Serialized");

           
            ObjectInputStream i = new ObjectInputStream(new FileInputStream("serial"));
            Sample s2 = (Sample) i.readObject();
            i.close();  

            System.out.println("Deserialization");
            System.out.println("id: " + s2.id);
            System.out.println("username: " + s2.username);
            System.out.println("password: " + s2.password);  

        } catch (Exception e) {
           System.out.println(e);
        }
    }
}
