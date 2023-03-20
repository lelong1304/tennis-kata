package org.kata;

import org.kata.model.Match;
import org.kata.model.Player;
import org.kata.model.TennisMatch;

public class Main {
    public static void main(String[] args) {
        // ex : game 1
        String game1Input = "ABABAA";
        Match tennisMatch = new TennisMatch(game1Input);
        tennisMatch.play();

        // ex : game 2
        String game2Input = "ABABABBAABBB";
        Player player1 = new Player("Long LE", 'A');
        Player player2 = new Player("Arnaud Mary", 'B');
        Match tennisMatch2 = new TennisMatch(game2Input, player1, player2);
        tennisMatch2.play();

    }
}