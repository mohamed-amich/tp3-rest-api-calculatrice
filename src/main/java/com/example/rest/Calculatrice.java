package com.example.rest;

/**
 * Classe métier contenant la logique de calcul
 */
public class Calculatrice {

    /**
     * Effectue une addition
     * @param a Premier nombre
     * @param b Deuxième nombre
     * @return Résultat de l'addition
     */
    public double addition(double a, double b) {
        return a + b;
    }

    /**
     * Effectue une soustraction
     * @param a Premier nombre
     * @param b Deuxième nombre
     * @return Résultat de la soustraction
     */
    public double soustraction(double a, double b) {
        return a - b;
    }

    /**
     * Effectue une multiplication
     * @param a Premier nombre
     * @param b Deuxième nombre
     * @return Résultat de la multiplication
     */
    public double multiplication(double a, double b) {
        return a * b;
    }

    /**
     * Effectue une division
     * @param a Dividende
     * @param b Diviseur
     * @return Résultat de la division
     * @throws ArithmeticException si le diviseur est zéro
     */
    public double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro impossible");
        }
        return a / b;
    }

    /**
     * Exécute l'opération demandée
     * @param operation Type d'opération
     * @param a Premier nombre
     * @param b Deuxième nombre
     * @return Résultat de l'opération
     */
    public double calculer(Operation operation, double a, double b) {
        switch (operation) {
            case ADDITION:
                return addition(a, b);
            case SOUSTRACTION:
                return soustraction(a, b);
            case MULTIPLICATION:
                return multiplication(a, b);
            case DIVISION:
                return division(a, b);
            default:
                throw new IllegalArgumentException("Opération non supportée : " + operation);
        }
    }
}