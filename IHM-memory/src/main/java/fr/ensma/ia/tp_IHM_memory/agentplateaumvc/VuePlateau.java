package fr.ensma.ia.tp_IHM_memory.agentplateaumvc;

public class VuePlateau {

	private ModelePlateau modelePlateau;
	
	private ControleurPlateau controleurPlateau;
	
	public VuePlateau(ModelePlateau modelePlateau, ControleurPlateau controleurPlateau) {
		this.modelePlateau = modelePlateau;
		this.controleurPlateau = controleurPlateau;
	}
	
}
