package fr.ensma.ia.tp_IHM_memory.agentcartemvc;

public class ModeleCarte {

	private boolean carteVisible = false;
	private boolean horsPlateau = false;
	
	public boolean isCarteVisible() {
		return carteVisible;
	}
	public void setCarteVisible(boolean carteVisible) {
		this.carteVisible = carteVisible;
	}
	public boolean isHorsPlateau() {
		return horsPlateau;
	}
	public void setHorsPlateau(boolean horsPlateau) {
		this.horsPlateau = horsPlateau;
	}
	
}
