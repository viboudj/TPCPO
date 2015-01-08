/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1;


import java.util.HashSet;
import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.IEtatPartie;
import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.Initialisation;
import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.PartieEnCours;
import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.PartieFin;
import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.Joueur;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.*;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Partie.
 * 
 * @author douaultc
 */
public class Partie {
	/**
	 * Description of the property etatPartieEnCours.
	 */
	private PartieEnCours etatPartieEnCours = null;

	/**
	 * Description of the property plateau.
	 */
	public Plateau plateau = null;

	/**
	 * Description of the property etatPartieCourrant.
	 */
	private IEtatPartie etatPartieCourrant = null;

	/**
	 * Description of the property nbrJoueur.
	 */
	private int nbrJoueur = 0;

	/**
	 * Description of the property etatPartieFin.
	 */
	private PartieFin etatPartieFin = null;

	/**
	 * Description of the property joueurs.
	 */
	public HashSet<Joueur> joueurs = new HashSet<Joueur>();

	/**
	 * Description of the property nbrTourJoue.
	 */
	private int nbrTourJoue = 0;

	/**
	 * Description of the property joueurJouant.
	 */
	private Joueur joueurJouant = null;

	/**
	 * Description of the property etatPartieInitialisation.
	 */
	private Initialisation etatPartieInitialisation = null;

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
	public PartieEnCours getEtatPartieEnCours() {
		return this.etatPartieEnCours;
	}

	/**
	 * Sets a value to attribute etatPartieEnCours. 
	 * @param newEtatPartieEnCours 
	 */
	public void setEtatPartieEnCours(PartieEnCours newEtatPartieEnCours) {
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
	public PartieFin getEtatPartieFin() {
		return this.etatPartieFin;
	}

	/**
	 * Sets a value to attribute etatPartieFin. 
	 * @param newEtatPartieFin 
	 */
	public void setEtatPartieFin(PartieFin newEtatPartieFin) {
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
