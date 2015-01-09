package fr.ensma.ia.tpmemomry.tpcpo1;

import java.util.ArrayList;
import java.util.HashSet;

import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.IEtatPartie;
import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.PairesRestantes;
import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.FinPartie;
import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.Joueur;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.*;

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
	 * Description of the property nbrTourJoue.
	 */
	private int nbrTourJoue = 0;

	/**
	 * Description of the property joueurJouant.
	 */
	private Joueur joueurJouant = null;

	// Start of user code (user defined attributes for Partie)

	// End of user code

	/**
	 * The constructor.
	 */
	public Partie() {
		// Start of user code constructor for Partie)
		super();
		// End of user code
	}

	
	public void paireCartesIdentiques() {
		
	}
	
	public void paireCartesDifferentes() {
		
	}
	/**
	 * Description of the method tour.
	 */
	public void tour() {
		// Start of user code for method tour
		// End of user code
	}

	// Start of user code (user defined methods for Partie)

	// End of user code
	/**
	 * Returns etatPartieEnCours.
	 * @return etatPartieEnCours 
	 */
	public PairesRestantes getEtatPartieEnCours() {
		return this.etatPartieEnCours;
	}

	/**
	 * Sets a value to attribute etatPartieEnCours. 
	 * @param newEtatPartieEnCours 
	 */
	public void setEtatPartieEnCours(PairesRestantes newEtatPartieEnCours) {
		this.etatPartieEnCours = newEtatPartieEnCours;
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
	 * Returns etatPartieCourrant.
	 * @return etatPartieCourrant 
	 */
	public IEtatPartie getEtatPartieCourrant() {
		return this.etatPartieCourrant;
	}

	/**
	 * Sets a value to attribute etatPartieCourrant. 
	 * @param newEtatPartieCourrant 
	 */
	public void setEtatPartieCourrant(IEtatPartie newEtatPartieCourrant) {
		this.etatPartieCourrant = newEtatPartieCourrant;
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
	 * Returns etatPartieFin.
	 * @return etatPartieFin 
	 */
	public FinPartie getEtatPartieFin() {
		return this.etatPartieFin;
	}

	/**
	 * Sets a value to attribute etatPartieFin. 
	 * @param newEtatPartieFin 
	 */
	public void setEtatPartieFin(FinPartie newEtatPartieFin) {
		this.etatPartieFin = newEtatPartieFin;
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

	/**
	 * Returns joueurJouant.
	 * @return joueurJouant 
	 */
	public Joueur getJoueurJouant() {
		return this.joueurJouant;
	}

	/**
	 * Sets a value to attribute joueurJouant. 
	 * @param newJoueurJouant 
	 */
	public void setJoueurJouant(Joueur newJoueurJouant) {
		this.joueurJouant = newJoueurJouant;
	}

	/**
	 * Returns etatPartieInitialisation.
	 * @return etatPartieInitialisation 
	 */
	public Initialisation getEtatPartieInitialisation() {
		return this.etatPartieInitialisation;
	}

	/**
	 * Sets a value to attribute etatPartieInitialisation. 
	 * @param newEtatPartieInitialisation 
	 */
	public void setEtatPartieInitialisation(
			Initialisation newEtatPartieInitialisation) {
		this.etatPartieInitialisation = newEtatPartieInitialisation;
	}

}
