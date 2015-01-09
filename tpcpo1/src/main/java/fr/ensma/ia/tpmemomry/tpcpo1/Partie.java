package fr.ensma.ia.tpmemomry.tpcpo1;

import java.util.ArrayList;
import java.util.HashSet;

import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.IEtatPartie;
import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.PairesRestantes;
import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.FinPartie;
import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.Joueur;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.*;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.pEtatPlateau.IEtatPlateau;

/**
 * Classe modelisant une partie de memory
 * 
 * @author douaultc
 */
public class Partie {
	
	/**
	 * Nombre de joueurs jouant une partie
	 */
	private int nbrJoueur = 0;
	
	/**
	 * Liste des joueurs jouant une partie
	 */
	public ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	
	/**
	 * Joueur courant
	 */
	private Joueur joueurCourant;
	
	/**
	 * Compteur suivant le nombre de tours joues dans la partie
	 */
	private int nbrTourJoue = 0;
	
	/**
	 * Instances de l'Žtat pairesRestantes
	 */
	private IEtatPartie pairesRestantes;
	
	/**
	 * Instances de l'Žtat finPartie
	 */
	private IEtatPartie finPartie;
	
	/**
	 * Etat actuel de la partie
	 */
	private IEtatPartie etatCourantPartie;

	/**
	 * Description of the property plateau.
	 */
	public Plateau plateau = null;

	/**
	 * The constructor.
	 */
	public Partie() {
		super();
		
	}

	
	public void paireCartesIdentiques() {
		etatCourantPartie.paireTrouvee();
	}
	
	public void paireCartesDifferentes() {
		etatCourantPartie.pasPaireTrouvee();
	}

	/**
	 * Returns plateau.
	 * @return plateau 
	 */
	public Plateau getPlateau() {
		return this.plateau;
	}

	/**
	 * Sets a value to attribute plateau. 
	 * @param newPlateau 
	 */
	public void setPlateau(Plateau newPlateau) {
		this.plateau = newPlateau;
	}

	/**
	 * Returns nbrJoueur.
	 * @return nbrJoueur 
	 */
	public int getNbrJoueur() {
		return this.nbrJoueur;
	}

	/**
	 * Sets a value to attribute nbrJoueur. 
	 * @param newNbrJoueur 
	 */
	public void setNbrJoueur(int newNbrJoueur) {
		this.nbrJoueur = newNbrJoueur;
	}

	/**
	 * Returns joueurs.
	 * @return joueurs 
	 */
	public HashSet<Joueur> getJoueurs() {
		return this.joueurs;
	}

	/**
	 * Returns nbrTourJoue.
	 * @return nbrTourJoue 
	 */
	public int getNbrTourJoue() {
		return this.nbrTourJoue;
	}

	/**
	 * Sets a value to attribute nbrTourJoue. 
	 * @param newNbrTourJoue 
	 */
	public void setNbrTourJoue(int newNbrTourJoue) {
		this.nbrTourJoue = newNbrTourJoue;
	}

}
