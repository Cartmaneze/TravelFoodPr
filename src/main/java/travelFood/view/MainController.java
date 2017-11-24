package travelFood.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import travelFood.controller.ControllerDayMenu;
import travelFood.controller.ControllerJourneyMenu;
import travelFood.controller.ControllerMeal;
import travelFood.controller.ControllerMealWithWeight;
import travelFood.model.DayMenu;
import travelFood.model.JourneyMenu;
import travelFood.model.Meal;
import travelFood.model.MealWithWeight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Никита on 25.05.2017.
 */
public class MainController {

    public ControllerJourneyMenu journeyMenu = BeanController.getJourneyMenu();
    public ControllerDayMenu dayMenu = BeanController.getDayMenu();
    public ControllerMealWithWeight mealWithWeight = BeanController.getMealWithWeight();
    public ControllerMeal meal = BeanController.getMeal();

    private JourneyMenu chosenJourney;
    private DayMenu chosenDay;
    private Meal chosenMeal;

    private int peopleCount = 1;

    private List<MealWithWeight> copyMealList = new ArrayList<>();

    @FXML
    private Button button0 = new Button();
    @FXML
    private Button button1 = new Button();
    @FXML
    private Button button2 = new Button();
    @FXML
    private Button button3 = new Button();
    @FXML
    private Button button4 = new Button();
    @FXML
    private Button button5 = new Button();
    @FXML
    private Button button6 = new Button();
    @FXML
    private Button button7 = new Button();
    @FXML
    private Button button8 = new Button();
    @FXML
    private Button button9 = new Button();
    @FXML
    private Button button10 = new Button();
    @FXML
    private Button button11 = new Button();
    @FXML
    private Button button12 = new Button();
    @FXML
    private Button button13 = new Button();
    @FXML
    private Button button14 = new Button();
    @FXML
    private Button button15 = new Button();
    @FXML
    private Button button16 = new Button();
    @FXML
    private Button button17 = new Button();
    @FXML
    private Button button18 = new Button();
    @FXML
    private Button button19 = new Button();
    @FXML
    private Button button20 = new Button();
    @FXML
    private Button button21 = new Button();
    @FXML
    private Button button22 = new Button();
    @FXML
    private Button button23 = new Button();

    private List<Button> buttonList = new ArrayList<>();

    Stage stageViewMealWindow = new Stage();

    Stage stageCreateMealWindow = new Stage();

    Stage stageAddMealWindow = new Stage();

    @FXML
    private TableView<Meal> tableMealAddMealWindow = new TableView();

    @FXML
    private TableColumn<Meal, String> mealNameAddMealWindow = new TableColumn<>();

    @FXML
    private TableColumn<Meal, Integer> mealCcalAddMealWindow = new TableColumn<>();

    @FXML
    private TableView<DayMenu> dayTable = new TableView<>();

    @FXML
    private TableView<Meal> tableMeals = new TableView();

    @FXML
    private TableColumn<Meal, String> colMealName = new TableColumn<>();

    @FXML
    private TableColumn<Meal, Integer> colMealCcal = new TableColumn<>();

    @FXML
    private Button buttonDeleteMeal = new Button();

  //  @FXML
  //  private Button buttonUpdateMeal = new Button();

    @FXML
    private Button buttonNewMeal = new Button();

    @FXML
    private TextField fieldNewMealName = new TextField();

    @FXML
    private TextField fieldNewMealCcal = new TextField();

    @FXML
    private Button saveNewMealButton = new Button();

    @FXML
    private TableColumn<DayMenu, String> dayNameColumn = new TableColumn<>();

    @FXML
    private TableView<MealWithWeight> mealOfDayTable = new TableView<>();

    @FXML
    private TableColumn<MealWithWeight, String> nameMealOfDayColumn = new TableColumn<>();

    @FXML
    private TableColumn<MealWithWeight, String> weightMealOfDayColumn = new TableColumn<>();

    @FXML
    private TableColumn<MealWithWeight, String> ccalMealOfDayColumn = new TableColumn<>();

    @FXML
    private TableColumn<MealWithWeight, Integer> belkyMealOfDayColumn = new TableColumn<>();

    @FXML
    private TableColumn<MealWithWeight, Integer> zhiryMealOfDayColumn = new TableColumn<>();

    @FXML
    private TableColumn<MealWithWeight, Integer> uglevodyMealOfDayColumn = new TableColumn<>();

    @FXML
    private TextField labelPeopleCount = new TextField();

    @FXML
    private Label labelWeightOfDay = new Label();

    @FXML
    private Label labelCcalOfDay = new Label();

    @FXML
    private Label labelInfoRightClick = new Label();

    @FXML
    public void openTravelsWindow() {
        try {
            Stage stage = new Stage();

            TableView<JourneyMenu> table = new TableView<JourneyMenu>();

            TableColumn<JourneyMenu, String> userNameCol = new TableColumn<JourneyMenu, String>("Name");

            userNameCol.setCellValueFactory(new PropertyValueFactory<JourneyMenu, String>("name"));
            table.setItems(getJourneys());
            table.getColumns().addAll(userNameCol);

            table.setRowFactory( tv -> {
                TableRow<JourneyMenu> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                        chosenJourney = row.getItem();
                        stage.close();
                        setDayTable(chosenJourney);
                    }
                });
                return row ;
            });

            StackPane root = new StackPane();
            root.setPadding(new Insets(5));
            root.getChildren().add(table);

            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("cant load window");
        }
    }

    @FXML
    public void openMealsWindow(int rowNumber) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/addMeal.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            stageAddMealWindow.setTitle("Добавить еду");
            stageAddMealWindow.setScene(new Scene(root1));

            tableMealAddMealWindow = (TableView<Meal>) root1.lookup("#tableMealAddMealWindow");
            tableMealAddMealWindow.setItems(getMeals());

            mealNameAddMealWindow =(TableColumn<Meal, String>) tableMealAddMealWindow.getColumns().get(0);
            mealNameAddMealWindow.setCellValueFactory(new PropertyValueFactory<>("name"));

            mealCcalAddMealWindow =(TableColumn<Meal, Integer>) tableMealAddMealWindow.getColumns().get(1);
            mealCcalAddMealWindow.setCellValueFactory(new PropertyValueFactory<>("calories"));

            tableMealAddMealWindow.setRowFactory(tv -> {
                TableRow<Meal> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && (!row.isEmpty())) {
                        MealWithWeight newMealWithWeight = new MealWithWeight();
                        newMealWithWeight.setMeal(row.getItem());
                        newMealWithWeight.setIdTable(rowNumber);
                        newMealWithWeight.setWeight(100);
                        newMealWithWeight.setDayId(chosenDay.getId());
                        mealWithWeight.saveOrUpdate(newMealWithWeight);
                        stageAddMealWindow.close();
                        setMealOfDayTable(chosenDay);
                    }
                });
                return row;
            });

            stageAddMealWindow.show();
        } catch (Exception e) {
            System.out.println("cant load window");
        }
    }

    @FXML
    public void openCountWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/countWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));

            TextArea textArea = (TextArea) root1.lookup("#textAreaCountWindow");
            textArea.setText(collectJourneyMeal());

            stage.show();

        } catch (Exception e) {
            System.out.println("cant load window");
        }
    }

    @FXML
    public void openViewMealWindow() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/meals.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            stageViewMealWindow.setTitle("Окно еды");
            stageViewMealWindow.setScene(new Scene(root1));

            tableMeals = (TableView<Meal>) root1.lookup("#tableMeals");
            tableMeals.setItems(getMeals());

            colMealName =(TableColumn<Meal, String>) tableMeals.getColumns().get(0);
            colMealName.setCellValueFactory(new PropertyValueFactory<>("name"));

            colMealCcal =(TableColumn<Meal, Integer>) tableMeals.getColumns().get(1);
            colMealCcal.setCellValueFactory(new PropertyValueFactory<>("calories"));

            buttonDeleteMeal = (Button) root1.lookup("buttonDeleteMeal");

            buttonNewMeal = (Button) root1.lookup("buttonNewMeal");

            stageViewMealWindow.show();
        } catch (Exception e) {
            System.out.println("cant load window");
        }
    }

    @FXML
    public void openCreateMealWindow() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/saveUpdateMeal.fxml"));
            Parent root = (Parent) fxmlLoader.load();

            stageCreateMealWindow.setTitle("Создание еды");
            stageCreateMealWindow.setScene(new Scene(root));

            fieldNewMealName = (TextField) root.lookup("fieldNewMealName");
            fieldNewMealCcal = (TextField) root.lookup("fieldNewMealCcal");
            saveNewMealButton = (Button) root.lookup("saveNewMealButton");

            stageCreateMealWindow.show();
        } catch (Exception e) {
            System.out.println("cant load window");
        }

    }

    @FXML
    public void changeMealWeightWindow(MealWithWeight mealWithWeightEnt) {
        try {
            Stage stage = new Stage();

            TextField mealNewWeight = new TextField();

            StackPane root = new StackPane();
            root.setPadding(new Insets(5));
            root.getChildren().add(mealNewWeight);

            stage.setScene(new Scene(root));
            stage.show();

            mealNewWeight.setText(String.valueOf(mealWithWeightEnt.getWeight()));

            mealNewWeight.setOnAction(event -> {
                MealWithWeight newMealWithWeight = new MealWithWeight();
                newMealWithWeight.setMeal(mealWithWeightEnt.getMeal());
                newMealWithWeight.setIdTable(mealWithWeightEnt.getIdTable());
                newMealWithWeight.setWeight(Integer.parseInt(mealNewWeight.getText()));
                newMealWithWeight.setDayId(chosenDay.getId());
                mealWithWeight.delete(mealWithWeightEnt.getId());
                mealWithWeight.saveOrUpdate(newMealWithWeight);
                stage.close();
                setMealOfDayTable(chosenDay);
            });

        } catch (Exception e) {
            System.out.println("cant load window");
        }
    }

    public String collectJourneyMeal() {
        String text = "";
        String allFood = "";

        HashMap<String, Integer> mealsWeight = new HashMap<>();
        int allWeight = 0;

        for (DayMenu dayMenus : dayMenu.getAll(chosenJourney.getId())) {
            allFood += "\n/////////////DAY/////////////\n";
            for (MealWithWeight m : mealWithWeight.getAll(dayMenus.getId())) {
                if (!m.getMeal().getName().isEmpty()) {
                    allFood += m.getMeal().getName() + "  " + m.getWeight() + " грамм  " + m.getMeal().getCalories() + " каллорий\n";
                }

                if (mealsWeight.isEmpty()) {
                    mealsWeight.put(m.getMeal().getName(), m.getWeight());
                } else if (mealsWeight.containsKey(m.getMeal().getName())) {
                    mealsWeight.put(m.getMeal().getName(), m.getWeight() + mealsWeight.get(m.getMeal().getName()));
                } else {
                    mealsWeight.put(m.getMeal().getName(), m.getWeight());
                }
            }
            mealsWeight.remove("");
        }

        for (Map.Entry<String, Integer> entry : mealsWeight.entrySet()) {
            text += entry.getKey() + "  " + entry.getValue()*peopleCount + " грамм" + "\n";
            allWeight += entry.getValue()*peopleCount;
        }
        text += "\n";
        text += "общий вес  " + allWeight + " грамм";
        text += "\n";
        text += allFood;

        return text;
    }

    public void rightClickMouseMealWeightWindow(Event event) {
        labelInfoRightClick.setText("Для редактирования веса"+ "\n" + "жми правую кнопку мышы");
        if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
            if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY)) {
                changeWeightOfMeal();
            }
        }
    }

    @FXML
    public void clickMouseMealWindow(Event event) {
        if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
            chosenMeal = tableMeals.getSelectionModel().getSelectedItem();
        }
    }

    public void saveNewMeal() {
        Meal newMeal = new Meal();
        newMeal.setName(fieldNewMealName.getText());
        newMeal.setCalories(Integer.parseInt(fieldNewMealCcal.getText()));
        meal.saveOrUpdate(newMeal);
    }

    @FXML
    public void handleSaveMealButtonAction(ActionEvent event) throws IOException {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        saveNewMeal();
        stageViewMealWindow.close();
        stageViewMealWindow = null;
    }

    public void deleteMeal() throws IOException {
        meal.delete(chosenMeal.getId());
        openViewMealWindow();
    }

    @FXML
    public void handleDeleteMealButtonAction(ActionEvent event) throws IOException {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        deleteMeal();
    }

    public void clickOnPane() {
        labelInfoRightClick.setText("");
    }

    public void changePeopleCount() {
        peopleCount = Integer.parseInt(labelPeopleCount.getText());
    }

    public void deleteMealWithWeight(int tableRow) {
        for (MealWithWeight m : mealWithWeight.getAll(chosenDay.getId())) {
            if (m.getIdTable() == tableRow) {
                mealWithWeight.delete(m.getId());
            }
        }
        setMealOfDayTable(chosenDay);
    }

    @FXML
    public void copyMealList() {
        copyMealList = mealWithWeight.getAll(chosenDay.getId());
    }

    @FXML
    public void pasteMealList() {
        List<Integer> idToDelete = new ArrayList<>();
        for (MealWithWeight m : mealWithWeight.getAll(chosenDay.getId())) {
            if (m.getId() != null) {
                idToDelete.add(m.getId());
            }
        }
        for (int i : idToDelete) {
            mealWithWeight.delete(i);
        }
        for (MealWithWeight m : copyMealList) {
            if (m.getId() != null) {
                MealWithWeight copy = new MealWithWeight();
                copy.setIdTable(m.getIdTable());
                copy.setDayId(chosenDay.getId());
                copy.setWeight(m.getWeight());
                copy.setMeal(m.getMeal());
                mealWithWeight.saveOrUpdate(copy);
            }
        }
    }

    @FXML
    public void changeWeightOfMeal() {
        MealWithWeight mealWithWeightEnt = mealOfDayTable.getSelectionModel().getSelectedItem();
        if (!mealWithWeightEnt.getMeal().getName().isEmpty()) {
            changeMealWeightWindow(mealWithWeightEnt);
        }
    }

    @FXML
    public void getMealsWithWeight() {
        chosenDay = dayTable.getSelectionModel().getSelectedItem();
        if (chosenDay != null) {
            setMealOfDayTable(chosenDay);
        }
    }

    public void setDayTable(JourneyMenu journey) {
        dayTable.setItems(getDays(journey.getId()));
        dayNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    public void setMealOfDayTable(DayMenu day) {
        List mealsOfDay = getMealsOfDay(day.getId());

        mealOfDayTable.setItems(getMealsOfDay(day.getId()));

        setInfoDayCounter(mealsOfDay);

        nameMealOfDayColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MealWithWeight, String>, ObservableValue<String>>() {
                                                    @Override
                                                    public ObservableValue<String> call(TableColumn.CellDataFeatures<MealWithWeight, String> param) {
                                                        Meal meal = param.getValue().getMeal();
                                                        if (meal != null) {
                                                            return new SimpleStringProperty(meal.getName());
                                                        }
                                                        return null;
                                                    }
                                                }
        );

        weightMealOfDayColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MealWithWeight, String>, ObservableValue<String>>() {
                                                      @Override
                                                      public ObservableValue<String> call(TableColumn.CellDataFeatures<MealWithWeight, String> param) {
                                                          Meal meal = param.getValue().getMeal();
                                                          if (meal != null && !meal.getName().isEmpty()) {
                                                              return new SimpleStringProperty(String.valueOf(param.getValue().getWeight()));
                                                          }
                                                          return null;
                                                      }
                                                  }
        );


        ccalMealOfDayColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MealWithWeight, String>, ObservableValue<String>>() {
                                                    @Override
                                                    public ObservableValue<String> call(TableColumn.CellDataFeatures<MealWithWeight, String> param) {
                                                        Meal meal = param.getValue().getMeal();
                                                        if (meal != null && !meal.getName().isEmpty()) {
                                                            return new SimpleStringProperty(String.valueOf(meal.getCalories()*param.getValue().getWeight()/100));
                                                        }
                                                        return null;
                                                    }
                                                }
        );
        setButtonColor(mealsOfDay);
    }

    public void addNewDay() {
        DayMenu newDayMenu = new DayMenu();
        newDayMenu.setJourneyId(chosenJourney.getId());
        newDayMenu.setName("|||||||||||||||||||||||-DAY-||||||||||||||||||||||");
        dayMenu.saveOrUpdate(newDayMenu);
        setDayTable(chosenJourney);
    }

    public void deleteDay() {
        dayMenu.delete(chosenDay.getId());
        chosenDay = null;
        setDayTable(chosenJourney);
    }

    public void setInfoDayCounter(List<MealWithWeight> mealsOfDay) {
        int weight = 0;
        int ccal = 0;

        for (MealWithWeight m : mealsOfDay) {
            weight += m.getWeight();
        }

        for (MealWithWeight m : mealsOfDay) {
            ccal += m.getMeal().getCalories()*m.getWeight()/100;
        }

        labelWeightOfDay.setText(String.valueOf(weight));
        labelCcalOfDay.setText(String.valueOf(ccal));
    }

    public ObservableList<JourneyMenu> getJourneys() {
        ObservableList<JourneyMenu> journeyMenus = FXCollections.observableList(journeyMenu.getAll());
        return journeyMenus;
    }

    public ObservableList<DayMenu> getDays(int id) {
        ObservableList<DayMenu> days = FXCollections.observableList(dayMenu.getAll(id));
        return days;
    }

    public ObservableList<MealWithWeight> getMealsOfDay(int id) {
        ObservableList<MealWithWeight> mealWithWeights =
                FXCollections.observableList(mealWithWeight.getAll(id));
        return mealWithWeights;
    }

    public ObservableList<Meal> getMeals() {
        ObservableList<Meal> meals =
                FXCollections.observableList(meal.getAll());
        return meals;
    }

    public void setButtonColor(List<MealWithWeight> listOfMeals) {
        if (buttonList.isEmpty()) {
            buttonList.add(button0);
            buttonList.add(button1);
            buttonList.add(button2);
            buttonList.add(button3);
            buttonList.add(button4);
            buttonList.add(button5);
            buttonList.add(button6);
            buttonList.add(button7);
            buttonList.add(button8);
            buttonList.add(button9);
            buttonList.add(button10);
            buttonList.add(button11);
            buttonList.add(button12);
            buttonList.add(button13);
            buttonList.add(button14);
            buttonList.add(button15);
            buttonList.add(button16);
            buttonList.add(button17);
            buttonList.add(button18);
            buttonList.add(button19);
            buttonList.add(button20);
            buttonList.add(button21);
            buttonList.add(button22);
            buttonList.add(button23);
        }
        for (int i = 0; i < listOfMeals.size(); i++) {
            if (listOfMeals.get(i).getMeal().getName().isEmpty()) {
                int tableRow = i;
                Button button = buttonList.get(i);
                button.setStyle("-fx-background-color: green;");
                button.setOnAction(event -> {
                    openMealsWindow(tableRow);
                });
            } else {
                int tableRow = i;
                Button button = buttonList.get(i);
                button.setStyle("-fx-background-color: brown;");
                button.setOnAction(event -> {
                    deleteMealWithWeight(tableRow);
                });
            }
        }
    }
}
