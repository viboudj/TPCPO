package fr.ensma.ia.tp_IHM_memory.agentplateaumvc;


public class ControleurPlateau {
	
	ModelePlateau modelePlateau;
	VuePlateau vuePlateau;
		
	public ControleurPlateau(ModelePlateau modelePlateau){
		this.modelePlateau=modelePlateau;
		vuePlateau = new VuePlateau(modelePlateau, this);
		
	}

}
