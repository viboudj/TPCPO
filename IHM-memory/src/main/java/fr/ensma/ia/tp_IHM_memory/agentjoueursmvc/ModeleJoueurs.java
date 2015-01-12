package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc;

import java.util.ArrayList;

import fr.ensma.ia.tpmemomry.tpcpo1.Partie;
import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.*;

public class ModeleJoueurs {
	
	Partie partie;
	
	public ModeleJoueurs(){
		
	}
	
	
	
	public int getNbrJoueur(){
		return partie.getNbrJoueurs();
	};





	public ArrayList<IJoueur> getListeJoueur(){
		return partie.listeJoueurs;
	};
	
	

}
