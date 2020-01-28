package pl.patrykgala.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {
    private final Game game = new Game();

    @Test
    void testGutterGame() {
        int n = 20;
        int pins = 0;
        rollMany(n, pins);
        assertThat(game.score()).isEqualTo(0);
    }


    @Test
    void testAllOnes() {
        rollMany(20, 1);
        assertThat(game.score()).isEqualTo(20);
    }

    @Test
    void testOneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.score()).isEqualTo(16);
    }

    @Test
    void testOneStrike() {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertThat(game.score()).isEqualTo(24);
    }

    @Test
    void rollPerfectGame() {
        rollMany(12, 10);
        assertThat(game.score()).isEqualTo(300);
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }
}
