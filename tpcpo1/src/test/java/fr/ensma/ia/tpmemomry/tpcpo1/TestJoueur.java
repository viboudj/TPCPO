package fr.ensma.ia.tpmemomry.tpcpo1;

import junit.framework.TestCase;
import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.*;

public class TestJoueur extends TestCase {
	public void testJoueur(){
		IJoueur joueur1 = new Humain("tom");
		assertEquals(joueur1.getNom(),"tom");
		joueur1.tourGagne(3);
		assertEquals(joueur1.getScore().getScore(),5);
	}

}
