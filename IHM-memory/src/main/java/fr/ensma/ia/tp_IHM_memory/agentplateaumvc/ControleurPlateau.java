package fr.ensma.ia.tp_IHM_memory.agentplateaumvc;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.ModeleCarte;
import fr.ensma.ia.tp_IHM_memory.agentplateaumvc.etatplateau.DeuxCartesSelectionnees;
import fr.ensma.ia.tp_IHM_memory.agentplateaumvc.etatplateau.IEtatPlateau;
import fr.ensma.ia.tp_IHM_memory.agentplateaumvc.etatplateau.PasCarteSelectionnee;
import fr.ensma.ia.tp_IHM_memory.agentplateaumvc.etatplateau.UneCarteSelectionnee;

/**
 * Classe representant le controleur d'un plateau conformement a l'architecture MVC.</br>
 * Automate gerant les differents etats du plateau.
 * 
 * @author clementdouault
 *
 */
public class ControleurPlateau {
	
	/**
	 * Reference du modele du plateau
	 */
	private ModelePlateau modelePlateau;
	
	/**
	 * Reference de la vue du plateau
	 */
	private VuePlateau vuePlateau;
	
	/**
	 * Etat courant du plateau
	 */
	private IEtatPlateau etatCourantPlateau;

	/**
	 * Instance de l'etat PasCarteSelectionnee
	 */
	private IEtatPlateau pasCarteSelectionnee = new PasCarteSelectionnee(this);
	
	/**
	 * Instance de l'etat UneCarteSelectionnee
	 */
	private IEtatPlateau uneCarteSelectionnee = new UneCarteSelectionnee(this);

	/**
	 * Instance de l'etat DeuxCartesSelectionnees
	 */
	private IEtatPlateau deuxCartesSelectionnees = new DeuxCartesSelectionnees(this);

	/**
	 * Constructeur du controleur du plateau
	 * @param modelePlateau ModelePlateau : la reference du modele du plateau
	 */
	public ControleurPlateau(ModelePlateau modelePlateau){
		this.modelePlateau=modelePlateau;
		vuePlateau = new VuePlateau(modelePlateau, this);
		
	}
	
	// -- COMPORTEMENT -- //
	
	/**
	 * Demande au modele d'enregistrer la carte comme premiere carte selectionnee
	 * @param carte1 ModeleCarte : la premiere carte selectionnee
	 */
	public void carte1Selectionnee(ModeleCarte carte1) {
		modelePlateau.setCarte1(carte1);
	}
	
	/**
	 * Demande au modele d'enregistrer la carte comme seconde carte selectionnee
	 * @param carte2 ModeleCarte : la seconde carte selectionnee
	 */
	public void carte2Selectionnee(ModeleCarte carte2) {
		modelePlateau.setCarte2(carte2);
	}
	
	/**
	 * Demande au modele de comparer les deux cartes selectionnees
	 */
	public void comparerCartes() {
		modelePlateau.compareCartes();
	}

	// -- ACCESSEURS -- //
	
	/**
	 * Obtient la reference de la vue du plateau
	 * @return vuePlateau VuePlateau : la vue du plateau
	 */
	public VuePlateau getVuePlateau() {
		return vuePlateau;
	}
	
	// -- GESTION DES ETATS DE L'AUTOMATE -- //
	
	/**
	 * Obtient l'etat courant du plateau
	 * @return etatCourantPlateau IEtatPlateau : l'etat courant du plateau
	 */
	public IEtatPlateau getEtatCourantPlateau() {
		return etatCourantPlateau;
	}

	/**
	 * Modifie l'etat courant du plateau
	 * @param etatCourantPlateau IEtatPlateau : le nouvel etat courant du plateau
	 */
	public void setEtatCourantPlateau(IEtatPlateau etatCourantPlateau) {
		this.etatCourantPlateau = etatCourantPlateau;
	}
	
	/**
	 * Obtient l'instance de l'etat PasCarteSelectionnee
	 * @return pasCarteSelectionnee IEtatPlateau
	 */
	public IEtatPlateau getPasCarteSelectionnee() {
		return pasCarteSelectionnee;
	}

	/**
	 * Obtient l'instance de l'etat UneCarteSelectionnee
	 * @return uneCarteSelectionnee IEtatPlateau
	 */
	public IEtatPlateau getUneCarteSelectionnee() {
		return uneCarteSelectionnee;
	}

	/**
	 * Obtient l'instance de l'etat DeuxCartesSelectionnees
	 * @return deuxCartesSelectionnees IEtatPlateau
	 */
	public IEtatPlateau getDeuxCartesSelectionnees() {
		return deuxCartesSelectionnees;
	}
	
}
