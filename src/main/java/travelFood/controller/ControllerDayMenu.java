package travelFood.controller;

import org.springframework.stereotype.Controller;
import travelFood.model.DayMenu;
import travelFood.service.ServiceDayMenu;

import java.util.List;

/**
 * Created by Никита on 17.05.2017.
 */
@Controller
public class ControllerDayMenu {

    ServiceDayMenu serviceDayMenu;

    public ControllerDayMenu(ServiceDayMenu serviceDayMenu) {
        this.serviceDayMenu = serviceDayMenu;
    }

    public List<DayMenu> getAll(int id) {
        return serviceDayMenu.getAll(id);
    }

    public DayMenu get(int id) {
        return serviceDayMenu.get(id);
    }

    public void delete(int id) {
        serviceDayMenu.delete(id);
    }

    public void saveOrUpdate(DayMenu dayMenu) {
        serviceDayMenu.saveOrUpdate(dayMenu);
    }
}
