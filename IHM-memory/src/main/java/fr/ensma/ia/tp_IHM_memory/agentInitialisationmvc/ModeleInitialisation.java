package fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc;

import java.util.ArrayList;

import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.ModelePartie;

public class ModeleInitialisation {
	
	/**
	 * Reference du controleur de l'initialisation
	 */
	private ControleurInitialisation controleurInitialisation;
	
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
			listeNomJoueurs.set(i, (String) controleurInitialisation.getVueInitialisation().
					getTableauParamJoueurs().getTableauNouveauxJoueurs().getValueAt(i, 1));
		}
	}
	
	public void acquisitionListeIsIA() {
		listeIsIA = new ArrayList<Boolean>(nbJoueurs);
		for (int i=0 ; i<nbJoueurs ; i++) {
			listeIsIA.set(i, (Boolean) controleurInitialisation.getVueInitialisation().
					getTableauParamJoueurs().getTableauNouveauxJoueurs().getValueAt(i, 2));
		}
	}
	
	public void acquisitionListeNiveauIA() {
		listeNiveauIA = new ArrayList<String>(nbJoueurs);
		for (int i=0 ; i<nbJoueurs ; i++) {
			listeNiveauIA.set(i, (String) controleurInitialisation.getVueInitialisation().
					getTableauParamJoueurs().getTableauNouveauxJoueurs().getValueAt(i, 3));
		}
	}
}
