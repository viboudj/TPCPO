package fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc;

import fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc.vue.VueInitialisation;

public class ControleurInitialisation {
	
	private  ModeleInitialisation modele;
	
	private VueInitialisation vue;
	
	public ControleurInitialisation(ModeleInitialisation modele) {
		this.modele=modele;
		vue = new VueInitialisation(modele, this);
	}

	public void partieClassique() {
		modele.partieClassique();
		vue.getBoutonPartieClassique().setEnabled(false);
		vue.getFenetreInitialisation().setVisible(false);
	
		
	}

	public void partiePerso() {
		modele.partiePerso();
		vue.getBoutonPartieClassique().setEnabled(false);
		vue.getFenetreInitialisation().setVisible(false);
		
	}

}
