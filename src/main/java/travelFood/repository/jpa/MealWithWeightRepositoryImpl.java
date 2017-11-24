package travelFood.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import travelFood.repository.MealWithWeightRepository;
import travelFood.model.MealWithWeight;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Никита on 14.05.2017.
 */

@Repository
@Transactional(readOnly = true)
public class MealWithWeightRepositoryImpl implements MealWithWeightRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public MealWithWeight saveOrUpdate(MealWithWeight mealWithWeight) {
        if (mealWithWeight.isNew()) {
            em.persist(mealWithWeight);
            return mealWithWeight;
        } else if (!mealWithWeight.isNew() && get(mealWithWeight.getId()) != null) {
            return em.merge(mealWithWeight);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        if (get(id) == null) {
            return false;
        } else {
            return em.createNamedQuery(MealWithWeight.DELETE).setParameter("id", id).executeUpdate() != 0;
        }
    }

    @Override
    public List<MealWithWeight> getAll(int dayId) {
        return em.createNamedQuery(MealWithWeight.GET_ALL, MealWithWeight.class).setParameter("dayId", dayId).getResultList();
    }

    @Override
    public MealWithWeight get(int id) {
        MealWithWeight mealWithWeight = em.find(MealWithWeight.class, id);
        return mealWithWeight;
    }
}
