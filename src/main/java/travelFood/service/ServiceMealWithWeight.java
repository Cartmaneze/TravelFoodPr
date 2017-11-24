package travelFood.service;

import org.springframework.stereotype.Service;
import travelFood.model.Meal;
import travelFood.model.MealWithWeight;
import travelFood.repository.MealWithWeightRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Никита on 20.05.2017.
 */
@Service
public class ServiceMealWithWeight {
    MealWithWeightRepository mealWithWeightRepository;

    public ServiceMealWithWeight(MealWithWeightRepository mealWithWeightRepository) {
        this.mealWithWeightRepository = mealWithWeightRepository;
    }

    public void saveOrUpdate(MealWithWeight mealWithWeight) {
        if (mealWithWeightRepository.saveOrUpdate(mealWithWeight) == null) {
            System.out.println("not saved");
        } else {
            System.out.println("saved");
        }
    }

    public void delete(int id) {
        if (mealWithWeightRepository.delete(id)) {
            System.out.println("delete");
        } else {
            System.out.println("not delete");
        }
    }

    public MealWithWeight get(int id) {
        return mealWithWeightRepository.get(id);
    }

    public List<MealWithWeight> getAll(int dayId) {
        List<MealWithWeight> blankList = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            MealWithWeight mealWithWeight = new MealWithWeight();
            Meal meal = new Meal();
            meal.setName("");
            mealWithWeight.setMeal(meal);
            blankList.add(mealWithWeight);
        }
        List<MealWithWeight> listFromBase = mealWithWeightRepository.getAll(dayId);

        for (int i = 0; i < listFromBase.size(); i++) {
            int tableId = listFromBase.get(i).getIdTable();
            blankList.set(tableId, listFromBase.get(i));
        }

        return blankList;
    }
}
