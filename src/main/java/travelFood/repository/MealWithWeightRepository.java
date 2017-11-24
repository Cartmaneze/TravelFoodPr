package travelFood.repository;

import travelFood.model.MealWithWeight;

import java.util.List;

/**
 * Created by Никита on 14.05.2017.
 */
public interface MealWithWeightRepository {

    MealWithWeight saveOrUpdate(MealWithWeight mealWithWeight);

    boolean delete(int id);

    List<MealWithWeight> getAll(int dayId);

    MealWithWeight get(int id);
}
