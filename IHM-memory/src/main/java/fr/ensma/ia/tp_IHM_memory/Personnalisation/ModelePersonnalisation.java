package fr.ensma.ia.tp_IHM_memory.Personnalisation;

import fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.ModeleJoueurs;
import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.ModelePartie;
import fr.ensma.ia.tpmemomry.tpcpo1.Partie;
import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.IJoueur;

public class ModelePersonnalisation {
	
	private ControleurPersonnalisation controleur;
	
	private Partie partie;
	
	private ModelePartie modelePartie;
	
	private ModeleJoueurs listeJoueur;

		
	public ModelePersonnalisation(){
		controleur=new ControleurPersonnalisation(this);
	}
	
	public void CreationPartie(int nbrSymb, int nbrPairesParSymb, boolean pairesBonus, int probabiliteBonus){
		 partie = new Partie( nbrSymb, nbrPairesParSymb, pairesBonus, probabiliteBonus);
	}
	
	public void lancementPartie(){
		modelePartie = (new ModelePartie(partie));
	}
	
	public void ajouterJoueursHumain(){
		partie.ajoutJoueurHumain();
		partie.setJoueurCourant(partie.getListeJoueurs().get(0));
	}
	
	public void ajouterJoueursHumain(String nom){
		partie.ajoutJoueurHumain(nom);
		partie.setJoueurCourant(partie.getListeJoueurs().get(0));
	}




}
