package fr.ensma.ia.tpmemomry.tpcpo1;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Carte;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.ESymboleCarte;
import junit.framework.*;

public class TestCarte extends TestCase {
	public void testCarte(){
		Carte c = new Carte(ESymboleCarte.carré,5);
		System.out.println(c.toString()); 
	}

}
