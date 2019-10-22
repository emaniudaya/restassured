import java.io.*;

class Test implements Serializable {
    int i=10, j=20;
}

public class SerialnDesrial {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Test t1 = new Test();
        //Serialization
        FileOutputStream fo = new FileOutputStream("test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fo);
        oos.writeObject(t1);
        //Deserialization
        FileInputStream fi = new FileInputStream("test.txt");
        ObjectInputStream ois = new ObjectInputStream(fi);
        Test t2 = (Test) ois.readObject();
        System.out.println(t2.i+  "  "+ t2.j);
    }
}
