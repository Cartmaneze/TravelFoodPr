package travelFood.controller;

import org.springframework.stereotype.Controller;
import travelFood.model.JourneyMenu;
import travelFood.service.ServiceJourneyMenu;

import java.util.List;

/**
 * Created by Никита on 20.05.2017.
 */
@Controller
public class ControllerJourneyMenu {
    ServiceJourneyMenu serviceJourneyMenu;

    public ControllerJourneyMenu(ServiceJourneyMenu serviceJourneyMenu) {
        this.serviceJourneyMenu = serviceJourneyMenu;
    }

    public JourneyMenu get(int id) {
        return serviceJourneyMenu.get(id);
    }

    public List<JourneyMenu> getAll() {
        return serviceJourneyMenu.getAll();
    }

    public void delete(int id) {
        serviceJourneyMenu.delete(id);
    }

    public void saveOrUpdate(JourneyMenu journeyMenu) {
        serviceJourneyMenu.saveOrUpdate(journeyMenu);
    }
}
