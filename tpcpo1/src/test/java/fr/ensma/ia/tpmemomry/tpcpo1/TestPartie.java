package fr.ensma.ia.tpmemomry.tpcpo1;


import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.*;
import junit.framework.TestCase;

public class TestPartie extends TestCase{
	public void testPartie(){
		Partie partie= new Partie();
		Humain joueur1 = new Humain("fred");
		Humain joueur2 = new Humain("ned");
		partie.ajouterJoueur(joueur1);
		partie.ajouterJoueur(joueur2);
		System.out.println(partie.toString());
		partie.traitement();
		System.out.println(partie.toString());
	}
	

}
