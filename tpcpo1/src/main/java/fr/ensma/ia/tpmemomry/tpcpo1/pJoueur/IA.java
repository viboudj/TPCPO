package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import java.util.ArrayList;
import java.util.Random;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte.ICarte;

/**
 * Description of IA.
 * Classe mère des différentes IA
 * @author douaultc
 */
public abstract class IA {
	
	/**
	 * nombre d'IA iplémentées
	 */
	private static int numInstance = 0;
	
	/**
	 * nom de l'IA
	 */	
	protected String nom;
	
	/**
	 * score de l'IA
	 */
	protected Score score;
	
	/**
	 * Connaissance du plateau par l'IA 
	 */
	protected Plateau plateau;
	
	/**
	 * Premiere carte selectionnee par l'IA
	 */
	protected ICarte carte1;
	
	/**
	 * Deuxieme carte selectionnee par l'IA
	 */
	protected ICarte carte2;
	
	/**
	 * Nombre maximal de cartes que peut memoriser l'IA
	 */
	protected int capaciteMemoire;
	
	/**
	 * Liste des cartes memorisees.</br>
	 * Pas de redondance dans les cartes memorisees
	 */
	protected ArrayList<ICarte> cartesEnMemoire;
	
	/**
	 * Nombre de paires trouvees successivement dans un meme tour
	 */
	protected int nbrPairesSuccessives = 0;
	
	/**
	 * Nombre total de paires trouvees par le joueur
	 */
	protected int nbrPairesTrouvees = 0;

	// -- CONSTRUCTEURS -- //
	
	/**
	 * Constructeur a un parametre
	 * @param p Plateau : la reference du plateau
	 */
	public IA(Plateau p) {
		super();
		numInstance++;
		nom = "IA " + numInstance;
		score = new Score();
		plateau=p;
	}
	
	/**
	 * Constructeur a deux parametres
	 * @param p Plateau : la reference du plateau
	 * @param nom String : le nmo du joueur
	 */
	public IA(Plateau p,String nom) {
		super();
		numInstance++;
		this.nom=nom;
		score = new Score();
		plateau=p;
	}
	

	// -- COMPORTEMENT -- //
	
	/**
	 * Mise a jour de la memoire des IA.</br>
	 * Mise en memoire des cartes jouees ce tour en faisant attention a la redondance
	 */
	public void majMemoireIA() {
		System.out.print("debut maj memoire\n");
		// verification que les cartes memorisee sont sur le plateau, on les enleve de la memoire sinon
		for (int i=0 ; i<cartesEnMemoire.size() ; i++) {
			if (cartesEnMemoire.get(i).getSurPlateau() == false) {
				cartesEnMemoire.remove(i);
			}
		}
		
		// mise en memoire des deux cartes selectionnees le tour precedent
		// verification que les deux cartes selectionnees soient toujours sur le plateau
		// verification que les cartes ne soient pas deja en memoire (pas de redondance)
		// si memoire pleine, suppression de la plus ancienne carte (indice=0) puis ajout a la fin
		if(plateau.getCarte1().getSurPlateau() == true && 
				cartesEnMemoire.indexOf(plateau.getCarte1()) == -1) {
				if (cartesEnMemoire.size() == capaciteMemoire) {
					cartesEnMemoire.remove(0);
				}
				cartesEnMemoire.add(plateau.getCarte1());
		}
		if(plateau.getCarte2().getSurPlateau() == true && 
				cartesEnMemoire.indexOf(plateau.getCarte2()) == -1) {
				if(cartesEnMemoire.size() == capaciteMemoire) {
					cartesEnMemoire.remove(0);
				}
				cartesEnMemoire.add(plateau.getCarte2());
		}	
		System.out.print("fin maj memoire : \n");
		for(int i=0 ; i<cartesEnMemoire.size() ; i++) {
			System.out.println(cartesEnMemoire.get(i).getSymbole() + " " + 
		cartesEnMemoire.get(i).getBonusCarte() +"\n");
		}
	}
	
	/**
	 * Deroulement du phase de jeu d'une IA.</br>
	 * Selection des deux cartes en fonction des cartes en memoire
	 */
	public void jouer() {
		// liste servant a retenir les cartes potentiellement selectionnables
		ArrayList<ICarte> listeCartesPossibles = new ArrayList<ICarte>();
		// sert a choisir une carte aleatoirement parmis celles selectionnables
		Random random = new Random();
		// deux compteurs de boucle
		int compteurI = 0;
		int compteurJ = 0;
		// booleen a true si les 2 cartes ont ete selectionnees, false sinon
		boolean comparateur = false;
		
		// verification si deux cartes en memoire sont identiques
		// si oui, on selectionne ces deux cartes
		while(!comparateur && compteurI<cartesEnMemoire.size()) {
			while (!comparateur && compteurJ<cartesEnMemoire.size()) {
				if (compteurI != compteurJ) {
					if(comparerCartes(cartesEnMemoire.get(compteurI), 
							cartesEnMemoire.get(compteurJ))) {
						carte1 = cartesEnMemoire.get(compteurI);
						carte2 = cartesEnMemoire.get(compteurJ);
						comparateur = true;
					}
				}
				compteurJ++;
			}
			compteurI++;
		}
		
		// selection d'une carte au hasard sur le plateau qui ne soit pas en memoire
		// puis comparaison avec celles en memoire
		if(!comparateur) {
			// enregistrement de la position des cartes pouvant etre selectionnees
			for (int i=0 ; i<plateau.getListeCartesMelangees().size() ; i++) {
				if (plateau.getListeCartesMelangees().get(i).getSurPlateau() == true &&
						cartesEnMemoire.indexOf(plateau.getListeCartesMelangees().get(i)) == -1) {
					listeCartesPossibles.add(plateau.getListeCartesMelangees().get(i));
				}
			}
			// choix d'une position aleatoire dans la liste des cartes possibles 
			// puis selection de la carte correspondante
			carte1 =listeCartesPossibles.get(random.nextInt(listeCartesPossibles.size()));
			
			// comparaison de la carte selectionnee avec celles en memoire
			// si un match est trouve, selection de la deuxieme carte
			for(int i=0 ; i<cartesEnMemoire.size() ; i++) {
				if(comparerCartes(carte1, cartesEnMemoire.get(i))) {
					carte2 = cartesEnMemoire.get(i);
					comparateur = true;
				}
			}
		}
		
		// si aucun match n'est trouve avec une carte en memoire, choix de la seconde carte aleatoirement
		if(!comparateur) {
			// suppression de la premiere carte selectionne de la liste des cartes possibles
			listeCartesPossibles.remove(carte1);
			
			carte2 = listeCartesPossibles.get(random.nextInt(listeCartesPossibles.size()));
		}
		plateau.setCartesSelectionnees(true);
	}
	
	/**
	 * Retourne true si les deux cartes sont identiques, false sinon
	 * @param carte1 ICarte : la premiere carte a comparer
	 * @param carte2 ICarte : la seconde carte a comparer
	 * @return
	 */
	public boolean comparerCartes(ICarte carte1, ICarte carte2) {
		if(carte1.getSymbole() == carte2.getSymbole() &&
				carte1.getBonusCarte() == carte2.getBonusCarte()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Obtient la reference de la premiere carte selectionnee par l'IA
	 * @return carte1 ICarte : la premiere carte selectionnee par l'IA
	 */
	public ICarte getCarte1() {
		return carte1;
	}

	/**
	 * Obtient la reference de la deuxieme carte selectionnee par l'IA
	 * @return carte2 ICarte : la deuxieme carte selectionnee par l'IA
	 */
	public ICarte getCarte2() {
		return carte2;
	}
	
	/**
	 * Effectue les actions correspondantes si le joueur n'a pas trouve de paire
	 */
	public void tourPerdu() {
		nbrPairesSuccessives = 0;		
	}

	/**
	 * Effectue les actions correspondantes si le joueur a trouve une paire
	 * @param effetCarte int : le bonus donne par la paire trouvee
	 */
	public void tourGagne(int effetCarte) {
		this.score.updateScore(nbrPairesSuccessives, effetCarte);	
		nbrPairesSuccessives++;
		nbrPairesTrouvees++;
	}
	
	// -- ACCESSEURS -- //

	/**
	 * donne le nom du joueur
	 * @return nom String : nom du joueur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * modifie le nom du joueur
	 * @param nom String : le nom du jour
	 */
	public void setNom(String nom) {
		this.nom=nom;
	}

	/**
	 * Obtient le nombre de paires successives trouvee lors d'un meme tour
	 * @return nbrPairesSuccessives int : le nombre de paires successives
	 */
	public int getNbrPairesSuccessives() {
		return nbrPairesSuccessives;
	}
	
	/**
	 * Obtient le nombre total de paires trouvees par le joueur
	 * @return nbrPairesTrouvees int : le nombren total de paires trouvees
	 */
	public int getNbrPairesTrouvees() {
		return nbrPairesTrouvees;
	}

	/**
	 * donne le score du joueur
	 * @return score Score : la reference du score du joueur
	 */
	public Score getScore() {
		return score;
	}
}
