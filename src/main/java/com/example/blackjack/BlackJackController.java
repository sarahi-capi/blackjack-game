package com.example.blackjack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;

public class BlackJackController {

    // VARIABLES

    // Screen variables
    @FXML
    private AnchorPane homeScreen; // "Home" Pane
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
    private HBox hitStandButtons; // Hit and Stand buttons
    @FXML
    private Button nextButton; // To have access to "Next" button
    @FXML
    private Text winOrLoseMessage; // A win or lose text
    @FXML
    private Button scoreDealerDisplay; // Dealer score
    @FXML
    private Button scorePlayerDisplay; // Player score

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

    // Array to store the player's cards club that are on the table
    private ArrayList<TextArea> playerTableCardClub = new ArrayList<>();

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

    // Array to store the player's cards value that are on the table
    private ArrayList<Text> playerTableCardValue = new ArrayList<>();

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

    // Array to store the dealer's cards club that are on the table
    private ArrayList<TextArea> dealerTableCardClub = new ArrayList<>();

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

    // Array to store the dealer's cards value that are on the table
    private ArrayList<Text> dealerTableCardValue = new ArrayList<>();

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

    private final String[] clubArray = {"diamondClub", "spadeClub", "heartClub", "cloverClub"}; // Array with clubs
    private final String[] specialValues = {"J", "Q", "K", "A"}; // Array with the special values of the cards

    // ArrayLists for player and dealer's deck
    private ArrayList<Card> playerDeck = new ArrayList<>();
    private ArrayList<Card> dealerDeck = new ArrayList<>();

    private int playingCardCounter = 0; // Counter to keep track of the cards being played
    private ArrayList<Card> newDeck = newCardArray(); // Shuffled deck

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
        fillArrayList();
        gameScreen.setVisible(true);
        placeBetScreen.setVisible(true);
        nextButton.setVisible(false);
        betMoney = minimumBet;
        yourMoney -= 10;
        updateQuantities();
    }

    // Initialize variables
    void fillArrayList() {
        playerTableCardClub.clear();
        playerTableCardValue.clear();
        dealerTableCardClub.clear();
        dealerTableCardValue.clear();

        playerTableCardClub.add(playerCardClub1);
        playerTableCardClub.add(playerCardClub2);
        playerTableCardClub.add(playerCardClub3);
        playerTableCardClub.add(playerCardClub4);
        playerTableCardClub.add(playerCardClub5);
        playerTableCardClub.add(playerCardClub6);
        playerTableCardClub.add(playerCardClub7);
        playerTableCardClub.add(playerCardClub8);

        playerTableCardValue.add(playerCardValue1);
        playerTableCardValue.add(playerCardValue2);
        playerTableCardValue.add(playerCardValue3);
        playerTableCardValue.add(playerCardValue4);
        playerTableCardValue.add(playerCardValue5);
        playerTableCardValue.add(playerCardValue6);
        playerTableCardValue.add(playerCardValue7);
        playerTableCardValue.add(playerCardValue8);

        dealerTableCardClub.add(dealerCardClub1);
        dealerTableCardClub.add(dealerCardClub2);
        dealerTableCardClub.add(dealerCardClub3);
        dealerTableCardClub.add(dealerCardClub4);
        dealerTableCardClub.add(dealerCardClub5);
        dealerTableCardClub.add(dealerCardClub6);
        dealerTableCardClub.add(dealerCardClub7);
        dealerTableCardClub.add(dealerCardClub8);

        dealerTableCardValue.add(dealerCardValue1);
        dealerTableCardValue.add(dealerCardValue2);
        dealerTableCardValue.add(dealerCardValue3);
        dealerTableCardValue.add(dealerCardValue4);
        dealerTableCardValue.add(dealerCardValue5);
        dealerTableCardValue.add(dealerCardValue6);
        dealerTableCardValue.add(dealerCardValue7);
        dealerTableCardValue.add(dealerCardValue8);

    }

    // Update "Your Money" and "Your bet" texts
    void updateQuantities() {
        youHaveText.setText("You have: " + yourMoney);
        youBetText.setText("Your bet: " + betMoney);
    }

    // Clean game Table
    void cleanTable() {
        // For the player's cards
        for (TextArea playerClub : playerTableCardClub) {
            playerClub.setEditable(true);
            playerClub.setText("");
            playerClub.setEditable(false);
        }

        for (Text playerValue : playerTableCardValue) {
            playerValue.setText("");
        }

        // For the dealer's cards
        for (TextArea dealerClub : dealerTableCardClub) {
            dealerClub.setEditable(true);
            dealerClub.setText("");
            dealerClub.setEditable(false);
        }

        for (Text dealerValue : dealerTableCardValue) {
            dealerValue.setText("");
        }
    }

    // Create club images
    private String clubToImage(String club) {

        if (club.equals("diamondClub")) {
            return diamondClub;
        } else if (club.equals("cloverClub")) {
            return cloverClub;
        } else if (club.equals("heartClub")) {
            return heartClub;
        } else if (club.equals("spadeClub")) {
            return spadeClub;
        } else {
            return "";
        }

    }

    // Add the cards to the table
    void printToTable(Card card, Text value, TextArea club) {
        club.setText(clubToImage(card.getClub()));
        value.setText(String.valueOf(card.getValue()));
    }

    // Reset the array and shuffle it
    private ArrayList<Card> newCardArray() {
        ArrayList<Card> cardArray = new ArrayList<>();

        // Array of cards' values
        for (String club : clubArray) {
            for (int i = 2; i < 10; i++){
                cardArray.add(new Card(String.valueOf(i), club));
            }
        }

        // Array of special cards' values
        for(String club : clubArray) {
            for(String value : specialValues) {
                cardArray.add(new Card(value, club));
            }
        }

        // Shuffle the array
        Collections.shuffle(cardArray);
        return cardArray;
    }

    // Get Score from cards
    int getScore(ArrayList<Card> cardArray) {
        ArrayList<Card> auxCardArray = new ArrayList<>(cardArray); // To not delete values from the input card array
        int score = 0;

        // Counting everything but Aces
        for (Card card : cardArray) {

            if (!card.getValue().equals("A")) {

                if (card.getValue().equals("J") || card.getValue().equals("Q") || card.getValue().equals("K")) {

                    score += 10;
                    auxCardArray.remove(card);

                } else {

                    score += Integer.parseInt(card.getValue());
                    auxCardArray.remove(card);

                }
            }

        }

        // Now we only have to deal with Aces, choose whether its value 1 or 11
        for (int i = 0; i < auxCardArray.size(); i++) {

            if (score + 11 + auxCardArray.size() - (i + 1) > 21) { // To see if we can add 11 or we need to add 1
                score += 1;
            } else {
                score += 11;
            }

        }

        return score;
    }

    // Place Bet
    @FXML
    void placeBet(MouseEvent event) {
        placeBetScreen.setVisible(false);
        hitStandButtons.setVisible(false);
        winOrLoseMessage.setText("");

        // Cleaning the table
        cleanTable();
        // Shuffled deck
        newDeck = newCardArray();

        // Give the first card to the player
        Card firstCard = newDeck.getFirst();
        playerDeck.add(firstCard);

        // Setting player's card in the table
        printToTable(firstCard, playerTableCardValue.getFirst(), playerTableCardClub.getFirst());
        newDeck.removeFirst();

        // Give the second card to the dealer
        Card secondCard = newDeck.getFirst();
        dealerDeck.add(secondCard);

        // Setting dealer's card in the table
        printToTable(secondCard, dealerTableCardValue.getFirst(), dealerTableCardClub.getFirst());
        newDeck.removeFirst();

        // Give the third card to the player
        Card thirdCard = newDeck.getFirst();
        playerDeck.add(thirdCard);

        // Setting player's card in the table
        printToTable(thirdCard, playerTableCardValue.get(1), playerTableCardClub.get(1));
        newDeck.removeFirst();

        // Give the fourth card to the dealer
        Card fourthCard = newDeck.getFirst();
        dealerDeck.add(fourthCard);
        newDeck.removeFirst();

        // Display player's score
        scorePlayerDisplay.setText(String.valueOf(getScore(playerDeck)));

        if (getScore(playerDeck) == 21) {
            winOrLoseMessage.setText("BlackJack! You won :)");
            yourMoney += (int) (betMoney * 1.5);
            nextButton.setVisible(true);
        } else {
            hitStandButtons.setVisible(true);
            playingCardCounter = 2;
            
        }
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
        playerDeck.add(newDeck.getFirst());
        newDeck.removeFirst();
        printToTable(playerDeck.get(playingCardCounter), playerTableCardValue.get(playingCardCounter),
                playerTableCardClub.get(playingCardCounter));
        int getScore = getScore(playerDeck);
        scorePlayerDisplay.setText(String.valueOf(getScore));

        if (getScore == 21) {
            onStand(event);
        } else if (getScore > 21) {
            winOrLoseMessage.setText("Bad Luck! You lost :(");
            hitStandButtons.setVisible(false);
            nextButton.setVisible(true);
        }
        playingCardCounter++;
    }

    // When "Stand" button is pressed
    @FXML
    void onStand(MouseEvent event) {
        int currentCardCounter = 1;
        printToTable(dealerDeck.get(1), dealerTableCardValue.get(1), dealerTableCardClub.get(1));
        scoreDealerDisplay.setVisible(true);
        scoreDealerDisplay.setText(String.valueOf(getScore(dealerDeck)));

        if (getScore(dealerDeck) > 17) {
            
            if (getScore(playerDeck) < getScore(dealerDeck)) {

                winOrLoseMessage.setText("Bad Luck! You lost :(");
                hitStandButtons.setVisible(false);
                nextButton.setVisible(true);

            } else if (getScore(playerDeck) == getScore(dealerDeck)) {

                winOrLoseMessage.setText("Push! Nobody wins :O");
                yourMoney += betMoney;
                hitStandButtons.setVisible(false);
                nextButton.setVisible(true);

            } else {

                winOrLoseMessage.setText("Wonderful! You won! :)");
                yourMoney += 2 * betMoney;
                hitStandButtons.setVisible(false);
                nextButton.setVisible(true);

            }

        } else {
            while (getScore(dealerDeck) < 17 ) {
                currentCardCounter++;
                Card drawnCard = newDeck.getFirst();
                newDeck.removeFirst();
                dealerDeck.add(drawnCard);
                printToTable(dealerDeck.get(currentCardCounter), dealerTableCardValue.get(currentCardCounter),
                        dealerTableCardClub.get(currentCardCounter));
            }

            scoreDealerDisplay.setText(String.valueOf(getScore(dealerDeck)));

            if (getScore(dealerDeck) > 21) {

                winOrLoseMessage.setText("Wonderful! You won! :)");
                yourMoney += 2 * betMoney;
                hitStandButtons.setVisible(false);
                nextButton.setVisible(true);

            } else if (getScore(playerDeck) < getScore(dealerDeck)) {

                winOrLoseMessage.setText("Bad Luck! You lost :(");
                hitStandButtons.setVisible(false);
                nextButton.setVisible(true);

            } else if (getScore(playerDeck) == getScore(dealerDeck)) {

                winOrLoseMessage.setText("Push! Nobody wins :O");
                yourMoney += betMoney;
                hitStandButtons.setVisible(false);
                nextButton.setVisible(true);

            } else if (getScore(playerDeck) > getScore(dealerDeck)) {

                winOrLoseMessage.setText("Wonderful! You won! :)");
                yourMoney += 2 * betMoney;
                hitStandButtons.setVisible(false);
                nextButton.setVisible(true);

            }
        }
    }

    // When "Next" button is pressed
    @FXML
    void onNext(MouseEvent event) {
        if (yourMoney >= minimumBet) {
            betMoney = minimumBet;
            yourMoney -= minimumBet;

            youHaveText.setText("You have: " + yourMoney);
            youBetText.setText("Your bet: " + betMoney);

            scorePlayerDisplay.setText("");

            playerDeck.clear();
            dealerDeck.clear();

            scoreDealerDisplay.setVisible(false);
            placeBetScreen.setVisible(true);
            nextButton.setVisible(false);
        } else {
            betMoney = minimumBet;

            youHaveText.setText("You have: " + yourMoney);
            youBetText.setText("Your bet: " + betMoney);

            scorePlayerDisplay.setText("");

            playerDeck.clear();
            dealerDeck.clear();

            yourMoney = 200;

            scoreDealerDisplay.setVisible(false);
            gameScreen.setVisible(false);
            homeScreen.setVisible(true);
        }
    }

}
