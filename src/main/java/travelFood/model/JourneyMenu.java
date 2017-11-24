package travelFood.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Created by Никита on 09.05.2017.
 */
@NamedQueries({
        @NamedQuery(name = JourneyMenu.DELETE, query = "DELETE FROM JourneyMenu j WHERE j.id=:id"),
        @NamedQuery(name = JourneyMenu.GET_ALL, query = "SELECT d FROM JourneyMenu d")
})
@Entity
@Table(name = "JOURNEY")
public class JourneyMenu extends BaseEntity {
    public static final String DELETE = "JourneyMenu.delete";
    public static final String GET_ALL = "JourneyMenu.getAll";

    String name;

    public JourneyMenu() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JourneyMenu{" +
                "name='" + name + '\'' +
                '}';
    }
}
