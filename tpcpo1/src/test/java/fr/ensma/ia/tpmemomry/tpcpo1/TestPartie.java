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
		
		assertEquals(partie.getPlateau().getEtatCourant(),partie.getPlateau().getpasCarteSelectionnee());
		partie.getPlateau().setCarte1(partie.getPlateau().getListeCartesMelangees().get(2));
		assertEquals(partie.getPlateau().getEtatCourant(),partie.getPlateau().getuneCarteSelectionnee());
		partie.getPlateau().setCarte2(partie.getPlateau().getListeCartesMelangees().get(5));
		
		assertEquals(partie.getPlateau().getEtatCourant(),partie.getPlateau().getdeuxCartesSelectionnees());
		partie.traitement();
		assertEquals(partie.getPlateau().getEtatCourant(),partie.getPlateau().getpasCarteSelectionnee());
	}
	

}
