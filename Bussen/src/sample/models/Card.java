package sample.models;
import java.util.Objects;

/**
 * @author: Bart de Graaf
 * @Learning line: Object oriented programming
 * @Date: 20-02-2020
 */

public class Card
{

    public enum Suit
    {
        SPADES, HEARTS, DIAMONDS, CLUBS;
    }

    // The min and max valid card ranks
    private static final int MIN_RANK = 2;
    private static final int MAX_RANK = 14;

    // This instance's rank and suit
    private int rank;
    private Suit suit;

    public Card(int rank, Suit suit)
    {
        setRank(rank);
        setSuit(suit);
    }

    public int getRank()
    {
        return rank;
    }

    public String getRankCardLike()
    {
    if(rank == 11){
        return "B";
    }else if(rank == 12){
        return "Q";
    }else if(rank == 13){
        return "K";
    }else if(rank == 14){
        return "A";
    }else
        return String.valueOf(rank);
    }

    public String getCardColor(){
        if(suit.name() == "DIAMONDS"){
            return "-fx-text-fill: red";
        }else if(suit.name() == "SPADES"){
            return "-fx-text-fill: black";
        }else if(suit.name() == "CLUBS"){
            return "-fx-text-fill: black";
        }else if(suit.name() == "HEARTS"){
            return "-fx-text-fill: red";
        }else{
            return "-fx-text-fill: black";
        }
    }

    public void setRank(int rank)
    {
        this.rank = rank;
    }
    public Suit getSuit()
    {
        return suit;
    }


    public char getSuitIcon()
    {
        if(suit.name() == "DIAMONDS"){
            return (char)'\u2666';
        }else if(suit.name() == "SPADES"){
            return (char)'\u2660';
        }else if(suit.name() == "CLUBS"){
            return (char)'\u2663';
        }else if(suit.name() == "HEARTS"){
            return (char)'\u2764';
        }else{
            return (char)'?';
        }
    }

    public void setSuit(Suit suit)
    {
        this.suit = suit;
    }

    @Override
    public String toString()
    {
        return String.format("%s[rank=%d, suit=%s]",
                getClass().getSimpleName(),
                getRank(),
                getSuit().name());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Card))
            return false;
        if (obj == this)
            return true;

        Card that = (Card)obj;
        return that.getRank() == getRank() && that.getSuit() == getSuit();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getRank(), getSuit());
    }

    public static int getMinRank()
    {
        return MIN_RANK;
    }

    public static int getMaxRank()
    {
        return MAX_RANK;
    }

    public static Suit[] getSuits()
    {
        return Suit.values();
    }

}