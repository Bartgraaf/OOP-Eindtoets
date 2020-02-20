package sample.models;

import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;

/**
 * @author: Bart de Graaf
 * @Learning line: Object oriented programming
 * @Date: 20-02-2020
 */

class Deck implements Iterable<Card>
{
    private final Card[] cards;
    private int top;

    public Deck()
    {
        cards = new Card[Card.getSuits().length * (Card.getMaxRank() - Card.getMinRank() + 1)];
        refresh();
    }

    public void refresh()
    {
        Card.Suit[] suits = Card.getSuits();
        int min_rank = Card.getMinRank();
        int max_rank = Card.getMaxRank();

        int i = 0;
        for (Card.Suit suit : suits)
            for (int rank = min_rank; rank <= max_rank; rank++)
                cards[i++] = new Card(rank, suit);

        top = cards.length - 1;
        assert cards[top] != null;
    }

    public void shuffle()
    {
        Random rng = new Random();

        for (int i = cards.length - 1; i > 0; i--) {
            // Swap the i-th card with a random one
            int j = rng.nextInt(i + 1);
            Card tmp = cards[j];
            cards[j] = cards[i];
            cards[i] = tmp;
        }
    }

    public boolean empty()
    {
        return top < 0;
    }

    public Card takeCard()
    {
        return cards[top--];
    }

    public Iterator<Card> iterator()
    {
        return new Iterator<Card>()
        {
            private int cursor = top;

            public boolean hasNext()
            {
                return cursor >= 0;
            }

            public Card next()
            {
                if (hasNext()){
                    return cards[cursor--];
                }
                throw new NoSuchElementException();
            }
        };
    }
}