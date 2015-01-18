package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.pVueJoueurs;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JScrollPane;

import fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.ControleurJoueurs;
import fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.ModeleJoueurs;

public class VueJoueurs extends Container {
	
	private VueJoueursTab tab;
	
	public VueJoueurs(ModeleJoueurs modele,ControleurJoueurs controlleur){
		
		tab=new VueJoueursTab(modele, controlleur);
		
		this.setLayout(new BorderLayout());
		JScrollPane tabScr = new JScrollPane(tab);

		tabScr.setSize(50, 50);
		tabScr.setVisible(true);
		tabScr.setViewportView(tab);


		this.add(tabScr);
	}
	
	public ModeleJoueurs getModele(){
		return tab.getModele();
		}
	
	public ControleurJoueurs getControlleur(){
		return tab.getControleur();
	}
}
