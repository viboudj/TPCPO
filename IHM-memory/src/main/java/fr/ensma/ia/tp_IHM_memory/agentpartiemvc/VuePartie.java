package fr.ensma.ia.tp_IHM_memory.agentpartiemvc;

import javax.swing.JFrame;

public class VuePartie extends JFrame {

	private ModelePartie modelePartie;
	
	private ControleurPartie controleurPartie;
	
	public VuePartie(ModelePartie modelePartie, ControleurPartie controleurPartie) {
		this.modelePartie = modelePartie;
		this.controleurPartie = controleurPartie;
		
		
	}
	
}
