package edu.algorithm.interview;

import java.util.ArrayList;

enum Suit
{
    Club(0), Diamond(1), Heart(2), Spade(3);

    private int value;

    private Suit(int v)
    {
        this.value = v;
    }

    public int getValue()
    {
        return value;
    }

    public static Suit getSuitFromValue(int value)
    {
        switch (value)
        {
            case 0:
                return Club;
            case 1:
                return Diamond;
            case 2:
                return Heart;
            case 3:
                return Spade;
        }
        return null;
    }
}

class Deck<T extends Card>
{
    // all cards, dealt or not
    private ArrayList<T> cards;

    // marks first undealt card
    private int dealtIndex = 0;

    public void setDeckOfCards(ArrayList<T> deckOfCards)
    {
        this.cards = deckOfCards;
    }

    public void shuffle()
    {

    }

    public int remainingCards()
    {
        return cards.size() - dealtIndex;
    }

    public T[] dealHand(int number)
    {
        return null;
    }

    public T dealCard()
    {
        return null;
    }
}

abstract class Card
{
    private boolean available = true;

    // #1 to #13
    protected int faceValue;

    protected Suit suit;

    public Card(int c, Suit s)
    {
        this.faceValue = c;
        this.suit = s;
    }

    public abstract int value();

    public Suit suit()
    {
        return suit;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void markUnavailable()
    {
        available = false;
    }

    public void markAvailable()
    {
        available = true;
    }
}

class Hand <T extends Card>
{
    protected ArrayList<T> cards = new ArrayList<T>();

    public int score()
    {
        int score = 0;
        for (T card : cards)
        {
            score += card.value();
        }
        return score;
    }
    
    public void addCard(T card)
    {
        cards.add(card);
    }
}



public class Q8_1
{
}
