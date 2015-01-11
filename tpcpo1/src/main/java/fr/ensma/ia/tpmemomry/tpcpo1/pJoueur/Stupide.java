/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/
package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

import java.util.Random;

import fr.ensma.ia.tpmemomry.tpcpo1.pJoueur.IA;
// Start of user code (user defined imports)
import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.Plateau;

// End of user code

/**
 * Description of Stupide.
 * 
 * @author douaultc
 */
public class Stupide extends IA implements IJoueur{
	// Start of user code (user defined attributes for Stupide)

	// End of user code

	/**
	 * The constructor.
	 */
	public Stupide(Plateau p) {
		super(p);
	}
	
	public Stupide(String nom,Plateau p) {
		super(p,nom);
	}

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom=nom;
	}

	@Override
	public Score getScore() {
		return score;
	}

	@Override
	public void updateScore(int bonus) {
		score.updateScore(nbrPairesTrouvees, bonus);
		
	}

	@Override
	public void jouer() throws InterruptedException {
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
			if((plateau.getListeCartesMelangees().get(select2).getSurPlateau()==false)&&(select1!=select2)) jeu =false;
		}
		try {
			plateau.setCarte1(plateau.getListeCartesMelangees().get(select1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait(500);
		try {
			plateau.setCarte2(plateau.getListeCartesMelangees().get(select2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait(500);
		
		
	}

	@Override
	public void tourPerdu() {
		this.nbrPairesTrouvees=0;
		
	}

	@Override
	public void tourGagne(int effetCarte) {
		this.score.updateScore(nbrPairesTrouvees, effetCarte);
		
	}

	

}
