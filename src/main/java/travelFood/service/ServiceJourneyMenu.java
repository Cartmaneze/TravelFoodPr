package travelFood.service;

import org.springframework.stereotype.Service;
import travelFood.model.JourneyMenu;
import travelFood.repository.JourneyMenuRepository;

import java.util.List;

/**
 * Created by Никита on 20.05.2017.
 */
@Service
public class ServiceJourneyMenu {
    JourneyMenuRepository journeyMenuRepository;

    public ServiceJourneyMenu(JourneyMenuRepository journeyMenuRepository) {
        this.journeyMenuRepository = journeyMenuRepository;
    }

    public JourneyMenu get(int id) {
        return journeyMenuRepository.get(id);
    }

    public List<JourneyMenu> getAll() {
        return journeyMenuRepository.getAll();
    }

    public void saveOrUpdate(JourneyMenu journeyMenu) {
        if (journeyMenuRepository.saveOrUpdate(journeyMenu) == null) {
            System.out.println("not saved");
        } else {
            System.out.println("saved");
        }
    }

    public void delete(int id) {
        if (journeyMenuRepository.delete(id)) {
            System.out.println("delete");
        } else {
            System.out.println("not delete");
        }
    }
}
