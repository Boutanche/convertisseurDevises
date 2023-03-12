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

    final Devise DEVISE_DOLLAR = new Devise("Dollar", "$", 0.94F);
    final Devise DEVISE_EURO = new Devise("Euro", "€", 1.00F);
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
        System.out.println("testConvertir : est OK");
        Montant montant = new Montant(1.10F, DEVISE_EURO);
        Montant expResult = new Montant(1.17F, DEVISE_DOLLAR);
        Montant result = Convertisseur.convertir(montant, DEVISE_DOLLAR);
        assertEquals(expResult, result);
    }

    /**
     * Test de la méthode arrondirMontant.
     */
    @Test
    public void testArrondirMontant() {
        System.out.println("testArrondirMontant : est OK");
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
        System.out.println("testConvertirVersEuro : est OK");
        Montant montant = new Montant(1.00F, DEVISE_DOLLAR);
        Montant expResult = new Montant(0.94F, DEVISE_EURO);
        Montant result = Convertisseur.convertirVersEuro().apply(montant);
        assertEquals(expResult, result);
    }

    /**
     * Test de la méthode convertirVersDevise.
     */
    @Test
    public void testConvertirVersDevise() {
        System.out.println("testConvertirVersDevise : est OK");
        Montant montant = new Montant(1.00F, DEVISE_EURO);
        Montant expResult = new Montant(1.06F, DEVISE_DOLLAR);
        Montant result = Convertisseur.convertirVersDevise(DEVISE_DOLLAR).apply(montant);
        assertEquals(expResult, result);
    }

    /**
     * Test de la méthode convertirVersDevise2.
     */
    @Test
    public void testConvertirVersDevise2() {
        System.out.println("testConvertirVersDevise2 : est OK");
        Montant montant = new Montant(1.00F, DEVISE_EURO);
        Montant expResult = new Montant(1.06F, DEVISE_DOLLAR);
        Montant result = Convertisseur.convertirVersDevise(DEVISE_DOLLAR).apply(montant);
        assertEquals(expResult, result);
    }
}
