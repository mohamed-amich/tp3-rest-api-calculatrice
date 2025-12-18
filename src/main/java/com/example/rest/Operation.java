package com.example.rest;

public enum Operation {
    ADDITION("Addition"),
    SOUSTRACTION("Soustraction"),
    MULTIPLICATION("Multiplication"),
    DIVISION("Division");

    private final String description;

    Operation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**

     * @param op chaîne représentant l'opération (ex : "addition", "soustraction", ...)
     * @return l'opération correspondante de type Operation
     * @throws IllegalArgumentException si la chaîne ne correspond à aucune opération
     */
    public static Operation fromString(String op) {
        if (op == null) {
            throw new IllegalArgumentException("L'opération ne peut pas être nulle");
        }

        try {
            return Operation.valueOf(op.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                "Opération invalide : " + op + 
                ". Valeurs acceptées : addition, soustraction, multiplication, division"
            );
        }
    }
}
