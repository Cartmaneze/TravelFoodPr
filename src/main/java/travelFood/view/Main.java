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
        pathToDBFromJar = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        pathToDBFromJar = pathToDBFromJar.substring(1);
        pathToDBFromJar = "jdbc:hsqldb:file:" + pathToDBFromJar.replace("classes/", "db/TravelFoodDB").replace("TravelFood.jar", "db/TravelFoodDB");
        System.out.println("pathToDBFromJar - " + pathToDBFromJar);
        LauncherImpl.launchApplication(TFWindow.class, MyPreloader.class, args);
    }
}
