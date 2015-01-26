package fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc;

import java.util.ArrayList;

import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.ModelePartie;
import fr.ensma.ia.tpmemomry.tpcpo1.Partie;

/**
 * Classe representant le modele de l'initialisation conformement a l'architecture MVC.</br>
 * 
 * @author clementdouault
 *
 */
public class ModeleInitialisation {
	
	/**
	 * Reference du controleur de l'initialisation
	 */
	private ControleurInitialisation controleurInitialisation;
	
	/**
	 * Reference du noyau fonctionnel
	 */
	private Partie nouvellePartie;
	
	/**
	 * Reference du modele de partie
	 */
	private ModelePartie modelePartie;
	
	/**
	 * Nombre de symboles differents
	 */
	private int nbSymboles;
	
	/**
	 * Nombre de paires par symbole
	 */
	private int nbPairesParSymbole;
	
	/**
	 * Booleen a true si la partie comporte des bonus, false sinon
	 */
	private boolean partieAvecBonus;
	
	/**
	 * Probabilite d'apparition des cartes bonus
	 */
	private int probabiliteBonus;
	
	/**
	 * Nombre total de joueurs
	 */
	private int nbJoueurs;
	
	/**
	 * Liste des noms des joueurs
	 */
	private ArrayList<String> listeNomJoueurs;
	
	/**
	 * Liste de booleen : a true si le joueur est une IA, false sinon
	 */
	private ArrayList<Boolean> listeIsIA;
	
	/**
	 * Liste du niveau des IA par joueur
	 */
	private ArrayList<String> listeNiveauIA;
	
	// -- CONSTRUCTEURS -- //
	
	/**
	 * Constructeur du modele de l'initialisation
	 */
	public ModeleInitialisation(){
		controleurInitialisation = new ControleurInitialisation(this);
	}

	// -- COMPORTEMENT -- //
	
	/**
	 * Methode acqerant tous les parametres rentrés par l'utilisateurs sur la vue.<br>
	 * Apres l'acquisition, la methode lance la creation de la partie correspondante.
	 */
	public void acquisitionParametres() {
		acquisitionNbSymboles();
		acquisitionNbPairesParSymbole();
		acquisitionProbaBonus();
		acquisitionNbJoueurs();
		acquisitionListeNomJoueurs();
		acquisitionListeIsIA();
		acquisitionListeNiveauIA();
		
		// creation de la partie avec les parametres acquis
		creationPartie();
	}
	
	/**
	 * Methode creant la partie en fonction des parametres acquis sur la vue
	 */
	public void creationPartie() {
		// instantiation de la partie personnalisee
		nouvellePartie = new Partie(nbSymboles, nbPairesParSymbole, partieAvecBonus, probabiliteBonus);
		
		// ajout des joueurs a la partie
		for(int i=0 ; i<nbJoueurs ; i++) {
			// si le joueur est humain
			if (!listeIsIA.get(i)) {
				nouvellePartie.ajoutJoueurHumain(listeNomJoueurs.get(i));
			} else {
				if (listeNiveauIA.get(i) == "Stupide") {
					nouvellePartie.ajoutJoueurIAStupide(listeNomJoueurs.get(i) + " (Stup.)");
				} else if (listeNiveauIA.get(i) == "Debutant"){
					nouvellePartie.ajoutJoueurIADebutant(listeNomJoueurs.get(i) + " (Debut.)");
				} else if (listeNiveauIA.get(i) == "Intermediaire") {
					nouvellePartie.ajoutJoueurIAIntermediaire(listeNomJoueurs.get(i) + " (Interm.)");
				} else if (listeNiveauIA.get(i) == "Expert") {
					nouvellePartie.ajoutJoueurIAExpert(listeNomJoueurs.get(i) + " (Expert)");
				}
			}
		}
		
		// instanciation du modele de la partie
		modelePartie = new ModelePartie(nouvellePartie);
	}
	
	// -- METHODES D'ACQUISITION -- //
	
	/**
	 * Acquiert le nombre de symboles
	 */
	public void acquisitionNbSymboles() {
		nbSymboles = Integer.parseInt(
				controleurInitialisation.getVueInitialisation().getTexteNbSymboles().getText());
	}

	/**
	 * Acquiert le nombre de paires par symbole
	 */
	public void acquisitionNbPairesParSymbole() {
		nbPairesParSymbole = Integer.parseInt(
				controleurInitialisation.getVueInitialisation().getTexteNbPaires().getText());
	}
	
	/**
	 * Acquiert les parametres lies aux cartes bonus. </br>
	 */
	public void acquisitionProbaBonus() {
		partieAvecBonus = controleurInitialisation.getVueInitialisation().
				getRadioAvecBonus().isSelected();
		
		if(partieAvecBonus) {
			probabiliteBonus = Integer.parseInt(
					controleurInitialisation.getVueInitialisation().getTexteProbaBonus().getText());
		} else {
			probabiliteBonus = 0;
		}
	}
	
	/**
	 * Calcule le nombre de joueurs
	 */
	public void acquisitionNbJoueurs() {
		nbJoueurs = controleurInitialisation.getVueInitialisation().
				getTableauParamJoueurs().getTableauNouveauxJoueurs().getRowCount();
	}
	
	/**
	 * Acquiert le nom des joueurs
	 */
	public void acquisitionListeNomJoueurs() {
		listeNomJoueurs = new ArrayList<String>(nbJoueurs);
		for (int i=0 ; i<nbJoueurs ; i++) {
			listeNomJoueurs.add((String) controleurInitialisation.getVueInitialisation().
					getTableauParamJoueurs().getTableauNouveauxJoueurs().getValueAt(i, 1));
		}
	}
	
	/**
	 * Acquiert si les joueurs sont des IA ou non
	 */
	public void acquisitionListeIsIA() {
		listeIsIA = new ArrayList<Boolean>(nbJoueurs);
		for (int i=0 ; i<nbJoueurs ; i++) {
			listeIsIA.add((Boolean) controleurInitialisation.getVueInitialisation().
					getTableauParamJoueurs().getTableauNouveauxJoueurs().getValueAt(i, 2));
		}
	}
	
	/**
	 * Acquiert le niveau de chaque IA
	 */
	public void acquisitionListeNiveauIA() {
		listeNiveauIA = new ArrayList<String>(nbJoueurs);
		for (int i=0 ; i<nbJoueurs ; i++) {
			listeNiveauIA.add((String) controleurInitialisation.getVueInitialisation().
					getTableauParamJoueurs().getTableauNouveauxJoueurs().getValueAt(i, 3));
		}
	}
}
