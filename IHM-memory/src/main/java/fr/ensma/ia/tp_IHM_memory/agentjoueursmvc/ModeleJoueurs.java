package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc;

import java.util.ArrayList;

import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.IObserverPartie;
import fr.ensma.ia.tpmemomry.tpcpo1.Partie;
import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.*;

public class ModeleJoueurs implements IObserverPartie {
	
	/**
	 * Reference du noyau fonctionnel
	 */
	private Partie noyauFonctionnel;
	
	private ControleurJoueurs controleurJoueurs;
	
	private int nbJoueurs;
	
	private ArrayList<String> listeNomJoueurs;
	
	private ArrayList<Integer> listeScoreJoueurs;

	private ArrayList<Integer> listePairesTrouvees;

	
	public ModeleJoueurs(Partie noyauFonctionnel){
		this.noyauFonctionnel=noyauFonctionnel;
		controleurJoueurs = new ControleurJoueurs(this);
		
		
		nbJoueurs = noyauFonctionnel.getListeJoueurs().size();
		listeNomJoueurs = new ArrayList<String>(nbJoueurs);
		listeScoreJoueurs = new ArrayList<Integer>(nbJoueurs);
		listePairesTrouvees = new ArrayList<Integer>(nbJoueurs);
		// initialisation des infos des joueurs
		updateListeNomJoueurs();
		updateListeScore();
		updateListePaires();
	}
	
	// -- OBSERVATION DE LA PARTIE -- //
	
	public void updateJoueurs() {
		updateListeNomJoueurs();
		updateListeScore();
		updateListePaires();
		controleurJoueurs.updateVue();
	}
	
	public void updateListeNomJoueurs() {
		for(int i=0 ; i<nbJoueurs ; i++) {
			listeNomJoueurs.add(noyauFonctionnel.getListeJoueurs().get(i).getNom()); 
		}
	}
	
	public void updateListeScore() {
		for(int i=0 ; i<nbJoueurs ; i++) {
			listeScoreJoueurs.add(noyauFonctionnel.getListeJoueurs().get(i).getScore().getScore()); 
		}	
	}
	
	public void updateListePaires() {
		for(int i=0 ; i<nbJoueurs ; i++) {
			listePairesTrouvees.add(noyauFonctionnel.getListeJoueurs().get(i).getNbrPairesTrouvees()); 
		}
	}
	
	// -- ACCESSEURS -- //
	
	public int getNbJoueurs(){
		return nbJoueurs;
	}

	public ArrayList<String> getListeNomJoueurs() {
		return listeNomJoueurs;
	}

	public ArrayList<Integer> getListeScoreJoueurs() {
		return listeScoreJoueurs;
	}

	public ArrayList<Integer> getListePairesTrouvees() {
		return listePairesTrouvees;
	}
	
	public VueJoueurs getVueJoueurs() {
		return controleurJoueurs.getVueJoueurs();
	}
}
