package com.testpokerhands;

import com.pokerhands.Card;
import com.pokerhands.Hand;
import com.pokerhands.PokerHands;
import org.junit.Test;



import static junit.framework.TestCase.assertEquals;

/**
 * Created by nehara on 7/23/2016.
 */
public class TestPokerHands {
    @Test
    public void createCard() throws Exception{
        String input="KD";
        Card card=new Card(input);
        assertEquals(13,card.getValue());
        assertEquals('D',card.getSuit());

    }
    @Test
    public void createHands() throws Exception{
        String [] handInput={"2D","3D","4D","5D","6D"};
        Hand hand=new Hand(handInput);
        assertEquals(2,hand.getValue(0));
        assertEquals('D',hand.getSuit(0));
        assertEquals(3,hand.getValue(1));
        assertEquals('D',hand.getSuit(1));
        assertEquals(4,hand.getValue(2));
        assertEquals('D',hand.getSuit(2));
        assertEquals(5,hand.getValue(3));
        assertEquals('D',hand.getSuit(3));
        assertEquals(6,hand.getValue(4));
        assertEquals('D',hand.getSuit(4));

    }
    @Test
    public void isPair() throws Exception{
        String contentOfBothHands="OneHand: 2H 5D 6S KC KD SecondHand: 2C 3H 4S 8C AH";
        PokerHands poker=new PokerHands(contentOfBothHands);
        poker.judgeHand();
        assertEquals(1,poker.player1.getCombination());
        assertEquals(13,poker.player1.getHighCard());
    }
    @Test
    public void isTwoPair() throws Exception{
        String contentOfBothHands="OneHand: 6H 5D 6S KC KD SecondHand: 2C 3H 4S 8C AH";
        PokerHands poker=new PokerHands(contentOfBothHands);
        poker.judgeHand();
        assertEquals(2,poker.player1.getCombination());
        assertEquals(13,poker.player1.getHighCard());
    }
    @Test
    public void isThreeOfAKind() throws Exception{
        String contentOfBothHands="OneHand: 2H 5D KS KC KD SecondHand: 2C 3H 4S 8C AH";
        PokerHands poker=new PokerHands(contentOfBothHands);
        poker.judgeHand();
        assertEquals(3,poker.player1.getCombination());
        assertEquals(13,poker.player1.getHighCard());
    }
    @Test
    public void isStraight() throws Exception{
        String contentOfBothHands="OneHand: 2H 3D 4S 5C AD SecondHand: 2C 3H 4S 8C AH";
        PokerHands poker=new PokerHands(contentOfBothHands);
        poker.judgeHand();
        assertEquals(4,poker.player1.getCombination());
        assertEquals(5,poker.player1.getHighCard());
    }
    @Test
    public void isFlush() throws Exception{
        String contentOfBothHands="OneHand: 2D 3D 4D 5D AD SecondHand: 2C 3H 4S 8C AH";
        PokerHands poker=new PokerHands(contentOfBothHands);
        poker.judgeHand();
        assertEquals(8,poker.player1.getCombination());
        assertEquals(5,poker.player1.getHighCard());
    }
    @Test
    public void isFullFlush() throws Exception{
        String contentOfBothHands="OneHand: 3S 3D AC AS AD SecondHand: 2C 3H 4S 8C AH";
        PokerHands poker=new PokerHands(contentOfBothHands);
        poker.judgeHand();
        assertEquals(6,poker.player1.getCombination());
        assertEquals(14,poker.player1.getHighCard());
    }
    @Test
    public void isFourOfAKind() throws Exception{
        String contentOfBothHands="OneHand: 3S AH AC AS AD SecondHand: 2C 3H 4S 8C KH";
        PokerHands poker=new PokerHands(contentOfBothHands);
        poker.judgeHand();
        assertEquals(7,poker.player1.getCombination());
        assertEquals(14,poker.player1.getHighCard());
    }
    @Test
    public void isStraightFlush() throws Exception{
        String contentOfBothHands="OneHand: 2D 3D 4D 5D 6D SecondHand: 2C 3H 4S 8C KH";
        PokerHands poker=new PokerHands(contentOfBothHands);
        poker.judgeHand();
        assertEquals(8,poker.player1.getCombination());
        assertEquals(6,poker.player1.getHighCard());
    }
    @Test
    public void getWinner() throws Exception{
        String contentOfBothHands="OneHand: 2D 3D 4D 5D 6D SecondHand: 2C 3H 4S 8C KH";
        PokerHands poker=new PokerHands(contentOfBothHands);
        poker.judgeHand();
        assertEquals("Black",poker.getWinner());

    }

}
