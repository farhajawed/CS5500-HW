package problem2;


import diErBao.Ka;
import diErBao.Shou;
import diErBao.ShouShiXia;
import diErBao.kaShiXia;
import problem2.adapter.CardAdapter;
import problem2.adapter.HandAdapter;
import problem2.card.Card;
import problem2.hand.Hand;


/**
 * Main method creating and accepting cards in hand using adapter
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 Ka ka1 = new kaShiXia(0,0);
   	     Ka ka2 = new kaShiXia(0,0);
	   	 Ka ka3 = new kaShiXia(0,2);
	   	 Ka ka4 = new kaShiXia(9,0);
	   	 Ka ka5 = new kaShiXia(9,1);
	   	 Ka ka6 = new kaShiXia(9,3);
	   	
   	 
   	
   	     Card card1 = new CardAdapter(ka1);
	   	 Card card2 = new CardAdapter(ka2);
	   	 Card card3 = new CardAdapter(ka3);
	   	 Card card4 = new CardAdapter(ka4);
	   	 Card card5 = new CardAdapter(ka5);
	   	 Card card6 = new CardAdapter(ka6);
	   
	   	 Shou shou = new ShouShiXia();
    	 Hand hand = new HandAdapter(shou);
    	 hand.accept(card1);
    	 hand.accept(card2);
    	 hand.accept(card3);
    	 hand.accept(card4);
    	 hand.accept(card5);
    	 hand.accept(card6);
    	
   
    }}
