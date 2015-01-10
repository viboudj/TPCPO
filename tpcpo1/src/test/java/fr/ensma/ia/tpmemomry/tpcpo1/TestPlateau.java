package fr.ensma.ia.tpmemomry.tpcpo1;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;
import junit.framework.*;

public class TestPlateau extends TestCase{
	
	public void testPlateau(){
		Plateau p = new Plateau();
		System.out.println(p.toString());
		System.out.println("le deuxième string avec cartes melanges \n");
		System.out.println(p.toStringM());
		
	}
}
