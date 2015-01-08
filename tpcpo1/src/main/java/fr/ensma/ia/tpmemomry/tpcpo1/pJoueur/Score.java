package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

public class Score {

	private Joueur joueur;
	
	private int score = 0;

	public Score() {
		super();
	}
	
	public Score(Joueur joueur) {
		this.setJoueur(joueur);
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
	public void updateScore(int nbrTourRejoue){
		if(nbrTourRejoue==0){
			this.score=this.score+2;
		} else {
			this.score=this.score+(2+(nbrTourRejoue*2-1));
		}
	}
	
}
