package fr.ensma.ia.tp_IHM_memory.IHM_memory;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;

import javax.swing.JFrame;

import junit.framework.TestCase;
import fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.*;
import fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.pVueJoueurs.VueJoueurs;
import fr.ensma.ia.tpmemomry.tpcpo1.Partie;

public class TestVueJoueurs extends TestCase {
	
	public static void testJoueurs() throws InterruptedException{

		
		Partie p = new Partie();
		ModeleJoueurs modele =new ModeleJoueurs(p);
		ControleurJoueurs controlleur = new ControleurJoueurs();

		
		p.ajoutJoueurHumain();
		p.ajoutJoueurHumain("Léon");
		p.ajoutJoueurHumain("Jacque");
		p.ajoutJoueurHumain("Jean");

		VueJoueurs vue = new VueJoueurs(modele, controlleur);
		JFrame j = new JFrame("testVueJoueur");
		j.setSize(200, 200);
		Container C = j.getContentPane();
		C.add(vue);
		j.setVisible(true);
		
		Thread.sleep(10000);

		}

	
	
}
