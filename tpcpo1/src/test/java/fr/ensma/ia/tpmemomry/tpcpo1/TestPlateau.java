package fr.ensma.ia.tpmemomry.tpcpo1;

import junit.framework.*;

public class TestPlateau extends TestCase{
	
	public void testPlateau(){
		Partie p = new Partie(5, 1, true, 10);
		System.out.println(p.getPlateau().toString());
		System.out.println("le deuxième string avec cartes melanges \n");
		System.out.println(p.getPlateau().toStringM());
	}
}
