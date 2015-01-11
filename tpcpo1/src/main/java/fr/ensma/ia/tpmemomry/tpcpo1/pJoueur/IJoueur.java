package fr.ensma.ia.tpmemomry.tpcpo1.pJoueur;

public interface IJoueur {
	
	public String getNom();
	public void setNom(String nom);
	public Score getScore();
	public void updateScore(int bonus);
	public void jouer() throws InterruptedException;
	public void tourPerdu();
	public void tourGagne(int effetCarte);

}
