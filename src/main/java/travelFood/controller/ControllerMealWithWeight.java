package travelFood.controller;

import org.springframework.stereotype.Controller;
import travelFood.service.ServiceMealWithWeight;
import travelFood.model.MealWithWeight;

import java.util.List;

/**
 * Created by Никита on 20.05.2017.
 */
@Controller
public class ControllerMealWithWeight {
    ServiceMealWithWeight serviceMealWithWeight;

    public ControllerMealWithWeight(ServiceMealWithWeight serviceMealWithWeight) {
        this.serviceMealWithWeight = serviceMealWithWeight;
    }

    public MealWithWeight get(int id) {
        return serviceMealWithWeight.get(id);
    }

    public List<MealWithWeight> getAll(int dayId) {
        return serviceMealWithWeight.getAll(dayId);
    }

    public void delete(int id) {
        serviceMealWithWeight.delete(id);
    }

    public void saveOrUpdate(MealWithWeight mealWithWeight) {
        serviceMealWithWeight.saveOrUpdate(mealWithWeight);
    }
}
