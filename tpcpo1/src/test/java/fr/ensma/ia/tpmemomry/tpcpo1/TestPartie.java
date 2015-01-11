package fr.ensma.ia.tpmemomry.tpcpo1;


import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.*;
import junit.framework.TestCase;

public class TestPartie extends TestCase{
	public void testPartie1(){
		Partie partie= new Partie();
		Humain joueur1 = new Humain("fred");
		Humain joueur2 = new Humain("ned");
		partie.ajouterJoueur(joueur1);
		partie.ajouterJoueur(joueur2);
		System.out.println(partie.getJoueurCourant().getNom());
		
		assertEquals(partie.getPlateau().getEtatCourant(),partie.getPlateau().getpasCarteSelectionnee());
		partie.getPlateau().setCarte1(partie.getPlateau().getListeCartesMelangees().get(2));
		assertEquals(partie.getPlateau().getEtatCourant(),partie.getPlateau().getuneCarteSelectionnee());
		partie.getPlateau().setCarte2(partie.getPlateau().getListeCartesMelangees().get(5));
		
		assertEquals(partie.getPlateau().getEtatCourant(),partie.getPlateau().getdeuxCartesSelectionnees());
		partie.traitement();
		assertEquals(partie.getPlateau().getEtatCourant(),partie.getPlateau().getpasCarteSelectionnee());
		System.out.println(partie.getJoueurCourant().getNom());
	}
	
	public void testPartieIA() {
		Partie partie= new Partie();
		partie.ajoutJoueurIAStupide();
		partie.ajoutJoueurIAStupide();
		System.out.println(partie.getPlateau().toStringM());
		while(true){
		System.out.println(partie.getJoueurCourant().getNom());
		System.out.println("nombre de cartes restantes: " + partie.getPlateau().getNbrCartesRestantes());
		partie.tour();
		System.out.println("Carte sur le Plateau: " + partie.getPlateau().toStringCarteSurPlateau());
		System.out.println(partie.getEtatCourantPartie());
		}
	}
	

}
