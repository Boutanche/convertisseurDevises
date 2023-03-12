### Title: README.md
### Description: README.md
### =====================
## Convertisseur Devises
### =====================
##
### Description
## -----------
#### Ce programme permet de convertir une somme d'argent d'une devise à une autre.
##    
### Fonctionnement
## --------------
#### Le programme demande à l'utilisateur de saisir une somme d'argent et la devise de départ.
#### Il demande ensuite la devise de destination.
##
### Auteur
## ------
#### Auteur : BBE
#### Date : 2023-03-12
##
### Version
## -------
#### Version : 1.0
#### Date : 2023-03-12
#### Description : Version initiale


### =====================
## Convertisseur Devises
### =====================
Ennoncé :
Nous souhaitons créer un convertisseur de devise de € vers toute autre devise et de toute autre devise vers €.
La méthode de conversion utilisera un coefficient multiplicateur qui permettra de passer de l’Euro vers la devise. 
Le coefficient utilisé par le convertisseur doit être configurable pour chaque devise.

a) Proposer une version objet avec une classe Convertisseur d’instances de Montant exprimés en Devise avec une méthode convertir

b) Proposer une version fonctionnelle sous la forme de l’implémentation d’une fonction issue du package java.util.function nommée convertirVersEuro qui permet de convertir un montant exprimé dans une devise quelconque en un montant exprimé dans la devise euro.
c) Proposer une version fonctionnelle sous la forme de l’implémentation d’une fonction issue du package java.util.function nommée convertirEuroVersDevise qui permet de convertir un montant exprimé en euro en un montant exprimé dans une autre devise.
d) Curryfication : Est-il possible de curryfier les fonctions convertirVersEuro et convertirEuroVersDevise ? Effectuer ces curryfications si elles sont possibles.
e) Ecrire une fonction fabriquerConvertisseur qui prendra deux devises (origine, destination) et retournera une fonction permettant de convertir un montant exprimé dans la devise d’origine en son montant équivalent exprimé dans la devise destination.
f) Conclusion : comparer votre implémentation utilisant la POO et vos implémentations fonctionnelles (apports, limites, intérêts...)
