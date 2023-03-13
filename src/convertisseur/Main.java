package convertisseur;

import convertisseur.fonctionnelle.ConvertisseurFonctionnelle;
import convertisseur.poo.Convertisseur;
import convertisseur.poo.Devise;
import convertisseur.poo.Montant;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Main class of the application.
 * "Convertisseur de devises" is a simple application that converts a given amount of money from one currency to another.
 * TP_02 : Programmation Fonctionnelle en Java
 * PEI Millau, CAI-SI 03 : (2022-2023)
 * CNAM, NFP101 : Programmation Fonctionnelle en Java
 * @author BBE
 * @version 1.0
 */
public class Main {
    /**
     * Devise Dollar US.
     */
    static final Devise DOLLAR = new Devise("Dollar US", "$", 0.94F);
    /**
     * Devise Euro.
     */
    static final Devise EURO = new Devise("Euro", "€", 1.00F);
    /**
     * Devise Yen.
     */
    static final Devise YEN = new Devise("Yen", "¥", 0.0087F);
    /**
     * Separator.
     */
    static final String SEPARATOR = "--------------------------------------------------";
    /**
     * 10.00 Dollar US.
     */
    static final String DIX_DOLLAR = "10.00 Dollar US = ";

    /**
     * Main method.
     * @param args Arguments.
     */
    public static void main(String[] args) {
        System.out.println(SEPARATOR);
        System.out.println("-- Hello world! Convertisseur de devises : --");
        System.out.println(SEPARATOR);
        partie1();
        partie2();
        partie3();
        conclusion();
    }
    /**
     * Partie 1 : Programmation Orientée Objet
     */
    private static void partie1() {
        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println("           En utilisant la POO :");
        System.out.println(SEPARATOR);
        System.out.println("1.00 Dollar US = 0.94 Euro");
        Montant dixDollar = new Montant(10.00F, DOLLAR);
        Montant converti1 = Convertisseur.convertir(dixDollar, EURO);
        System.out.println(DIX_DOLLAR + converti1.getNombreDevise() + " " + converti1.getDevise().getSymbole());
        Montant dixEuro = new Montant(10.00F, EURO);
        Montant converti2 = Convertisseur.convertir(dixEuro, DOLLAR);
        System.out.println("10.00 Euro = " + converti2.getNombreDevise() + " " + converti2.getDevise().getSymbole());
    }

    /**
     * Partie 2 : Programmation Fonctionnelle
     */
    private static void partie2() {
        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println("En utilisant la Programmation Fonctionnelle :");
        System.out.println(SEPARATOR);
        Montant dixDollar2 = new Montant(10.00F, DOLLAR);
        UnaryOperator<Montant> convertirVersEuro = ConvertisseurFonctionnelle.convertirVersEuro();
        Montant converti3 = convertirVersEuro.apply(dixDollar2);
        System.out.println(DIX_DOLLAR + converti3.getNombreDevise() + " " + converti3.getDevise().getSymbole());
        Montant dixEuro2 = new Montant(10.00F, EURO);
        UnaryOperator<Montant> convertirVersDollar = ConvertisseurFonctionnelle.convertirVersDevise(DOLLAR);
        Montant converti4 = convertirVersDollar.apply(dixEuro2);
        System.out.println("10.00 Euro = " + converti4.getNombreDevise() + " " + converti4.getDevise().getSymbole());
    }

    /**
     * Partie 3 : Programmation Fonctionnelle
     */
    private static void partie3() {
        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println(" Curryfié avec Programmation Fonctionnelle : ");
        System.out.println(SEPARATOR);
        Montant dixDollar3 = new Montant(10.00F, DOLLAR);
        UnaryOperator<Montant> convertirVersEuroCurry = ConvertisseurFonctionnelle.convertirVersEuroCurryfie();
        Montant converti5 = convertirVersEuroCurry.apply(dixDollar3);
        System.out.println(DIX_DOLLAR + converti5.getNombreDevise() + " " + converti5.getDevise().getSymbole());
        Function<Devise, UnaryOperator<Montant>> fabriquerConvertisseurEuroVersYen = ConvertisseurFonctionnelle.fabriquerConvertisseur(YEN, EURO);
        Montant unEuro = new Montant(1.00F, EURO);
        Montant dixEurosCinquanteCentimes = new Montant(10.50F, EURO);
        Montant converti6 = fabriquerConvertisseurEuroVersYen.apply(YEN).apply(unEuro);
        Montant converti7 = fabriquerConvertisseurEuroVersYen.apply(YEN).apply(dixEurosCinquanteCentimes);
        Function<Devise, UnaryOperator<Montant>> fabriquerConvertisseurEuroVersDollar = ConvertisseurFonctionnelle.fabriquerConvertisseur(DOLLAR, EURO);
        Montant converti8 = fabriquerConvertisseurEuroVersDollar.apply(DOLLAR).apply(unEuro);
        System.out.println("1.00 Euro = " + converti6.getNombreDevise() + " " + converti6.getDevise().getSymbole());
        System.out.println("10.50 Euro = " + converti7.getNombreDevise() + " " + converti7.getDevise().getSymbole());
        System.out.println("1.00 Euro = " + converti8.getNombreDevise() + " " + converti8.getDevise().getSymbole());
    }

    /**
     * Conclusion
     */
    private static void conclusion() {
        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println("--               Conclusion              : --");
        System.out.println(SEPARATOR);
        System.out.println();
        String textBlock = """
                L'approche orientée objet (POO) offre des avantages et des limites par rapport aux implémentations fonctionnelles.
                 -- - Voici quelques points à considérer :
                
                Avantages de la POO :
                - La POO permet une encapsulation de données et de fonctionnalités,
                 -- - ce qui facilite la gestion de code modulaire et la réutilisation de code.
                - La POO peut permettre une meilleure organisation du code,
                    -- - en divisant les responsabilités entre différentes classes.
                - La POO peut rendre le code plus facile à maintenir et à étendre,
                    -- - car les modifications apportées à une classe ne devraient pas affecter les autres classes.
                    
                Limites de la POO :
                - La POO peut rendre le code plus difficile à lire et à comprendre,
                    -- - car les classes peuvent être plus complexes et plus difficiles à suivre.
                - La POO peut rendre le code plus difficile à déboguer,
                    -- - car les erreurs peuvent survenir à plusieurs endroits.
                - La POO peut rendre le code plus difficile à tester,
                    -- - car les tests doivent être effectués sur chaque classe séparément.
                    
                Avantages de la programmation fonctionnelle :
                - La programmation fonctionnelle peut rendre le code plus facile à lire et à comprendre,
                    -- - car les fonctions sont plus petites et plus simples.
                - La programmation fonctionnelle peut rendre le code plus facile à déboguer,
                    -- - car les erreurs sont plus faciles à localiser.
                - La programmation fonctionnelle peut rendre le code plus facile à tester,
                    -- - car les fonctions sont plus petites et plus faciles à tester.
                    
                Limites de la programmation fonctionnelle :
                - La programmation fonctionnelle peut rendre le code plus difficile à maintenir et à étendre,
                    -- - car les fonctions sont plus petites et plus difficiles à modifier.
                - La programmation fonctionnelle peut rendre le code plus difficile à réutiliser,
                    -- - car les fonctions sont plus petites
                """;
        System.out.println(textBlock);
    }
}