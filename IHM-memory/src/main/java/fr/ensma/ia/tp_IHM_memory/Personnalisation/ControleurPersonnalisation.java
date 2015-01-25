package fr.ensma.ia.tp_IHM_memory.Personnalisation;

import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.ModelePartie;

public class ControleurPersonnalisation {
	
	/**
	 * 
	 */
	private ModelePersonnalisation modele;
	
	private VuePersonnalisation vue;
	
	public ControleurPersonnalisation(ModelePersonnalisation modele) {
		this.modele=modele;
		this.vue= new VuePersonnalisation(modele, this);		
	}
	
	public void CreationPartie(int nbrSymb, int nbrPairesParSymb, boolean pairesBonus, int probabiliteBonus){
		modele.CreationPartie(nbrSymb, nbrPairesParSymb, pairesBonus, probabiliteBonus);
	}
	

	
	

}
