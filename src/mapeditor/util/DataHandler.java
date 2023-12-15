package mapeditor.util;

import java.io.*;

public class DataHandler {
    static String filePath = "E:\\pathfinding\\res\\map_data\\output.csv";

    public static void addData(String name1, String name2, String distance) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath, true);
            String text = name1 + ", " + name2 + ", " + distance + "\n";
            fos.write(text.getBytes());

            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
