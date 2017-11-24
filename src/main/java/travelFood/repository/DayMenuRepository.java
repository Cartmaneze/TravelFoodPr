package travelFood.repository;

import travelFood.model.DayMenu;

import java.util.List;

/**
 * Created by Никита on 14.05.2017.
 */
public interface DayMenuRepository {

    DayMenu saveOrUpdate(DayMenu dayMenu);

    boolean delete(int id);

    List<DayMenu> getAll(int journeyId);

    DayMenu get(int id);
}
