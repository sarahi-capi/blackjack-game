package com.example.blackjack;

public class Card {
    private String club;
    private String value;

    // Card Constructor
    public Card(String value, String club) {
        this.club = club;
        this.value = value;
    }

    // Get Club
    public String getClub() {
        return this.club;
    }

    // Get Value
    public String getValue() {
        return this.value;
    }

}

