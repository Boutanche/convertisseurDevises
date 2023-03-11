package testsConvertisseur.testsPoo;

import convertisseur.poo.Devise;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * DeviseTest class.
 * Tests unitaires de la classe Devise.
 * @author BBE
 * @version 1.0
 */
public class DeviseTest {
    /**
     * Test of constructor, of class Devise.
     */
    @Test
    public void testConstructor() {
        System.out.println("testConstructor");
        String nom = "Euro";
        String symbole = "€";
        Float valeurEnEuro = 1.0F;
        Devise instance = new Devise(nom, symbole, valeurEnEuro);
        assertEquals(nom, instance.getNom());
        assertEquals(symbole, instance.getSymbole());
        assertEquals(valeurEnEuro, instance.getValeurEnEuro());
    }

    /**
     * Test of getNom method, of class Devise.
     */
    @Test
    public void testGetNom() {
        System.out.println("testGetNom");
        String nom = "Euro";
        String symbole = "€";
        Float valeurEnEuro = 1.0F;
        Devise instance = new Devise(nom, symbole, valeurEnEuro);
        String expResult = "Euro";
        String result = instance.getNom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSymbole method, of class Devise.
     */
    @Test
    public void testGetSymbole() {
        System.out.println("testGetSymbole");
        String nom = "Euro";
        String symbole = "€";
        Float valeurEnEuro = 1.0F;
        Devise instance = new Devise(nom, symbole, valeurEnEuro);
        String expResult = "€";
        String result = instance.getSymbole();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValeurEnEuro method, of class Devise.
     */
    @Test
    public void testGetValeurEnEuro() {
        System.out.println("testGetValeurEnEuro");
        String nom = "Euro";
        String symbole = "€";
        Float valeurEnEuro = 1.0F;
        Devise instance = new Devise(nom, symbole, valeurEnEuro);
        Float expResult = 1.0F;
        Float result = instance.getValeurEnEuro();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Devise.
     */
    @Test
    public void testToString() {
        System.out.println("testToString");
        String nom = "Euro";
        String symbole = "€";
        Float valeurEnEuro = 1.0F;
        Devise instance = new Devise(nom, symbole, valeurEnEuro);
        String expResult = "Devise{nom=Euro, symbole=€, valeurEnEuro=1.0}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
