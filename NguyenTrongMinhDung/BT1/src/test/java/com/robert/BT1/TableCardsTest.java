package com.robert.BT1;

import static org.junit.Assert.*;

import org.junit.*;
import com.robert.BT1.SetOfCards.Type;

public class TableCardsTest {
	private SetOfCards tableCards1, tableCards2, emptyTableCards;
	
	@Before
	public void setUp(){
		tableCards1 = new SetOfCards();
		tableCards2 = new SetOfCards();
		emptyTableCards = new SetOfCards();
	}
	
	@Test
	public void testSimilarCardNumber(){
		tableCards1.addCard(Pack.getCardAt(4));
		tableCards1.addCard(Pack.getCardAt(5));
		assertTrue(tableCards1.similarCardNumber());
		assertEquals("doi", tableCards1.typeOfLegalCards().toString());
		tableCards1.addCard(Pack.getCardAt(6));
		assertEquals("ba", tableCards1.typeOfLegalCards().toString());
		tableCards1.addCard(Pack.getCardAt(7));
		assertEquals("tu_quy", tableCards1.typeOfLegalCards().toString());
	}
	
	@Test
	public void testIllegalCards(){
		tableCards2.addCard(Pack.getCardAt(8));
		tableCards2.addCard(Pack.getCardAt(4));
		assertFalse(emptyTableCards.isStrongerThan(tableCards2));
		assertFalse(tableCards2.isStrongerThan(emptyTableCards));
	}
	
	@Test
	public void testContinousCardNumber(){
		tableCards1.addCard(Pack.getCardAt(4));
		tableCards1.addCard(Pack.getCardAt(11));
		tableCards1.addCard(Pack.getCardAt(13));
		tableCards1.addCard(Pack.getCardAt(18));

		assertTrue(tableCards1.continousCardNumber());
		assertFalse(tableCards2.continousCardNumber());
	}
	
	@Test
	public void testContinousThreePairs(){
		tableCards2.addCard(Pack.getCardAt(8));
		tableCards2.addCard(Pack.getCardAt(4));
		tableCards2.addCard(Pack.getCardAt(7));
		tableCards2.addCard(Pack.getCardAt(10));
		tableCards2.addCard(Pack.getCardAt(13));
		tableCards2.addCard(Pack.getCardAt(14));
		
		assertTrue(tableCards2.continousThreePairs());
	}
	
	@Test
	public void testContinousThreePairsStrongerThan2() {
		tableCards1.addCard(Pack.getCardAt(3));
		
		tableCards2.addCard(Pack.getCardAt(8));
		tableCards2.addCard(Pack.getCardAt(4));
		tableCards2.addCard(Pack.getCardAt(7));
		tableCards2.addCard(Pack.getCardAt(10));
		tableCards2.addCard(Pack.getCardAt(13));
		tableCards2.addCard(Pack.getCardAt(14));
		
		assertTrue(tableCards2.continousThreePairs());
		assertEquals(tableCards1.getCardAt(0).getLevel(), 52);
		assertTrue(tableCards2.isStrongerThan(tableCards1));
	}
	
	@Test
	public void testContinousThreePairsStrongerThanCoupleOf2() {
		tableCards1.addCard(Pack.getCardAt(2));
		tableCards1.addCard(Pack.getCardAt(3));
		
		tableCards2.addCard(Pack.getCardAt(8));
		tableCards2.addCard(Pack.getCardAt(4));
		tableCards2.addCard(Pack.getCardAt(7));
		tableCards2.addCard(Pack.getCardAt(10));
		tableCards2.addCard(Pack.getCardAt(13));
		tableCards2.addCard(Pack.getCardAt(14));
		
		assertTrue(tableCards2.continousThreePairs());
		assertFalse(tableCards2.isStrongerThan(tableCards1));
	}
	
	@Test
	public void testVeryLongTableCards(){
		for (int i = 0; i < Pack.numberOfCards; i+=4){
			tableCards1.addCard(Pack.getCardAt(i));
		}
		
		assertTrue(tableCards1.continousCardNumber());
	}
	
	@Test
	public void testStrength(){
		tableCards1.addCard(Pack.getCardAt(8));
		tableCards1.addCard(Pack.getCardAt(9));
		tableCards1.addCard(Pack.getCardAt(10));
		tableCards1.addCard(Pack.getCardAt(11));
		
		tableCards2.addCard(Pack.getCardAt(3));
		assertEquals(Type.tu_quy, tableCards1.typeOfLegalCards());
		assertTrue(tableCards1.isStrongerThan(tableCards2));
		
		tableCards2.removeAll();
		tableCards2.addCard(Pack.getCardAt(8));
		tableCards2.addCard(Pack.getCardAt(4));
		tableCards2.addCard(Pack.getCardAt(7));
		tableCards2.addCard(Pack.getCardAt(10));
		tableCards2.addCard(Pack.getCardAt(13));
		tableCards2.addCard(Pack.getCardAt(14));
		
		tableCards1.removeAll();
		tableCards1.addCard(Pack.getCardAt(3));
		assertTrue(tableCards2.isStrongerThan(tableCards1));
		
		tableCards1.removeAll();
		tableCards2.removeAll();
		tableCards1.addCard(Pack.getCardAt(0));
		tableCards2.addCard(Pack.getCardAt(2));
		assertTrue(tableCards2.isStrongerThan(tableCards1));
		
		tableCards1.removeAll();
		for (int i = 4; i < 21; i+= 4){
			tableCards1.addCard(Pack.getCardAt(i));
		}
		assertTrue(tableCards1.isStrongerThan(tableCards2));
	}
}
