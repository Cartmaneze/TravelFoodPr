package travelFood.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by Никита on 09.05.2017.
 */
@NamedQueries({
        @NamedQuery(name = MealWithWeight.DELETE, query = "DELETE FROM MealWithWeight m WHERE m.id=:id"),
        @NamedQuery(name = MealWithWeight.GET_ALL, query = "SELECT m FROM MealWithWeight m WHERE m.dayId=:dayId")
})
@Entity
@Table(name = "MEALS_WITH_WEIGHT")
public class MealWithWeight extends BaseEntity {
    public static final String DELETE = "MealWithWeight.delete";
    public static final String GET_ALL = "MealWithWeight.getAll";

    @Column(name = "weight")
    private int weight;

    @Column(name = "id_table")
    private int idTable;

//    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "day_Id")
    int dayId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meal_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Meal meal;

    public MealWithWeight() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    @Override
    public String toString() {
        return "MealWithWeight{" +
                "weight=" + weight +
                ", menuId=" + dayId +
                ", meal=" + meal +
                '}';
    }
}
