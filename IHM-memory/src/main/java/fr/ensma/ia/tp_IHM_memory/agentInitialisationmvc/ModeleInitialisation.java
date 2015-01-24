package fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc;

import fr.ensma.ia.tp_IHM_memory.Personnalisation.ModelePersonnalisation;
import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.ModelePartie;

public class ModeleInitialisation {
	
	ControleurInitialisation controleur;
	
	public ModeleInitialisation(){
		controleur = new ControleurInitialisation(this);
	}

	public void partieClassique() {
		ModelePartie nouvellePartie = new ModelePartie();
		
	}

	public void partiePerso() {
	ModelePersonnalisation personnalisation = new ModelePersonnalisation();
		
	}

}
