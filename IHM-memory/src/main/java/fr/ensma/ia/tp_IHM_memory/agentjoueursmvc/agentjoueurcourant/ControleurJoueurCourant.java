package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.agentjoueurcourant;

public class ControleurJoueurCourant {

	private ModeleJoueurCourant modele;
	
	private VueJoueurCourant vue;
	
	public ControleurJoueurCourant(ModeleJoueurCourant modele) {
		this.modele = modele;
		
		vue = new VueJoueurCourant(modele, this);
	}
	
	public void updateVue() {
		vue.refreshVue();
	}
	
}
