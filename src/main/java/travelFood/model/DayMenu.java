package travelFood.model;

import javax.persistence.*;

/**
 * Created by Никита on 09.05.2017.
 */
@NamedQueries({
        @NamedQuery(name = DayMenu.DELETE, query = "DELETE FROM DayMenu d WHERE d.id=:id"),
        @NamedQuery(name = DayMenu.GET_ALL, query = "SELECT d FROM DayMenu d WHERE d.journeyId=:journeyId")
})
@Entity
@Table(name = "DAYS")
public class DayMenu extends BaseEntity {
    public static final String DELETE = "DayMenu.delete";
    public static final String GET_ALL = "DayMenu.getAll";

//    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "journey_id")
    int journeyId;

    @Column(name = "name")
    String name;

    public DayMenu() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(int journeyId) {
        this.journeyId = journeyId;
    }

    @Override
    public String toString() {
        return "DayMenu{" +
                "journeyId=" + journeyId +
                '}';
    }
}
