package org.gutierrez.dice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Objects;
import java.util.Random;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class DiceController {
    @FXML
    private ImageView leftImage, rightImage, leftEasterEggImage, rightEasterEggImage;
    @FXML
    private Button leftButton, rightButton;
    @FXML
    private Label combinationLabel;

    // Generates Random object for numbers along with 2 int to store values.
    private final Random random = new Random();
    private int leftValue, rightValue;


    //Used lambda function (->) which uses the parameter "event" not having to use "onLeft(Right)ButtonClick" methods.
    //Used initialize method here to reset the GUI and not have the images or text preloaded.
    @FXML
    private void initialize() {
        leftButton.setOnAction(event -> rollDice(leftImage, true));
        rightButton.setOnAction(event -> rollDice(rightImage, false));
        combinationLabel.setText("");
    }

    private void rollDice(ImageView imageView, boolean isLeft) {
        int finalDiceValue = random.nextInt(6) + 1; // Generates random number between 1-6.
        Timeline rollAnimation = new Timeline(); // Created an object called "rollAnimation" from the Timeline class used for animations.

        // Uses Timeline to add a keyframe to change the image every 50 milliseconds.
        rollAnimation.getKeyFrames().add( new KeyFrame(Duration.millis(50), event -> {
            int randomValue = random.nextInt(6) + 1; // Generates random number between 1-6.

            // Sets the image to the randomValue by concatenating the string with the randomValue and getting the image from the resources.
            imageView.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/dice" + randomValue + ".png"))));
            })
        );
        rollAnimation.setCycleCount(20); // Cycles 20 times for 1 second.

        // Sets the final image after the animation is finished.
        rollAnimation.setOnFinished(event -> {
            imageView.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/dice" + finalDiceValue + ".png"))));
            if (isLeft) {
                leftValue = finalDiceValue;
            } else {
                rightValue = finalDiceValue;
            }
            checkEasterEgg(); // Checks for special combinations after the roll.
        });
        rollAnimation.play(); // Starts the animation.
    }

    // Checks for Easter egg combinations and sets the images and text accordingly.
    private void checkEasterEgg() {
        String specialCombination = getCombination(leftValue, rightValue);
        if (specialCombination != null) {
            Image easterEggImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + specialCombination + ".png")));
            // Sets the images and text if a combination is found.
            leftEasterEggImage.setImage(easterEggImage);
            rightEasterEggImage.setImage(easterEggImage);
            combinationLabel.setText(getCombinationText(specialCombination));
        } else {
            // Hides the images and text if no combination found.
            leftEasterEggImage.setImage(null);
            rightEasterEggImage.setImage(null);
            combinationLabel.setText("");
        }
    }

    // Checks for the Easter egg combinations and returns the combination.
    // The combination returns null if no combination found.
    private String getCombination(int leftValue, int rightValue) {
        if (leftValue == 1 && rightValue == 1) return "snake";
        if (leftValue == 2 && rightValue == 2) return "ballerina";
        if (leftValue == 6 && rightValue == 6) return "boxcar";
        if (leftValue == 4 && rightValue == 5) return "jessejames";
        return null;
    }

    // Returns the text for the combination which is Craps lingo.
    // If no combination found, returns an empty string as to continue to hide the label.
    private String getCombinationText(String combination) {
        return switch (combination) {
            case "snake" -> "Snake Eyes";
            case "ballerina" -> "Tu-Tu";
            case "boxcar" -> "Box car";
            case "jessejames" -> ".45 Cal";
            default -> "";
        };
    }
}