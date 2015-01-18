package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc;

import fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.pVueJoueurs.VueJoueurs;

public class ControleurJoueurs {
	
	private ModeleJoueurs modele;
	private VueJoueurs vue;
	
	public ControleurJoueurs(ModeleJoueurs modele, VueJoueurs vue){
		this.setModele(modele);
		this.setVue(vue);
		
	}

	public ModeleJoueurs getModele() {
		return modele;
	}

	public void setModele(ModeleJoueurs modele) {
		this.modele = modele;
	}

	public VueJoueurs getVue() {
		return vue;
	}

	public void setVue(VueJoueurs vue) {
		this.vue = vue;
	}
	
	

}
