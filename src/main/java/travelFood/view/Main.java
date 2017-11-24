package travelFood.view;

import com.sun.javafx.application.LauncherImpl;

import java.io.File;
import java.io.IOException;

/**
 * Created by Никита on 06.07.2017.
 */
public class Main {
    public static String pathToDBFromJar;
    public static void main(String[] args) throws IOException {
        pathToDBFromJar = "jdbc:hsqldb:file:" + new File("").getAbsolutePath().replaceAll("\\\\","/") + "/db/TravelFoodDB";

        LauncherImpl.launchApplication(TFWindow.class, MyPreloader.class, args);
    }
}
