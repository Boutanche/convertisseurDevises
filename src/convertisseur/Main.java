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
    public static void main(String[] args) {
        final String separator = ("---------------------------------------------");
        System.out.println(separator);
        System.out.println("-- Hello world! Convertisseur de devises : --");
        System.out.println(separator);
        System.out.println();
        System.out.println(separator);
        System.out.println("           En utilisant la POO :");
        System.out.println(separator);
        System.out.println("1.00 Dollar US = 0.94 Euro");
        Devise dollar = new Devise("Dollar US", "$", 0.94F);
        Devise euro = new Devise("Euro", "€", 1.00F);
        Montant dixDollar = new Montant(10.00F, dollar);
        Montant converti1 = Convertisseur.convertir(dixDollar, euro);
        System.out.println("10.00 Dollar US = " + converti1.getNombreDevise() + " " + converti1.getDevise().getSymbole());
        Montant dixEuro = new Montant(10.00F, euro);
        Montant converti2 = Convertisseur.convertir(dixEuro, dollar);
        System.out.println("10.00 Euro = " + converti2.getNombreDevise() + " " + converti2.getDevise().getSymbole());
        System.out.println();
        System.out.println(separator);
        System.out.println("En utilisant la Programmation Fonctionnelle :");
        System.out.println(separator);
        Montant dixDollar2 = new Montant(10.00F, dollar);
        UnaryOperator<Montant> convertirVersEuro = ConvertisseurFonctionnelle.convertirVersEuro();
        Montant converti3 = convertirVersEuro.apply(dixDollar2);
        System.out.println("10.00 Dollar US = " + converti3.getNombreDevise() + " " + converti3.getDevise().getSymbole());
        Montant dixEuro2 = new Montant(10.00F, euro);
        UnaryOperator<Montant> convertirVersDollar = ConvertisseurFonctionnelle.convertirVersDevise(dollar);
        Montant converti4 = convertirVersDollar.apply(dixEuro2);
        System.out.println("10.00 Euro = " + converti4.getNombreDevise() + " " + converti4.getDevise().getSymbole());
        System.out.println();
        System.out.println(separator);
        System.out.println(" Curryfié avec Programmation Fonctionnelle : ");
        System.out.println(separator);
        Montant dixDollar3 = new Montant(10.00F, dollar);
        UnaryOperator<Montant> convertirVersEuroCurry = ConvertisseurFonctionnelle.convertirVersEuroCurryfie();
        Montant converti5 = convertirVersEuroCurry.apply(dixDollar3);
        System.out.println("10.00 Dollar US = " + converti5.getNombreDevise() + " " + converti5.getDevise().getSymbole());
        Devise yen = new Devise("Yen", "¥", 0.007F);
        Function<Devise, UnaryOperator<Montant>> fabriquerConvertisseurEuroVersYen = ConvertisseurFonctionnelle.fabriquerConvertisseur(yen, euro);
        Montant unEuro = new Montant(1.00F, euro);
        Montant dixEurosCinquanteCentimes = new Montant(10.50F, euro);
        Montant converti6 = fabriquerConvertisseurEuroVersYen.apply(yen).apply(unEuro);
        Montant converti7 = fabriquerConvertisseurEuroVersYen.apply(yen).apply(dixEurosCinquanteCentimes);
        Function<Devise, UnaryOperator<Montant>> fabriquerConvertisseurEuroVersDollar = ConvertisseurFonctionnelle.fabriquerConvertisseur(dollar, euro);
        Montant converti8 = fabriquerConvertisseurEuroVersDollar.apply(dollar).apply(unEuro);
        System.out.println("1.00 Euro = " + converti6.getNombreDevise() + " " + converti6.getDevise().getSymbole());
        System.out.println("10.50 Euro = " + converti7.getNombreDevise() + " " + converti7.getDevise().getSymbole());
        System.out.println("1.00 Euro = " + converti8.getNombreDevise() + " " + converti8.getDevise().getSymbole());
        System.out.println();
        System.out.println(separator);
        System.out.println("--               Conclusion              : --");
        System.out.println(separator);
        System.out.println();
        System.out.println("L'approche orientée objet (POO) offre des avantages et des limites par rapport aux implémentations fonctionnelles.\n " +
                "-- - Voici quelques points à considérer :");
        System.out.println();
        System.out.println("Avantages de la POO :");
        System.out.println("- La POO permet une encapsulation de données et de fonctionnalités, \n" +
                "-- - ce qui facilite la gestion de code modulaire et la réutilisation de code.");
        System.out.println("- La POO peut permettre une meilleure organisation du code, \n" +
                "-- - en divisant les responsabilités entre différentes classes.");
        System.out.println("- La POO peut rendre le code plus facile à maintenir et à étendre, \n" +
                "-- - car les modifications apportées à une classe ne devraient pas affecter les autres classes.");
        System.out.println();
        System.out.println("Limites de la POO :");
        System.out.println("- La POO peut conduire à une duplication de code, \n" +
                "-- - car il peut être tentant de créer de nouvelles classes pour chaque petit changement de fonctionnalité.");
        System.out.println("- La POO peut impliquer une surcharge de la mémoire, \n" +
                "car chaque instance d'objet contient des données supplémentaires pour stocker son état.");
        System.out.println();
        System.out.println("Avantages des implémentations fonctionnelles :");
        System.out.println("- Les implémentations fonctionnelles peuvent être plus simples et plus directes, \n" +
                "-- - car elles se concentrent sur les fonctions et les résultats plutôt que sur les objets et les états.");
        System.out.println("- Les implémentations fonctionnelles peuvent être plus faciles à optimiser et à paralléliser, \n" +
                "-- - car les fonctions sont souvent indépendantes les unes des autres.");
        System.out.println("- Les implémentations fonctionnelles peuvent être plus faciles à tester, \n" +
                "-- - car les fonctions sont souvent indépendantes les unes des autres et ne dépendent pas de l'état global.");
        System.out.println();
        System.out.println("Limites des implémentations fonctionnelles :");
        System.out.println("- Les implémentations fonctionnelles peuvent être plus difficiles à comprendre \n" +
                "-- - pour les programmeurs qui ne sont pas habitués à cette approche.");
        System.out.println("- Les implémentations fonctionnelles peuvent nécessiter une réflexion et une planification plus approfondies, \n" +
                "-- - car les fonctions doivent être conçues de manière à travailler ensemble de manière cohérente.");
    }
}