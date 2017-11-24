package travelFood.service;

import org.springframework.stereotype.Service;
import travelFood.model.DayMenu;
import travelFood.repository.DayMenuRepository;

import java.util.List;

/**
 * Created by Никита on 20.05.2017.
 */
@Service
public class ServiceDayMenu {
    DayMenuRepository dayMenuRepository;

    ServiceDayMenu(DayMenuRepository dayMenuRepository) {
        this.dayMenuRepository = dayMenuRepository;
    }

    public List<DayMenu> getAll(int id) {
        return dayMenuRepository.getAll(id);
    }

    public DayMenu get(int id) {
        return dayMenuRepository.get(id);
    }

    public void saveOrUpdate(DayMenu dayMenu) {
        if (dayMenuRepository.saveOrUpdate(dayMenu) == null) {
            System.out.println("not saved");
        } else {
            System.out.println("saved");
        }
    }

    public void delete(int id) {
        if (dayMenuRepository.delete(id)) {
            System.out.println("delete");
        } else {
            System.out.println("not delete");
        }
    }
}
