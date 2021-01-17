package Storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteAndReadFile {
        public static void writeFile(Object obj, String FILE_NAME) {
            try {
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(obj);
                fos.close();
                oos.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static Object readFile(String FILE_NAME) {
            Object obj = null;
            try {
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
                obj = ois.readObject();
                fis.close();
                ois.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            return obj;
        }

}
