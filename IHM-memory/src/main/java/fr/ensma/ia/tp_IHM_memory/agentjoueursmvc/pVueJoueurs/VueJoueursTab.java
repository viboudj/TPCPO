package fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.pVueJoueurs;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.Scrollbar;

import javax.swing.*;

import fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.ControleurJoueurs;
import fr.ensma.ia.tp_IHM_memory.agentjoueursmvc.ModeleJoueurs;
import fr.ensma.ia.tpmemomry.tpcpo1.Partie;



@SuppressWarnings("serial")
public class VueJoueursTab extends Container {


	private static final long serialVersionUID = 2735275662418859263L;
	private ModeleJoueurs modele;
	private ControleurJoueurs controleur;
	
	
	
	public VueJoueursTab(ModeleJoueurs modele,ControleurJoueurs controlleur) {
		
		this.setLayout(new BorderLayout());
		this.setVisible(true);


		JTable tab = new JTable(modele.getNbrJoueur(),3);
		
		

		tab.getColumnModel().getColumn(0).setHeaderValue("Nom des joueurs");
		tab.getColumnModel().getColumn(1).setHeaderValue("Score des joueurs");
		tab.getColumnModel().getColumn(2).setHeaderValue("Nombre de paires trouvées");
		
		
		for(int i=0; i<modele.getNbrJoueur() ;i++ ){
			tab.setValueAt(modele.getListeJoueur().get(i).getNom(), i, 0);
			tab.setValueAt(modele.getListeJoueur().get(i).getScore().getScore(), i, 1);
			tab.setValueAt(modele.getListeJoueur().get(i).getNbrPairesTrouvees(), i, 2);
		}
		
		this.add(tab, BorderLayout.CENTER);
		this.add(tab.getTableHeader(), BorderLayout.NORTH);
				
	}



	public ModeleJoueurs getModele() {
		return modele;
	}



	public void setModele(ModeleJoueurs modele) {
		this.modele = modele;
	}



	public ControleurJoueurs getControleur() {
		return controleur;
	}



	public void setControleur(ControleurJoueurs controleur) {
		this.controleur = controleur;
	}
	

}
