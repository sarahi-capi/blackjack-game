# JavaFX Blackjack with an ASCII touch 🃏♠️♥️

> A fully playable Blackjack game built from scratch during my first semester, showcasing foundational Object-Oriented Programming (OOP) and Event-Driven UI design.

## The Concept ✨
This project is a classic Blackjack implementation with a unique twist: the casino chips and card suits were generated entirely via hardcoded ASCII strings. It was designed to explore how backend Java logic (deck shuffling, score calculation, betting mathematics) connects to a frontend user interface that I structured myself.

## Technical Breakdown 🛠️ 
This project was structured using the MVC (Model-View-Controller) paradigm to keep the game logic strictly separated from the graphical interface.

* Frontend was built with **JavaFX**. I manually structured the `blackjack-view.fxml` and customized the aesthetics using my own CSS files (`textAreaStyle.css` & `scrollPaneStyle.css`) to ensure the ASCII art rendered perfectly with a transparent background.
* Backend used strict **OOP** structures. The `Card.java` class handles individual card data, while the main logic manages the deck array and score probability.
* `BlackJackController.java` manages the event-driven gameplay loop (Hit, Stand, Place Bet) and mathematically calculates the dynamic value of Aces (1 or 11) depending on the player's hand.

## How to Run 🚀
This project was built as a standard JavaFX module. To run it locally:
1. Clone the repository to your machine.
2. Open the project folder in your preferred Java IDE (IntelliJ IDEA, Eclipse, or VS Code).
3. Ensure the JavaFX SDK is configured in your project structure.
4. Run the `BlackJackApp.java` main class!

---
*Created by Sarahi — Where backend logic meets creative UI design.*
