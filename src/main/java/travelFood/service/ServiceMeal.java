package travelFood.service;

import org.springframework.stereotype.Service;
import travelFood.model.Meal;
import travelFood.repository.MealRepository;

import java.util.List;

/**
 * Created by Никита on 20.05.2017.
 */
@Service
public class ServiceMeal {
    MealRepository mealRepository;

    public ServiceMeal(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void saveOrUpdate(Meal meal) {
        if (mealRepository.saveOrUpdate(meal) == null) {
            System.out.println("not saved");
        } else {
            System.out.println("saved");
        }
    }

    public void delete(int id) {
        if (mealRepository.delete(id)) {
            System.out.println("delete");
        } else {
            System.out.println("not delete");
        }
    }

    public Meal get(int id) {
        return mealRepository.get(id);
    }

    public List<Meal> getAll() {
        return mealRepository.getAll();
    }
}
