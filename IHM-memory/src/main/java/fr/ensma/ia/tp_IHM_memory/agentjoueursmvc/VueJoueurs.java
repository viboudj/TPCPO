package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc;

import java.awt.Container;
import javax.swing.*;
import fr.ensma.ia.tpmemomry.tpcpo1.Partie;



public class VueJoueurs extends Container {

	private ModeleJoueurs modele;
	private ControlleurJoueurs controlleur;
	
	
	
	public VueJoueurs(ModeleJoueurs modele,ControlleurJoueurs controlleur) {
		
		JScrollPane tabScr = new JScrollPane();
		JTable tab = new JTable(modele.getNbrJoueur(),3);
		
		tab.getColumnModel().getColumn(0).setHeaderValue("Nom des joueurs");
		tab.getColumnModel().getColumn(1).setHeaderValue("Score des joueurs");
		tab.getColumnModel().getColumn(2).setHeaderValue("Nombre de paires trouvées");

		
		for(int i=0; i<modele.getNbrJoueur() ;i++ ){
			tab.setValueAt(modele.getListeJoueur().get(i).getNom(), i+1, 1);
			tab.setValueAt(modele.getListeJoueur().get(i).getScore().getScore(), i+1, 2);
			tab.setValueAt(modele.getListeJoueur().get(i).getNbrPairesTrouvees(), i+1, 3);
		}
		
		
		this.add(tabScr);
	}
	

}
