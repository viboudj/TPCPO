package fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc;

import java.util.ArrayList;
import java.util.ListIterator;

import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.ModelePartie;
import fr.ensma.ia.tpmemomry.tpcpo1.Partie;

public class ModeleInitialisation {
	
	/**
	 * Reference du controleur de l'initialisation
	 */
	private ControleurInitialisation controleurInitialisation;
	
	private Partie nouvellePartie;
	
	private ModelePartie modelePartie;
	
	private int nbSymbole;
	
	private int nbPairesParSymbole;
	
	private boolean partieAvecBonus;
	
	private int probabiliteBonus;
	
	private int nbJoueurs;
	
	private ArrayList<String> listeNomJoueurs;
	
	private ArrayList<Boolean> listeIsIA;
	
	private ArrayList<String> listeNiveauIA;
	
	/**
	 * Constructeur du modele de l'initialisation
	 */
	public ModeleInitialisation(){
		controleurInitialisation = new ControleurInitialisation(this);
	}
	
	public void creationPartie() {
		// instantiation de la partie personnalisee
		nouvellePartie = new Partie(nbSymbole, nbPairesParSymbole, partieAvecBonus, probabiliteBonus);
		
		// ajout des joueurs a la partie
		for(int i=0 ; i<nbJoueurs ; i++) {
			// si le joueur est humain
			if (!listeIsIA.get(i)) {
				nouvellePartie.ajoutJoueurHumain(listeNomJoueurs.get(i));
			} else {
				if (listeNiveauIA.get(i) == "Stupide") {
					nouvellePartie.ajoutJoueurIAStupide(listeNomJoueurs.get(i) + " (Stup.)");
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

	public void acquisitionParametres() {
		acquisitionNbSymboles();
		acquisitionNbPairesParSymbole();
		acquisitionProbaBonus();
		acquisitionNbJoueurs();
		acquisitionListeNomJoueurs();
		acquisitionListeIsIA();
		acquisitionListeNiveauIA();
		
		// creation de la partie avec les parametres acquis
		
	}
	
	public void acquisitionNbSymboles() {
		nbSymbole = Integer.parseInt(
				controleurInitialisation.getVueInitialisation().getTexteNbSymboles().getText());
	}

	public void acquisitionNbPairesParSymbole() {
		nbPairesParSymbole = Integer.parseInt(
				controleurInitialisation.getVueInitialisation().getTexteNbPaires().getText());
	}
	
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
	
	public void acquisitionNbJoueurs() {
		nbJoueurs = controleurInitialisation.getVueInitialisation().
				getTableauParamJoueurs().getTableauNouveauxJoueurs().getRowCount();
	}
	
	public void acquisitionListeNomJoueurs() {
		listeNomJoueurs = new ArrayList<String>(nbJoueurs);
		for (int i=0 ; i<nbJoueurs ; i++) {
			listeNomJoueurs.add((String) controleurInitialisation.getVueInitialisation().
					getTableauParamJoueurs().getTableauNouveauxJoueurs().getValueAt(i, 1));
		}
	}
	
	public void acquisitionListeIsIA() {
		listeIsIA = new ArrayList<Boolean>(nbJoueurs);
		for (int i=0 ; i<nbJoueurs ; i++) {
			listeIsIA.add((Boolean) controleurInitialisation.getVueInitialisation().
					getTableauParamJoueurs().getTableauNouveauxJoueurs().getValueAt(i, 2));
		}
	}
	
	public void acquisitionListeNiveauIA() {
		listeNiveauIA = new ArrayList<String>(nbJoueurs);
		for (int i=0 ; i<nbJoueurs ; i++) {
			listeNiveauIA.add((String) controleurInitialisation.getVueInitialisation().
					getTableauParamJoueurs().getTableauNouveauxJoueurs().getValueAt(i, 3));
		}
	}
}
