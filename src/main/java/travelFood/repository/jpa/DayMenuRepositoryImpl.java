package travelFood.repository.jpa;

import org.springframework.transaction.annotation.Transactional;
import travelFood.model.DayMenu;
import org.springframework.stereotype.Repository;
import travelFood.repository.DayMenuRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Никита on 14.05.2017.
 */

@Repository
@Transactional(readOnly = true)
public class DayMenuRepositoryImpl implements DayMenuRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public DayMenu saveOrUpdate(DayMenu dayMenu) {
        if (dayMenu.isNew()) {
            em.persist(dayMenu);
            return dayMenu;
        } else if (!dayMenu.isNew() && get(dayMenu.getId()) != null) {
            return em.merge(dayMenu);
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
            return em.createNamedQuery(DayMenu.DELETE).setParameter("id", id).executeUpdate() != 0;
        }
    }

    @Override
    public List<DayMenu> getAll(int journeyId) {
        return em.createNamedQuery(DayMenu.GET_ALL, DayMenu.class).setParameter("journeyId", journeyId).getResultList();
    }

    @Override
    public DayMenu get(int id) {
        DayMenu dayMenu = em.find(DayMenu.class, id);
        return dayMenu;
    }
}
