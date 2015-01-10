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
		partie.getPlateau().setCarte1(partie.getPlateau().getListeCartesMelangees().get(2));
		partie.getPlateau().setCarte2(partie.getPlateau().getListeCartesMelangees().get(5));

		System.out.println(partie.getPlateau().getEtatCourant());
		System.out.println(partie.getPlateau().getCarte1().toString());
		System.out.println(partie.getPlateau().getCarte1().toString());
		//partie.traitementPaireNonTrouvee();
		partie.traitementPaireTrouvee();
		//partie.traitement();
	
		
	}
	

}
