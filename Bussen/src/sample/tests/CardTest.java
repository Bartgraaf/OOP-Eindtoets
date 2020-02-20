package sample.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import sample.models.Card;
import static org.junit.jupiter.api.Assertions.*;
import static sample.models.Card.Suit.*;

/**
 * @author: Bart de Graaf
 * @Learning line: Object oriented programming
 * @Date: 20-02-2020
 */

class CardTest {

    @Test
    void testGetRank() {
        Card card = new Card(14, DIAMONDS);
        int rank = card.getRank();
        assertEquals(14, rank);
    }

    @Test
    void testGetRankCardLike() {
        Card card = new Card(14, DIAMONDS);
        String rank = card.getRankCardLike();
        assertEquals("A", rank);
    }

    @Test
    void testGetCardColor() {
        Card card = new Card(14, DIAMONDS);
        String color = card.getCardColor();
        assertEquals("-fx-text-fill: red", color);
    }

    @Test
    void testGetSuit() {
        Card card = new Card(14, DIAMONDS);
        Card.Suit suit = card.getSuit();
        assertEquals(DIAMONDS, suit);
    }

    @Test
    void testGetSuitIcon() {
        Card card = new Card(14, DIAMONDS);
        char suit = card.getSuitIcon();
        char suitExpected = (char)'\u2666';
        assertEquals(suitExpected, suit);
    }

    @Test
    void testGetMinRank() {
        Card card = new Card(14, DIAMONDS);
        int minRank = card.getMinRank();
        assertEquals(2, minRank);
    }

    @Test
    void testGetMaxRank() {
        Card card = new Card(14, DIAMONDS);
        int maxRank = card.getMaxRank();
        assertEquals(14, maxRank);
    }

    @Test
    void testGetSuits() {
        Card card = new Card(14, DIAMONDS);
        Card.Suit[] suit = card.getSuits();
        Card.Suit[] expectedSuit = {SPADES, HEARTS, DIAMONDS, CLUBS};
        Assert.assertArrayEquals( expectedSuit, suit );
    }
}