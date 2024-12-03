package com.example.blackjack;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class BlackJackController {

    // VARIABLES

    // Screen variables
    @FXML
    private AnchorPane howToPlayScreen; // "How to Play" Pane
    @FXML
    private AnchorPane placeBetScreen; // "Place Bet" Pane
    @FXML
    private AnchorPane gameScreen; // "Game" Pane

    // Tutorial variables
    @FXML
    private ScrollPane scrollPane; // To set the initial scrollbar value

    // Place Bet variables
    @FXML
    private Label youHaveText; // To show how much money the player has
    @FXML
    private Label youBetText; // To show how much money the player is betting

    private final int minimumBet = 10; // To set a minimum bet
    private int yourMoney = 200; // How much money the player has
    private int betMoney; // How much money the player is betting

    // Game variables
    @FXML
    private StackPane nextButton; // To have access to "Next" button
    @FXML
    private Text winOrLoseMessage; // A win or lose text

    // Variables to change player's Card Club
    @FXML
    private TextArea playerCardClub1;
    @FXML
    private TextArea playerCardClub2;
    @FXML
    private TextArea playerCardClub3;
    @FXML
    private TextArea playerCardClub4;
    @FXML
    private TextArea playerCardClub5;
    @FXML
    private TextArea playerCardClub6;
    @FXML
    private TextArea playerCardClub7;
    @FXML
    private TextArea playerCardClub8;

    // Variables to change player's Card Value
    @FXML
    private Text playerCardValue1;
    @FXML
    private Text playerCardValue2;
    @FXML
    private Text playerCardValue3;
    @FXML
    private Text playerCardValue4;
    @FXML
    private Text playerCardValue5;
    @FXML
    private Text playerCardValue6;
    @FXML
    private Text playerCardValue7;
    @FXML
    private Text playerCardValue8;

    // Variables to change dealer's Card Club
    @FXML
    private TextArea dealerCardClub1;
    @FXML
    private TextArea dealerCardClub2;
    @FXML
    private TextArea dealerCardClub3;
    @FXML
    private TextArea dealerCardClub4;
    @FXML
    private TextArea dealerCardClub5;
    @FXML
    private TextArea dealerCardClub6;
    @FXML
    private TextArea dealerCardClub7;
    @FXML
    private TextArea dealerCardClub8;

    // Variables to change dealer's Card Value
    @FXML
    private Text dealerCardValue1;
    @FXML
    private Text dealerCardValue2;
    @FXML
    private Text dealerCardValue3;
    @FXML
    private Text dealerCardValue4;
    @FXML
    private Text dealerCardValue5;
    @FXML
    private Text dealerCardValue6;
    @FXML
    private Text dealerCardValue7;
    @FXML
    private Text dealerCardValue8;

    // Clubs

    // Diamond Club
    String diamondClub =
                            "                         \n" +
                            "                         \n" +
                            "           :%%+          \n" +
                            "          *%%%%%         \n" +
                            "        -%%%%%%%%+       \n" +
                            "       #%%%%%%%%%%#      \n" +
                            "     :%%%%%%%%%%%%%%-    \n" +
                            "     .%%%%%%%%%%%%%%.    \n" +
                            "       +%%%%%%%%%%*      \n" +
                            "        .%%%%%%%%:       \n" +
                            "          =%%%%+         \n" +
                            "            ##           \n";

    // Clover Club
    String cloverClub =
                            "                          \n" +
                            "                          \n" +
                            "         .*%%%%%*         \n" +
                            "        *%%%%%%%%%        \n" +
                            "        *%%%%%%%%%        \n" +
                            "         #%%%%%%%-        \n" +
                            "    #%%%%%%%%%%%%%%%%%+   \n" +
                            "   %%%%%%%%%%%%%%%%%%%%%  \n" +
                            "  +%%%%%%%%%%%%%%%%%%%%%  \n" +
                            "    =#%%%%+ *% =#%%%%*    \n" +
                            "            %%-           \n" +
                            "           *%%#           \n";

    // Heart Club
    String heartClub =
                            "                          \n" +
                            "                          \n" +
                            "      -*%%=.   .=%%*-     \n" +
                            "    *%%%%%%%**%%%%%%%*    \n" +
                            "   :%%%%%%%%%%%%%%%%%%+   \n" +
                            "   -%%%%%%%%%%%%%%%%%%*   \n" +
                            "    :%%%%%%%%%%%%%%%%=    \n" +
                            "      %%%%%%%%%%%%%%.     \n" +
                            "       #%%%%%%%%%%#       \n" +
                            "        :%%%%%%%%-        \n" +
                            "          +%%%%+          \n" +
                            "            **            \n";

    // Spade Club
    String spadeClub =
                            "                          \n" +
                            "                          \n"+
                            "            *#:           \n" +
                            "         .%%%%%%+         \n" +
                            "       :#%%%%%%%%%+       \n" +
                            "      *%%%%%%%%%%%%%:     \n" +
                            "    -%%%%%%%%%%%%%%%%+    \n" +
                            "   -%%%%%%%%%%%%%%%%%%+   \n" +
                            "    #%%%%%%%%%%%%%%%%%.   \n" +
                            "     =#%%%* #% *%%%%*     \n" +
                            "            %%.           \n" +
                            "           *%%#           \n";



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

    // Create cards clubs
    void cardClub(TextArea card, String cardClub){
        card.setText(cardClub);
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

    // When "Hit" button is pressed
    @FXML
    void onHit(MouseEvent event) {

    }

    // When "Stand" button is pressed
    @FXML
    void onStand(MouseEvent event) {

    }

    // When "Next" button is pressed
    @FXML
    void onNext(MouseEvent event) {

    }

}
