package com.pokerhands;

import java.util.Vector;

/**
 * Created by nehara on 7/23/2016.
 */
public class Hand {
    Vector<Card> cards;
    int combination;
    int highCard;

    public Hand(String[] handInput) {
        cards=new Vector<Card>(5);
        for(int i=0;i<handInput.length;i++)
            cards.add(new Card(handInput[i]));
        sort();
    }

    private void sort() {
        for(int i=0;i<cards.capacity();i++){
            int minIndex=i;
            int min=getValue(i);
            for(int j=i+1;j<cards.capacity();j++){
                if(getValue(j)<min){
                    min=getValue(j);
                    minIndex=j;
                }
            }
            Card tempCard=getCard(i);
            cards.set(i,getCard(minIndex));
            cards.set(minIndex,tempCard);
        }
    }

    public int getValue(int i) {
        return cards.get(i).getValue();
    }

    public char getSuit(int i) {
        return cards.get(i).getSuit();
    }

    public int getCombination() {
        return combination;
    }

    public int getHighCard() {
        return highCard;
    }

    public Card getCard(int i) {
        return cards.get(i);
    }

    public void setCombination(int combination) {
        this.combination = combination;
    }

    public void setHighCard(int i) {
        highCard=i;
    }
}
