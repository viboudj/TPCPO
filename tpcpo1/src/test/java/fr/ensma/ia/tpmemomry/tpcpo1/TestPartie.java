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
	
	/*public void testPetitePartie(){
		Partie partie= new Partie(2, 2, false, 0);
		partie.ajoutJoueurIAStupide();
		partie.ajoutJoueurIAStupide();
		System.out.println(partie.getPlateau().toStringM());
		while (partie.getEtatCourantPartie()==partie.getPairesRestantes()){
		partie.tour();
		System.out.println("Carte restante sur le Plateau: " + partie.getPlateau().toStringCarteSurPlateau());
		}
	}*/

	public void testPartieIA() {
		Partie partie = new Partie();
		//Partie partie= new Partie(10,10,false,0);
		partie.ajoutJoueurIAStupide();
		partie.ajoutJoueurIAStupide();
		//partie.ajoutJoueurIAStupide();
		//partie.ajoutJoueurIAStupide();
		System.out.println(partie.toString());
		
		while(partie.getEtatCourantPartie()==partie.getPairesRestantes()){
		System.out.println(partie.getJoueurCourant().getNom());
		System.out.println("nombre de cartes restantes: " + partie.getPlateau().getNbrCartesRestantes());
		partie.getJoueurCourant().jouer();
		partie.traitement();
		System.out.println("Carte sur le Plateau: " + partie.getPlateau().toStringCarteSurPlateau());
		}
		System.out.println("score du joueur " + partie.getListeJoueurs().get(0).getNom() + " : " + partie.getListeJoueurs().get(0).getScore().getScore() );
		System.out.println("score du joueur " + partie.getListeJoueurs().get(1).getNom() + " : " + partie.getListeJoueurs().get(1).getScore().getScore() );
		//System.out.println("score du joueur " + partie.getListeJoueurs().get(2).getNom() + " : " + partie.getListeJoueurs().get(2).getScore().getScore() );
		//System.out.println("score du joueur " + partie.getListeJoueurs().get(3).getNom() + " : " + partie.getListeJoueurs().get(3).getScore().getScore() );
		if(partie.joueurGagant()!=null){
		System.out.println(partie.joueurGagant().getNom());
		} else {
			System.out.println("égalité!!");
		}
		System.out.println("fin du test");
	}
	

}
