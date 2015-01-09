package fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie;

import fr.ensma.ia.tpmemomry.tpcpo1.Partie;
import fr.ensma.ia.tpmemomry.tpcpo1.pEtatPartie.IEtatPartie;

/**
 * Description de l'Žtat PairesRestantes de l'automate
 * Pattern Etat
 * 
 * @author douaultc
 */
public class PairesRestantes implements IEtatPartie {
	
	/**
	 * Reference de l'automate
	 */
	private Partie partie;

	/**
	 * Constructeur de l'Žtat PairesRestantes
	 * @param partie Partie : reference de l'automate
	 */
	public PairesRestantes(Partie partie) {
		super();
		this.partie = partie;
	}

	/**
	 * Transition paireTrouvee
	 */
	public void paireTrouvee(){
		partie.traitementPaireTrouvee();
	}

	/**
	 * Transition pasPaireTrouvee
	 */
	public void pasPaireTrouvee(){
		partie.traitementPaireNonTrouvee();
	}
	
	/**
	 * Transition plusPairePossible
	 */
	public void plusPairePossible(){
		partie.setEtatCourantPartie(partie.getFinPartie());
	}

}
