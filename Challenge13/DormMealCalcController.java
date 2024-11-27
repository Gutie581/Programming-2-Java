package org.gutierrez.dormmealcalc;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.util.HashMap;

public class DormMealCalcController {
    @FXML
    private ComboBox<String> dormComboBox, mealComboBox;
    @FXML
    private Label totalCostLabel;

    // Creates 2 hashmaps to store the prices of the dorms and meal plans.
    HashMap<String, Integer > dormPrices = new HashMap<>();
    HashMap<String, Integer > mealPrices = new HashMap<>();

    public void initialize() {
        totalCostLabel.setText("");   // Clears the total cost label.
        // Creates 2 hashmaps to store the prices of the dorms and meal plans.
        dormPrices.put("Allen Hall", 1800);
        dormPrices.put("Pike Hall", 2200);
        dormPrices.put("Farthing Hall", 2800);
        dormPrices.put("University Suites", 3000);

        mealPrices.put("7 meals per week", 600);
        mealPrices.put("14 meals per week", 1100);
        mealPrices.put("Unlimited meals", 1800);

        // Adds the dorms and meal plans to the combo boxes.
        dormComboBox.getItems().addAll(dormPrices.keySet());
        mealComboBox.getItems().addAll(mealPrices.keySet());

        // Adds a listener to the combo boxes to calculate the total cost when a dorm or meal plan is selected.
        // The listener uses a lambda expression that calls the calculateTotal method and uses the underscores as placeholders.
        dormComboBox.getSelectionModel().selectedItemProperty().addListener((_, _, _) -> calculateTotal());
        mealComboBox.getSelectionModel().selectedItemProperty().addListener((_, _, _) -> calculateTotal());
    }

    private void calculateTotal() {
        // Gets the value from selected dorm and meal plan.
        String selectedDorm = dormComboBox.getValue();
        String selectedMeal = mealComboBox.getValue();

        // If both a dorm and meal plan are selected, calculates the total cost.
        if (selectedDorm != null && selectedMeal != null) {
            int dormPrice = dormPrices.get(selectedDorm); // Retrieves the price of the selected dorm.
            int mealPlanPrice = mealPrices.get(selectedMeal); // Retrieves the price of the selected meal plan.
            int totalPrice = dormPrice + mealPlanPrice; // Calculates the total price.
            totalCostLabel.setText(String.format("$%,d", totalPrice)); // Updates the total cost label with proper number formatting.
        }
    }

}
