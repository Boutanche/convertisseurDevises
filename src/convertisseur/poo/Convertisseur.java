package convertisseur.poo;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Convertisseur class.
 * @author BBE
 * @version 1.0
 */
public class Convertisseur {

    /**
     * Constructeur privé pour empêcher l'instanciation de la classe.
     */
    private Convertisseur() {
        // Constructeur privé pour empêcher l'instanciation de la classe.
    }

    /**
     * Partie 1 de l'exercice : POO
     * Convertir un montant d'une devise à une autre.
     * @param montantOrigine Montant à convertir.
     * @param deviseCible Devise cible.
     * @return Montant converti.
     */
    public static Montant convertir(Montant montantOrigine, Devise deviseCible) {
        float montantConverti = (montantOrigine.getNombreDevise() * montantOrigine.getDevise().getValeurEnEuro()) / deviseCible.getValeurEnEuro();
        System.out.println("Montant converti : " + montantConverti + " " + deviseCible.getSymbole());
        Float roundMontantConverti = arrondirMontant(montantConverti);
        return new Montant(roundMontantConverti, deviseCible);
    }

    /**
     * Arrondir un montant.
     */
    public static float arrondirMontant(float montant) {
        return (Math.round(montant * 100) / 100.0F);
    }
}
