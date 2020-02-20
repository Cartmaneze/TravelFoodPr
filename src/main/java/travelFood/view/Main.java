package travelFood.view;

import com.sun.javafx.application.LauncherImpl;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * Created by Никита on 06.07.2017.
 */
public class Main {
    public static String pathToDBFromJar;
    public static void main(String[] args) throws IOException {
        pathToDBFromJar = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        pathToDBFromJar = URLDecoder.decode(pathToDBFromJar, "UTF-8");
        pathToDBFromJar = pathToDBFromJar.substring(1);
        String [] pathToDBFromJarSplited = pathToDBFromJar.split("/");
        pathToDBFromJar = "";
        for (String s : pathToDBFromJarSplited) {
            if (!s.contains(".jar") && !s.equals("classes")) {
                pathToDBFromJar += s + "/";
            } else {
                break;
            }
        }
        pathToDBFromJar += "db/TravelFoodDB";
        pathToDBFromJar = "jdbc:hsqldb:file:" + pathToDBFromJar;
        System.out.println("pathToDBFromJar - " + pathToDBFromJar);
        LauncherImpl.launchApplication(TFWindow.class, MyPreloader.class, args);
    }
}
