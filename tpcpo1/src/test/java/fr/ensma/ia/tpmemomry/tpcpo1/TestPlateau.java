package fr.ensma.ia.tpmemomry.tpcpo1;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;
import junit.framework.*;

public class TestPlateau extends TestCase{
	
	public void testPlateau(){
		Plateau p = new Plateau();
		
		System.out.println(p.toString());
		System.out.println("le deuxième string avec cartes melanges \n");
		System.out.println(p.toStringM());
		p.setCarte1(p.getListeCartesMelangees().get(5));
		System.out.println(p.getEtatCourant());
		p.setCarte2(p.getListeCartesMelangees().get(8));
		System.out.println(p.getEtatCourant());
		System.out.println(p.comparaisonPaire());
		p.setEtatCourant(p.getpasCarteSelectionnee());
		System.out.println(p.getEtatCourant());
		
	}
}
