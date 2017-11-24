package travelFood.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import travelFood.controller.ControllerDayMenu;
import travelFood.controller.ControllerJourneyMenu;
import travelFood.controller.ControllerMeal;
import travelFood.controller.ControllerMealWithWeight;

/**
 * Created by Никита on 25.05.2017.
 */
public class TFWindow extends Application {

    @Override
    public void init() {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");

        ControllerMeal controllerMeal = appCtx.getBean(ControllerMeal.class);
        ControllerJourneyMenu journeyMenu = appCtx.getBean(ControllerJourneyMenu.class);
        ControllerDayMenu controllerDayMenu = appCtx.getBean(ControllerDayMenu.class);
        ControllerMealWithWeight controllerMealWithWeight = appCtx.getBean(ControllerMealWithWeight.class);

        BeanController beanController = new BeanController(journeyMenu, controllerDayMenu, controllerMealWithWeight, controllerMeal);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/window.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("Travel Food v1.0");
        stage.setScene(new Scene(root));
        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
                Platform.exit();
            }
        });
    }
}
