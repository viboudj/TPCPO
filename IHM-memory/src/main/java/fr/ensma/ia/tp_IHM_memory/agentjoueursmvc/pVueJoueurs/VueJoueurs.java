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
		
		JScrollPane tabScr = new JScrollPane(tab);
		tabScr.setSize(200, 200);
		

		tabScr.setVisible(true);
		tabScr.setSize(200, 200);
		tabScr.setViewportView(tab);


		this.add(tab, BorderLayout.CENTER);
	}

}
