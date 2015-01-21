package fr.ensma.ia.tp_IHM_memory.agentcartemvc;

import fr.ensma.ia.tp_IHM_memory.agentcartemvc.etatcarte.FaceCachee;
import fr.ensma.ia.tp_IHM_memory.agentcartemvc.etatcarte.FaceVisible;
import fr.ensma.ia.tp_IHM_memory.agentcartemvc.etatcarte.HorsPlateau;
import fr.ensma.ia.tp_IHM_memory.agentcartemvc.etatcarte.IEtatCarte;

public class ControleurCarte {
	
	private ModeleCarte modeleCarte;
	
	private VueCarte vueCarte;
	
	private IEtatCarte etatCourantCarte;
	
	private FaceCachee faceCachee = new FaceCachee(this);
	
	private FaceVisible faceVisible = new FaceVisible(this);
	
	private HorsPlateau horsPlateau = new HorsPlateau(this);

	// -- CONSTRUCTEUR -- //
	
	/**
	 * Constructeur du controleur de la carte
	 * @param modeleCarte
	 */
	public ControleurCarte(ModeleCarte modeleCarte) {
		this.modeleCarte = modeleCarte;
		vueCarte = new VueCarte(this, modeleCarte);
		
		// initialisation de l'automate gerant les etats de la carte
		etatCourantCarte = faceCachee;
	}
	
	// -- ACCESSEURS -- //
	
	/**
	 * Obtient la reference de la carte
	 * @return vueCarte VueCarte : la reference de la carte
	 */
	public VueCarte getVueCarte() {
		return vueCarte;
	}
	
	// -- GESTION DES ETATS DE L'AUTOMATE -- //
	
	public IEtatCarte getEtatCourantCarte() {
		return etatCourantCarte;
	}

	public void setEtatCourantCarte(IEtatCarte etatCourantCarte) {
		this.etatCourantCarte = etatCourantCarte;
	}

	public FaceCachee getFaceCachee() {
		return faceCachee;
	}

	public FaceVisible getFaceVisible() {
		return faceVisible;
	}

	public HorsPlateau getHorsPlateau() {
		return horsPlateau;
	}
}
