# JavaFX Blackjack with an ASCII touch 🃏♠️♥️

> A fully playable Blackjack game built from scratch during my first semester, showcasing foundational Object-Oriented Programming (OOP) and Event-Driven UI design.

<p align="center">
  <table>
    <tr>
      <td>
        <img width="626" height="465" alt="image" src="https://github.com/user-attachments/assets/3a639049-ce68-429a-8a2e-ecb270f11561">
      </td>
      <td>
        <img width="629" height="469" alt="image" src="https://github.com/user-attachments/assets/5b81b8e9-9247-4f24-a981-94c9989defb9" />
      </td>
    </tr>
    <tr>
      <td>
        <img width="626" height="469" alt="image" src="https://github.com/user-attachments/assets/c16c83d7-e5d4-4695-9fef-d5b9f5c984d8" />
      </td>
      <td>
        <img width="626" height="467" alt="image" src="https://github.com/user-attachments/assets/b99ca3d1-e8e1-45ff-b51a-59e962279f8a" />
      </td>
    </tr>
  </table>
</p>

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
