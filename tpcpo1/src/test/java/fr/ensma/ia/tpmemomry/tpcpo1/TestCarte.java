package fr.ensma.ia.tpmemomry.tpcpo1;

import fr.ensma.ia.tpmemomry.tpcpo1.pPlateau.carte.*;
import junit.framework.*;

public class TestCarte extends TestCase {
	public void testCarte(){
		ICarte c = new CarteNormale(ESymboleCarte.carre);
		assertEquals(ESymboleCarte.carre, c.getSymbole());
	}

}
