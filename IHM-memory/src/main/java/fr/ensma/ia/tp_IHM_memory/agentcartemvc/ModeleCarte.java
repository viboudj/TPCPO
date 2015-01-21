package fr.ensma.ia.tp_IHM_memory.agentcartemvc;

import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JButton;

import fr.ensma.ia.tp_IHM_memory.agentplateaumvc.IObserverPlateau;

/**
 * Classe representant le modele d'une carte conformement a l'architecture MVC.</br>
 * Implemente IObserverPlateau pour etre informe des evolutions du jeu par le plateau.
 * 
 * @author clementdouault
 *
 */
public class ModeleCarte implements IObserverPlateau {

	/**
	 * Booleen a vrai si la carte est face visible, faux sinon
	 */
	private boolean carteVisible = false;
	
	/**
	 * Booleen a vrai si la carte a ete retiree du plateau, faux sinon
	 */
	private boolean horsPlateau = false;
	
	/**
	 * Le symbole de la carte permettant a la vue d'obtenir la reference de l'icone de carte.
	 */
	private String symboleCarte;
	
	/**
	 * Le bonus de la carte permettant a la vue d'obtenir la reference de l'icone de carte. 
	 * Vaut "" si la carte n'a pas de bonus.
	 */
	private String bonusCarte;
	
	/**
	 * Reference du controleur de la carte
	 */
	private ControleurCarte controleurCarte;
	
	/**
	 * Liste des observateurs de la carte
	 */
	private ArrayList<IObserverCarte> listeObservateurs;
	
	// -- CONSTRUCTEUR -- //
	
	/**
	 * Constructeur du modele d'une carte.
	 * @param symboleCarte String : le symbole de la carte
	 * @param bonusCarte String : le bonus de la carte (vaut "" si la carte n'a pas de bonus)
	 */
	public ModeleCarte(String symboleCarte, String bonusCarte) {
		this.symboleCarte = symboleCarte;
		this.bonusCarte = bonusCarte;
		controleurCarte = new ControleurCarte(this);
		}
	
	// -- OBSERVATION DU PLATEAU -- //
	
	public void updateVisibiliteCarte(boolean horsPlateau) {
		this.horsPlateau = horsPlateau;
		if (horsPlateau) {
			controleurCarte.getEtatCourantCarte().carteHorsPlateau();
		}
		else {
			carteVisible = false;
			controleurCarte.getEtatCourantCarte().carteCachee();
		}
	}
	
	// -- GESTION DES OBSERVATEURS DE LA CARTE -- //
	
	/**
	 * Ajoute un observateur a la liste des observateurs de la carte
	 * @param observer IObserverCarte : le nouvel observateur
	 */
	public void addObserverCarte(IObserverCarte observer) {
		listeObservateurs.add(observer);
	}
	
	/**
	 * Supprime un observateur de la liste des observateurs de la carte
	 * @param observer IObserverCarte : l'observateur a supprimer
	 */
	public void removeObserverCarte(IObserverCarte observer) {
		listeObservateurs.remove(observer);
	}
	
	/**
	 * Informe l'ensemble des observateurs de la carte que celle-ci a ete cliquee
	 */
	public void notifierClic() {
		carteVisible = true;
		
		ListIterator<IObserverCarte> iterator = listeObservateurs.listIterator();
		while(iterator.hasNext()) {
			iterator.next().notificationClic(this);
		}
	}
	
	// -- ACCESSEURS -- //
	
	/**
	 * Obtient le symbole de la carte
	 * @return symboleCarte String : le symbole de la carte
	 */
	public String getSymboleCarte() {
		return symboleCarte;
	}
	
	/**
	 * Obtient le bonus de la carte
	 * @return bonusCarte String : le bonus de la carte
	 */
	public String getBonusCarte() {
		return bonusCarte;
	}
	
	/**
	 * Obtient la visibilite de la carte sur le plateau
	 * @return carteVisible boolean : vrai si carte face visible, faux sinon
	 */
	public boolean isCarteVisible() {
		return carteVisible;
	}
	
	/**
	 * Modifie la visibilite de la carte sur le plateau
	 * @param carteVisible boolean : la nouvelle visibilite
	 */
	public void setCarteVisible(boolean carteVisible) {
		this.carteVisible = carteVisible;
	}
	
	/**
	 * Obtient la visibilite de la carte dans la partie
	 * @return horsPlateau boolean : vrai si la carte a ete retiree du plateau, faux sinon
	 */
	public boolean isHorsPlateau() {
		return horsPlateau;
	}
	
	/**
	 * Modifie la visibilite de la carte dans la partie
	 * @param horsPlateau boolean : la nouvelle visibilite
	 */
	public void setHorsPlateau(boolean horsPlateau) {
		this.horsPlateau = horsPlateau;
	}
	
	/**
	 * Obtient la reference de la vue de l'agent carte
	 * @return vueCarte JButton : la vue de l'agent carte
	 */
	public JButton getVueCarte() {
		return controleurCarte.getVueCarte();
	}
	
}
