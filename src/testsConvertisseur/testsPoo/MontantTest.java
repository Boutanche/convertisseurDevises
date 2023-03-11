package testsConvertisseur.testsPoo;

import convertisseur.poo.Devise;
import convertisseur.poo.Montant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * MontantTest class.
 * Tests unitaires de la classe Montant.
 * @author BBE
 * @version 1.0
 */
public class MontantTest {

    /**
     * Test of constructor, of class Montant.
     */
    @Test
    public void testConstructor() {
        System.out.println("testConstructor");
        Float nombreDevise = 1.00F;
        Devise devise = new Devise("Euro", "€", 1.00F);
        Montant instance = new Montant(nombreDevise, devise);
        assertEquals(nombreDevise, instance.getNombreDevise());
        assertEquals(devise, instance.getDevise());
    }

    /**
     * Test of getNombreDevise method, of class Montant.
     */
    @Test
    public void testGetNombreDevise() {
        System.out.println("testGetNombreDevise");
        Float nombreDevise = 1.00F;
        Devise devise = new Devise("Euro", "€", 1.00F);
        Montant instance = new Montant(nombreDevise, devise);
        Float expResult = 1.00F;
        Float result = instance.getNombreDevise();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDevise method, of class Montant.
     */
    @Test
    public void testGetDevise() {
        System.out.println("testGetDevise");
        Float nombreDevise = 1.00F;
        Devise devise = new Devise("Euro", "€", 1.00F);
        Montant instance = new Montant(nombreDevise, devise);
        Devise expResult = new Devise("Euro", "€", 1.00F);
        Devise result = instance.getDevise();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Montant.
     */
    @Test
    public void testToString() {
        System.out.println("testToString");
        Float nombreDevise = 1.00F;
        Devise devise = new Devise("Euro", "€", 1.00F);
        Montant instance = new Montant(nombreDevise, devise);
        String expResult = "Montant{nombreDevise=1.0, devise=Devise{nom=Euro, symbole=€, valeurEnEuro=1.0}}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
