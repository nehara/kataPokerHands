package com.pokerhands;

/**
 * Created by nehara on 7/23/2016.
 */
public class Card {
    int value;
    char suit;

    public Card(String input) {
        suit=input.charAt(input.length()-1);
        String temp=input.substring(0,input.length()-1);
        if(Character.isDigit(temp.charAt(0)))
            value=Integer.valueOf(temp);
        else{
            switch(temp.charAt(0))
            {
                case 'J' :
                    value=11;
                    break;
                case 'Q' :
                    value=12;
                    break;
                case 'K' :
                    value=13;
                    break;
                case 'A' :
                    value=14;
                    break;
                default:
                    value=0;
                    break;
            }
        }

    }

    public int getValue() {
        return value;
    }

    public char getSuit() {
        return suit;
    }
}
