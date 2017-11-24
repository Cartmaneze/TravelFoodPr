package travelFood.repository.jpa;

import org.springframework.stereotype.Repository;
import travelFood.model.JourneyMenu;
import travelFood.repository.JourneyMenuRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Никита on 14.05.2017.
 */

@Repository
public class JourneyMenuRepositoryImpl implements JourneyMenuRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public JourneyMenu saveOrUpdate(JourneyMenu journeyMenu) {
        if (journeyMenu.isNew()) {
            em.persist(journeyMenu);
            return journeyMenu;
        } else if (!journeyMenu.isNew() && get(journeyMenu.getId()) != null) {
            return em.merge(journeyMenu);
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        if (get(id) == null) {
            return false;
        } else {
            return em.createNamedQuery(JourneyMenu.DELETE).setParameter("id", id).executeUpdate() != 0;
        }
    }

    @Override
    public JourneyMenu get(int id) {
        JourneyMenu journeyMenu = em.find(JourneyMenu.class, id);
        return journeyMenu;
    }

    @Override
    public List<JourneyMenu> getAll() {
        return em.createNamedQuery(JourneyMenu.GET_ALL, JourneyMenu.class).getResultList();
    }
}
