package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.agentjoueurcourant;

import fr.ensma.ia.tpmemomry.tpcpo1.Partie;
import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.IJoueur;

public class ModeleJoueurCourant {
	
	private Partie noyauFonctionnel;
	
	private ControleurJoueurCourant controleur;
	
	private String nomCourant;
	
	private int scoreCourant;
	
	private int serieCourante;

	public ModeleJoueurCourant(Partie noyau) {
		noyauFonctionnel = noyau;
		
		controleur = new ControleurJoueurCourant(this);
	}

	public String getNomCourant() {
		return nomCourant;
	}
	
	public int getScoreCourant() {
		return scoreCourant;
	}
	
	public int getSerieCourante() {
		return serieCourante;
	}
	
	public void updateNomCourant() {
		nomCourant = noyauFonctionnel.getJoueurCourant().getNom();
	}

	public void updateScoreCourant() {
		scoreCourant = noyauFonctionnel.getJoueurCourant().getScore().getScore();
	}

	public void updateSerieCourante() {
		serieCourante = noyauFonctionnel.getJoueurCourant().getNbrPairesSuccessives();
	}
	
	public void update() {
		updateNomCourant();
		updateScoreCourant();
		updateSerieCourante();
		
	}
	
	
}