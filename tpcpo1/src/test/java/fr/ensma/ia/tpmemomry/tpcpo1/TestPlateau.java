package fr.ensma.ia.tpmemomry.tpcpo1;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;
import junit.framework.*;

public class TestPlateau extends TestCase{
	
	
	public void testPlateau(){
		Partie p = new Partie(5,1);
		System.out.println(p.getPlateau().toString());
		System.out.println("le deuxième string avec cartes melanges \n");
		System.out.println(p.getPlateau().toStringM());
		
		Partie p2 = new Partie();
		System.out.println("Pateau cahier des charge \n");
		System.out.println(p2.getPlateau().toString());
	}
}
