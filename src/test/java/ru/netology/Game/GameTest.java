package ru.netology.Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    @Test
    public void player1WinsTest() {
        Player player1 = new Player(1, "Alex", 100);
        Player player2 = new Player(2, "Steve", 50);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Alex", "Steve");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void player2WinsTest() {
        Player player1 = new Player(1, "Alex", 50);
        Player player2 = new Player(2, "Steve", 100);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Alex", "Steve");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playersAreEqual() {
        Player player1 = new Player(1, "Alex", 100);
        Player player2 = new Player(2, "Steve", 100);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Alex", "Steve");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void player1IsNotRegisteredTest() {
        Player player1 = new Player(1, "Alex", 100);
        Player player2 = new Player(2, "Steve", 100);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Iron Golem", "Steve"));
    }

    @Test
    public void player2IsNotRegisteredTest() {
        Player player1 = new Player(1, "Alex", 100);
        Player player2 = new Player(2, "Steve", 100);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Steve", "Iron Golem"));
    }

    @Test
    public void allPlayersAreNotRegisteredTest() {
        Player player1 = new Player(1, "Alex", 100);
        Player player2 = new Player(2, "Steve", 100);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Skeleton", "Iron Golem"));
    }
}


