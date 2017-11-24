package travelFood.repository;

import travelFood.model.JourneyMenu;

import java.util.List;

/**
 * Created by Никита on 14.05.2017.
 */
public interface JourneyMenuRepository {

    JourneyMenu saveOrUpdate(JourneyMenu journeyMenu);

    boolean delete(int id);

    JourneyMenu get(int id);

    List<JourneyMenu> getAll();
}
