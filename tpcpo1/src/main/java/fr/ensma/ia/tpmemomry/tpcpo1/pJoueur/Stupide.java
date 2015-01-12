package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import java.util.Random;

import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.IA;
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;


/**
 * IA n'ayant pas compris les règles du jeu
 * selectionne au hasard des cartes
 * 
 * @author douaultc
 */
public class Stupide extends IA implements IJoueur{

	/**
	 * Constructeur a un parametre
	 * Cree une instance de Stupide
	 * @param p Plateau : la reference du plateau de jeu
	 */
	public Stupide(Plateau p) {
		super(p);
	}
	
	/**
	 * Constructeur a deux parametres
	 * Cree une instance de Stupide
	 * @param p Plateau : la reference du plateau de jeu
	 * @param nom String : le nom du joueur
	 */
	public Stupide(Plateau p,String nom) {
		super(p,nom);
	}
	
	/**
	 * donne le nom du joueur
	 * @return nom String : nom du joueur
	 */
	@Override
	public String getNom() {
		return nom;
	}
	
	/**
	 * modifie le nom du joueur
	 * @param nom String : le nom du jour
	 */
	@Override
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	/**
	 * donne le score du joueur
	 * @return score Score : la reference du score du joueur
	 */
	@Override
	public Score getScore() {
		return score;
	}
	
	/**
	 * lance la mise à jour du score du joueur avec un bonus eventuel
	 * @param bonus int : le bonus de score
	 */
	@Override
	public void updateScore(int bonus) {
		score.updateScore(nbrPairesTrouvees, bonus);
		
	}
	
	/**
	 * selectionne deux cartes au hasard sur le plateau
	 */
	@Override
	public void jouer() {
		Random r = new Random();
		int select1 = 0,select2=0;
		boolean jeu=false;
		while(jeu==false){
			jeu=true;
			select1=r.nextInt(plateau.getListeCartesMelangees().size());
			if(plateau.getListeCartesMelangees().get(select1).getSurPlateau()==false) jeu =false;
		}
		jeu=false;
		while(jeu==false){
			jeu=true;
			select2=r.nextInt(plateau.getListeCartesMelangees().size());
			if((plateau.getListeCartesMelangees().get(select2).getSurPlateau()==false)) jeu =false;
			if (select1==select2) jeu=false;
		}

		plateau.setCarte1(plateau.getListeCartesMelangees().get(select1));

		plateau.setCarte2(plateau.getListeCartesMelangees().get(select2));
	}

	/**
	 * traitement du tour perdu du joueur
	 */
	@Override
	public void tourPerdu() {
		this.nbrPairesTrouvees=0;
		
	}

	/**
	 * traitement du tour gagné du joueur
	 * @param effetCarte int : le bonus donne par la paire trouvee
	 */
	@Override
	public void tourGagne(int effetCarte) {
		this.score.updateScore(nbrPairesTrouvees, effetCarte);
		
	}
}
