package fr.ensma.ia.tp_IHM_memory.agentpartiemvc;

import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.pEtatPartie.FinPartie;
import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.pEtatPartie.IEtatPartie;
import fr.ensma.ia.tp_IHM_memory.agentpartiemvc.pEtatPartie.PartieEnCours;

public class ControleurPartie {

	private ModelePartie modelePartie;
	
	private VuePartie vuePartie;
	
	private IEtatPartie	etatCourantPartie;

	private IEtatPartie partieEnCours = new PartieEnCours(this);
	
	private IEtatPartie finPartie = new FinPartie(this);
	
	public ControleurPartie(ModelePartie modelePartie) {
		this.modelePartie = modelePartie;
		vuePartie = new VuePartie(modelePartie, this);
	}
	
	// -- GESTION DES ETATS DE L'AUTOMATE -- //
	
	public IEtatPartie getEtatCourantPartie() {
		return etatCourantPartie;
	}

	public void setEtatCourantPartie(IEtatPartie etatCourantPartie) {
		this.etatCourantPartie = etatCourantPartie;
	}

	public IEtatPartie getPartieEnCours() {
		return partieEnCours;
	}

	public IEtatPartie getFinPartie() {
		return finPartie;
	}
}
