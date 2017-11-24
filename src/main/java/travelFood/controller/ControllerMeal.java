package travelFood.controller;

import travelFood.model.Meal;
import org.springframework.stereotype.Controller;
import travelFood.repository.MealRepository;

import java.util.List;

@Controller
public class ControllerMeal {

    MealRepository mealRepository;

    public ControllerMeal(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public Meal get(int id) {
        return mealRepository.get(id);
    }

    public List<Meal> getAll() {
        return mealRepository.getAll();
    }

    public void saveOrUpdate(Meal meal) {
        mealRepository.saveOrUpdate(meal);
    }

    public void delete(int id) {
        mealRepository.delete(id);
    }
}
