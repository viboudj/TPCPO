package fr.ensma.ia.tp_IHM_memory.agentInitialisationmvc.vue;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class InitialisationJoueurs extends Container implements ActionListener {
	
	/**
	 * Tableau contenant les parametres relatifs aux joueurs
	 */
	private JTable tableauNouveauxJoueurs;
	
	/**
	 * Bouton pour ajouter automatiquement un joueur au tableau
	 */
    private JButton ajouter;
    
    /**
     * Bouton pour supprimer automatiquement le dernier joueur ajoute
     */
    private JButton supprimer;

	/**
	 * Tableau de String regroupant les 4 niveaux differents de l'IA
	 */
	private String[] niveauCPU = { "Stupide", "Intermediaire", "Difficile"};

	public InitialisationJoueurs() {
		setLayout(new BorderLayout());
		
		// Initialisation du tableau des donnees des joueurs
		//		4 colonnes : numero de joueur, nom, si IA ou non, et niveau de l'IA
		//		2 joueurs humain par defaut
		String nomColonne[] = { "Joueur", "Nom", "IA", "Niveau"};
		Object[][] donneesJoueurs = {
				{ "Joueur 1", "Humain1", new Boolean(false), niveauCPU[0]},
				{ "Joueur 2", "Humain2", new Boolean(false), niveauCPU[0]}
				};
		// ComboBox regroupant les 4 niveaux de l'IA
		JComboBox comboNiveauCPU = new JComboBox(niveauCPU);
		
		// Instantiation d'un modele de tableau pour la gestion des infos des joueurs
		TableauDynamique tableauDynamique = new TableauDynamique(donneesJoueurs, nomColonne);

		tableauNouveauxJoueurs = new JTable(tableauDynamique);
		tableauNouveauxJoueurs.setRowHeight(30);
		
		// Permet de visualiser correctement la ComboBox dans le tableau
		tableauNouveauxJoueurs.getColumn("Niveau").setCellEditor(new DefaultCellEditor(comboNiveauCPU));
		tableauNouveauxJoueurs.getColumn("Joueur").setPreferredWidth(100);
		tableauNouveauxJoueurs.getColumn("Nom").setPreferredWidth(100);
		tableauNouveauxJoueurs.getColumn("IA").setPreferredWidth(20);
		tableauNouveauxJoueurs.getColumn("Niveau").setPreferredWidth(85);

		add(new JScrollPane(tableauNouveauxJoueurs), BorderLayout.CENTER);
		
		// creation des boutons d'ajout et de suppression de lignes du tableau
		ajouter = new JButton("Ajouter");
		ajouter.setEnabled(true);
		ajouter.addActionListener(this);
		supprimer = new JButton("Supprimer");
		supprimer.addActionListener(this);
	    supprimer.setEnabled(true);
	      
	    // mise en commun des deux boutons et ajout au Container principal
		JPanel panelBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBoutons.add(ajouter);
		panelBoutons.add(supprimer);
		
	    add(panelBoutons, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(300, 200));
	}

	// -- OVERRIDE DES METHODES DES LISTENERS -- //
	

	public void actionPerformed(ActionEvent e) {
		// ajout d'un joueur par defaut dans le tableau si clic sur le bouton ajouter
		if (e.getSource() == ajouter) {
			Object[] nouveauJoueur = new Object[]
					{"Joueur " + (tableauNouveauxJoueurs.getRowCount()+1), 
					"Humain"+ (tableauNouveauxJoueurs.getRowCount()+1), 
					new Boolean(false), niveauCPU[0]};
			
			// Methode definie dans le modele TableauDynamique permettant l'ajout du joueur
			((TableauDynamique)tableauNouveauxJoueurs.getModel()).addRow(nouveauJoueur);
			
			// Activation de supprimer si desactivé
     		if (tableauNouveauxJoueurs.getRowCount()>=1) {
     			supprimer.setEnabled(true);
     		}
     		
    	// suppression du dernier joueur ajoute au tableau si clic sur le bouton supprimer
		} else if (e.getSource() == supprimer) {
			// Methode definie dans le modele TableauDynamique permettant la suppression du dernier joueur
			((TableauDynamique)tableauNouveauxJoueurs.getModel()).removeRow();
			
			// desactivation de supprimer si un seul joueur restant
			if (tableauNouveauxJoueurs.getRowCount() <= 1) {
				supprimer.setEnabled(false);
			}
		}
	}
	
	// -- ACCESSEURS -- //
	
	/**
	 * Obtient le tableau contenant les parametres des nouveaux joueurs
	 * @return tableauNouveauxJoueurs JTable : le tableau des nouveaux joueurs
	 */
	public JTable getTableauNouveauxJoueurs() {
		return tableauNouveauxJoueurs;
	}
	
	// -- DEFINITION DU MODELE DE TABLEAU -- //
	
	/**
	 * Classe represant un modele de tableau.</br>
	 * Permet notamment l'ajout et la suppression d'un joueur de facon dyanmique.
	 * 
	 * @author clementdouault
	 */
	class TableauDynamique extends AbstractTableModel {
		private Object[][] data;
		private String[] title;

		/**
		 * Constructeur permettant la creation d'un tableau contenant les "data" et organisé en colonnes "title"
		 * @param data Object[][] : les donnees contenues dans le tableau
		 * @param title String[] : le nom de chacun des colonnes du tableau
		 */
		public TableauDynamique(Object[][] data, String[] title) {
			this.data = data;
			this.title = title;
		}

		/**
		 * Retourne le titre de la colonne à l'indice spécifié
		 * @param col int : l'indice de la colonne
		 * @return String : le titre de la colonne
		 */
		public String getColumnName(int col) {
			return this.title[col];
		}

		/**
		 * Retourne le nombre de colonnes dont est compose le tableau
		 * @return nbColonne int : le nombre de colonnes du tableau
		 */
		public int getColumnCount() {
			return this.title.length;
		}

		/**
		 * Retourne le nombre de lignes dont est compose le tableau
		 * @return nbColonne int : le nombre de lignes du tableau
		 */
		public int getRowCount() {
			return this.data.length;
		}

		/**
		 * Retourne l'object contenu dans le tableau aux indices de ligne et de colonne specifies
		 * @param row int : l'indice de la ligne
		 * @param col int : l'indice de la colonne
		 * @return Object : l'objet contenu dans le tableau
		 */
		public Object getValueAt(int row, int col) {
			return this.data[row][col];
		}

		/**
		 * Modifie l'object contenu dans le tableau aux indices de ligne et de colonnes specifies
		 * par l'objet en parametres
		 * @param value Object : le nouvel objet
		 * @param row int : l'indice de la ligne
		 * @param col int : l'indice de la colonne
		 */
		public void setValueAt(Object value, int row, int col) {
			// Modification de la colonne joueur impossible
			if (!(this.getColumnName(col) == "Joueur")) {
				this.data[row][col] = value;
			}
		}

		/**
		 * Obtient la classe a laquelle appartienne les donnees contenues dans la colonne d'indice specifie
		 * @param col int : l'indice de la colone
		 * @Return Class : la classe des objets contenus dans la colonne
		 */
		public Class getColumnClass(int col) {
			// Les donnees d'une colonne etant du meme type d'une ligne a l'autre, 
			// on prend la premiere
			return this.data[0][col].getClass();
		}
		
		
		public boolean isCellEditable(int row, int col) {
			if (col == 0) {
				return false;
			}
			return true;
		}
		
		/**
		 * Methode permettant de supprimer la ligne d'indice specifie du tableau
		 * @param position int : l'indice de la ligne a supprimer
		 */
		public void removeRow(){
		    
			int nbRow = this.getRowCount()-1;
			int nbCol = this.getColumnCount();
		      
			Object temp[][] = new Object[nbRow][nbCol];
			for (int i=0 ; i<nbRow ;i++) {
				for(int j=0 ; j<nbCol ; j++) {
					temp[i][j] = data[i][j];
				}
			}
			this.data = temp;
			temp = null;
			this.fireTableDataChanged();
		}
		    
		/**
		 * Permet d'ajouter une ligne a la fin du tableau
		 * @param data Object : le tableau de donnee a ajouter
		 */
		public void addRow(Object[] data){
			int indice = 0, nbRow = this.getRowCount(), nbCol = this.getColumnCount();
       
			Object temp[][] = this.data;
			this.data = new Object[nbRow+1][nbCol];
			for (int i=0 ; i<nbRow ;i++) {
				for(int j=0 ; j<nbCol ; j++) {
					this.data[i][j] = temp[i][j];
				}
			}
      
			for (int i=0 ; i<nbCol ; i++) {
				this.data[nbRow][i] = data[i];
			}
			
			temp = null;
			this.fireTableDataChanged();
		}
	}
}