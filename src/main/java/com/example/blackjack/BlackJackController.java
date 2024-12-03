package com.example.blackjack;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class BlackJackController {

    // VARIABLES

    // Screen variables
    @FXML
    private AnchorPane howToPlayScreen; // "How to Play" Pane
    @FXML
    private AnchorPane gameScreen; // "Game" Pane
    @FXML
    private AnchorPane placeBetScreen; // "Place Bet" Pane

    // Tutorial variables
    @FXML
    private ScrollPane scrollPane; // To set the initial scrollbar value

    // Place Bet variables
    @FXML
    private Label youHaveText; // To show how much money the user has
    @FXML
    private Label youBetText; // To show how much money the user is betting

    private int minimumBet = 10; // To set a minimum bet
    private int yourMoney = 200; // How much money the user has
    private int betMoney; // How much money the user is betting


    // METHODS

    // Switch to "Home" Screen
    @FXML
    void turnOffTutorial(MouseEvent event) {
        howToPlayScreen.setVisible(false);
    }

    // Switch to "How To Play" Screen
    @FXML
    void goHowToPlayScreen(MouseEvent event) {
        scrollPane.setVvalue(0);
        howToPlayScreen.setVisible(true);
    }

    // Switch to "Game" Screen
    @FXML
    void goPlayGameScreen(MouseEvent event) {
        gameScreen.setVisible(true);
        placeBetScreen.setVisible(true);
        betMoney = minimumBet;
        yourMoney -= 10;
        updateQuantities();
    }

    // Update "Your Money" and "Your bet" texts
    void updateQuantities() {
        youHaveText.setText("You have: " + yourMoney);
        youBetText.setText("Your bet: " + betMoney);
    }

    // Place Bet
    @FXML
    void placeBet(MouseEvent event) {
        placeBetScreen.setVisible(false);
    }

    // Add 10 to the bet
    @FXML
    void plusButton10(MouseEvent event) {
        if (yourMoney >= 10) {
            betMoney += 10;
            yourMoney -= 10;
            updateQuantities();
        }
    }

    // Subtract 10 from the bet
    @FXML
    void minusButton10(MouseEvent event) {
        if (betMoney - 10 >= minimumBet) {
            betMoney -= 10;
            yourMoney += 10;
            updateQuantities();
        }
    }

    // Add 20 to the bet
    @FXML
    void plusButton20(MouseEvent event) {
        if (yourMoney >= 20) {
            betMoney += 20;
            yourMoney -= 20;
            updateQuantities();
        }
    }

    // Subtract 20 from the bet
    @FXML
    void minusButton20(MouseEvent event) {
        if (betMoney - 20 >= minimumBet) {
            betMoney -= 20;
            yourMoney += 20;
            updateQuantities();
        }
    }

    // Add 50 to the bet
    @FXML
    void plusButton50(MouseEvent event) {
        if (yourMoney >= 50) {
            betMoney += 50;
            yourMoney -= 50;
            updateQuantities();
        }
    }

    // Subtract 50 from the bet
    @FXML
    void minusButton50(MouseEvent event) {
        if (betMoney - 50 >= minimumBet) {
            betMoney -= 50;
            yourMoney += 50;
            updateQuantities();
        }
    }

    // Add 200 to the bet
    @FXML
    void plusButton200(MouseEvent event) {
        if (yourMoney >= 200) {
            betMoney += 200;
            yourMoney -= 200;
            updateQuantities();
        }
    }

    // Subtract 200 from the bet
    @FXML
    void minusButton200(MouseEvent event) {
        if (betMoney - 200 >= minimumBet) {
            betMoney -= 200;
            yourMoney += 200;
            updateQuantities();
        }
    }

}
