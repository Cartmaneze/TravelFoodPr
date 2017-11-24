package travelFood.view;

import travelFood.controller.ControllerDayMenu;
import travelFood.controller.ControllerJourneyMenu;
import travelFood.controller.ControllerMeal;
import travelFood.controller.ControllerMealWithWeight;

/**
 * Created by Никита on 25.05.2017.
 */
public class BeanController {
    public static ControllerJourneyMenu getJourneyMenu() {
        return journeyMenu;
    }

    public static ControllerDayMenu getDayMenu() {
        return dayMenu;
    }

    public static ControllerMealWithWeight getMealWithWeight() {
        return mealWithWeight;
    }

    public static ControllerMeal getMeal() {
        return meal;
    }

    private static ControllerJourneyMenu journeyMenu;
    private static ControllerDayMenu dayMenu;
    private static ControllerMealWithWeight mealWithWeight;
    private static ControllerMeal meal;

    public BeanController(ControllerJourneyMenu journeyMenu, ControllerDayMenu dayMenu, ControllerMealWithWeight mealWithWeight, ControllerMeal meal) {
        this.journeyMenu = journeyMenu;
        this.dayMenu = dayMenu;
        this.mealWithWeight = mealWithWeight;
        this.meal = meal;
    }
}
