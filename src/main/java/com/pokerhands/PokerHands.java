package com.pokerhands;

/**
 * Created by nehara on 7/23/2016.
 */
public class PokerHands {
    public Hand player1,player2;
    private int noOfCards=5;

    public PokerHands(String contentOfBothHands) {
        String OneHand=contentOfBothHands.substring(contentOfBothHands.indexOf(":")+1,contentOfBothHands.indexOf("SecondHand"));
        String SecondHand=contentOfBothHands.substring(contentOfBothHands.lastIndexOf(":")+1);
        String[] cardsOfOneHand=OneHand.trim().split(" ");
        String[] cardsOfSecondHand=SecondHand.trim().split(" ");
        player1=new Hand(cardsOfOneHand);
        player2=new Hand(cardsOfSecondHand);
    }

    public void judgeHand() {
        getCombination(player1);
        getCombination(player2);
    }

    private void getCombination(Hand player) {
        checkGetCombination(player);

    }

    private void checkGetCombination(Hand player) {
        if(hasStraightFlush(player)) {
            checkCombinationForStraightFlush(player);
        }
        else if(hasFourOfAKind(player)) {
            player.setCombination(7);
            player.setHighCard(player.getValue(1));
        }
            else if(hasFullFlush(player)) {
            player.setCombination(6);
            player.setHighCard(player.getValue(2));
        }
            else if(hasFlush(player)) {
            player.setCombination(5);
            player.setHighCard(player.getValue(4));
        }
            else if(hasStraight(player)){
            setCombinationHighCardForStraight(player);
        }
            else if(hasThreeOfAKind(player)) {
            player.setCombination(3);
            player.setHighCard(player.getValue(2));
        }
            else if(hasTwoPair(player)) {
                player.setCombination(2);
                player.setHighCard(player.getValue(3));
        }
            else if(hasPair(player)){
                player.setCombination(1);
            if(isPair(player.getCard(0),player.getCard(1))||(isPair(player.getCard(2),player.getCard(1))))
                player.setHighCard(player.getValue(1));
            else
                player.setHighCard(player.getValue(3));

        }
        else
            player.setHighCard(player.getValue(4));
    }

    private void setCombinationHighCardForStraight(Hand player) {
        player.setCombination(4);
        int temp=player.getValue(4)==14 && player.getValue(3)==5 ? 5:player.getValue(4);
        player.setHighCard(temp);
    }

    private void checkCombinationForStraightFlush(Hand player) {
        player.setCombination(8);
        int temp=player.getValue(4)==14 && player.getValue(3)==5 ? 5:player.getValue(4);
        player.setHighCard(temp);
    }

    private boolean hasStraightFlush(Hand player) {
        return hasFlush(player) && hasStraight(player);
    }

    private boolean hasFourOfAKind(Hand player) {
        for(int i=0;i<noOfCards-3;i++){
            if(isThreeOfAKind(player.getCard(i),player.getCard(i+1),player.getCard(i+2))
                && isPair(player.getCard(i+2),player.getCard(i+3)))
                return true;

        }
        return false;
    }

    private boolean hasFullFlush(Hand player) {
        return (isPair(player.getCard(0),player.getCard(1)) &&
                    (isThreeOfAKind(player.getCard(2),player.getCard(3),player.getCard(4)))||
                    isPair(player.getCard(3),player.getCard(4)) &&
                            (isThreeOfAKind(player.getCard(0),player.getCard(1),player.getCard(2))));

        }


    private boolean hasFlush(Hand player) {
        for(int i=0;i<noOfCards-1;i++){
            if(player.getSuit(i)!=player.getSuit(i+1))
                return false;
        }
        return true;
    }

    private boolean hasStraight(Hand player) {
        for(int i=noOfCards-1;i>0;i--){
            int one=player.getValue(i);
            int two=player.getValue(i-1);
            if(one==14 && two==5)
                continue;;
            if(one-two!=1)
                return false;
        }
        return true;
    }

    private boolean hasThreeOfAKind(Hand player) {
        for(int i=0;i<noOfCards-2;i++){
            if(isThreeOfAKind(player.getCard(i),player.getCard(i+1),player.getCard(i+2)))
                return true;
        }
        return false;
    }

    private boolean isThreeOfAKind(Card card1, Card card2, Card card3) {
        return card1.getValue()==card2.getValue() && card2.getValue()==card3.getValue();
    }

    private boolean hasTwoPair(Hand player) {
        for(int i=0;i<noOfCards-3;i++){
            if(isPair(player.getCard(i),player.getCard(i+1))){
                for(int j=i+2;j<noOfCards-1;j++){
                    if(isPair(player.getCard(j),player.getCard(j+1)))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean hasPair(Hand player) {
        for(int i=0;i<noOfCards-1;i++){
            if(isPair(player.getCard(i),player.getCard(i+1)))
                return true;
        }
        return false;
    }

    private boolean isPair(Card card1, Card card2) {
        return card1.getValue()==card2.getValue();
    }

    public String getWinner() {
        if(player1.getCombination()==player2.getCombination())
            return player1.getHighCard()>player2.getHighCard() ? "Black":"White";
        else
            return player1.getCombination()>player2.getCombination() ? "Black":"White";
    }
}
