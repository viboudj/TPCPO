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
}
