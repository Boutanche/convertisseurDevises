package testsConvertisseur.testsPoo;

import convertisseur.poo.Convertisseur;
import convertisseur.poo.Devise;
import convertisseur.poo.Montant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ConvertisseurTest class.
 * Tests unitaires de la classe Convertisseur.
 * @author BBE
 * @version 1.0
 */
public class ConvertisseurTest {
    /*
     * Plan de test de la méthode convertir.
     * 1. Test de la conversion d'un montant en euro vers un montant en dollar.
     * TODO : Ajouter d'autres tests.
     */


    /**
     * Test de la méthode convertir.
     */
    @Test
    public void testConvertir() {
        System.out.println("testConvertir");
        Montant montant = new Montant(1.10F, new Devise("Euro", "€", 1.00F));
        Devise devise = new Devise("Dollar", "$", 0.94F);
        Montant expResult = new Montant(1.17F, new Devise("Dollar", "$", 0.94F));
        Montant result = Convertisseur.convertir(montant, devise);
        assertEquals(expResult, result);
    }

    /**
     * Test de la méthode arrondirMontant.
     */
    @Test
    public void testArrondirMontant() {
        System.out.println("testArrondirMontant");
        float montant = 1.123456F;
        float expResult = 1.12F;
        float result = Convertisseur.arrondirMontant(montant);
        assertEquals(expResult, result);
    }

    /**
     * Test de la méthode convertirVersEuro.
     */
    @Test
    public void testConvertirVersEuro() {
        System.out.println("testConvertirVersEuro");
        Montant montant = new Montant(1.00F, new Devise("Dollar", "$", 0.94F));
        Montant expResult = new Montant(0.94F, new Devise("Euro", "€", 1.00F));
        Montant result = Convertisseur.convertirVersEuro().apply(montant);
        assertEquals(expResult, result);
    }

    /**
     * Test de la méthode convertirVersDevise.
     */
    @Test
    public void testConvertirVersDevise() {
        System.out.println("testConvertirVersDevise");
        Montant montant = new Montant(1.00F, new Devise("Euro", "$", 1.00F));
        Montant expResult = new Montant(1.06F, new Devise("Dollar", "$", 0.94F));
        Montant result = Convertisseur.convertirVersDevise(new Devise("Dollar", "$", 0.94F)).apply(montant);
        assertEquals(expResult, result);
    }
}
