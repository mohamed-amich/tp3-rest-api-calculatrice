package com.example.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/calculatrice")
@Produces(MediaType.APPLICATION_JSON)
public class CalculRest {

    private final Calculatrice calculatrice = new Calculatrice();

   
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info() {
        return "API Calculatrice REST\n" +
               "Utilisez /calculer?operation=OPERATION&a=X&b=Y\n" +
               "Opérations disponibles : addition, soustraction, multiplication, division";
    }

   
    @GET
    @Path("/calculer")
    public Response calculer(
            @QueryParam("operation") String operation,
            @QueryParam("a") @DefaultValue("0") double a,
            @QueryParam("b") @DefaultValue("0") double b) {
        
        try {
            if (operation == null || operation.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ResultatCalcul(null, a, b, 0, 
                        "Paramètre 'operation' manquant", false))
                    .build();
            }

            Operation op = Operation.fromString(operation);
            double resultat = calculatrice.calculer(op, a, b);
            
            return Response.ok(new ResultatCalcul(op, a, b, resultat, "Succès", true))
                .build();
                
        } catch (ArithmeticException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ResultatCalcul(null, a, b, 0, e.getMessage(), false))
                .build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ResultatCalcul(null, a, b, 0, e.getMessage(), false))
                .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ResultatCalcul(null, a, b, 0, 
                    "Erreur interne : " + e.getMessage(), false))
                .build();
        }
    }

    
    @GET
    @Path("/addition")
    public Response addition(
            @QueryParam("a") @DefaultValue("0") double a,
            @QueryParam("b") @DefaultValue("0") double b) {
        
        double resultat = calculatrice.addition(a, b);
        return Response.ok(new ResultatCalcul(Operation.ADDITION, a, b, resultat, "Succès", true))
            .build();
    }

   
    @GET
    @Path("/soustraction")
    public Response soustraction(
            @QueryParam("a") @DefaultValue("0") double a,
            @QueryParam("b") @DefaultValue("0") double b) {
        
        double resultat = calculatrice.soustraction(a, b);
        return Response.ok(new ResultatCalcul(Operation.SOUSTRACTION, a, b, resultat, "Succès", true))
            .build();
    }

   
    @GET
    @Path("/multiplication")
    public Response multiplication(
            @QueryParam("a") @DefaultValue("0") double a,
            @QueryParam("b") @DefaultValue("0") double b) {
        
        double resultat = calculatrice.multiplication(a, b);
        return Response.ok(new ResultatCalcul(Operation.MULTIPLICATION, a, b, resultat, "Succès", true))
            .build();
    }

    
    @GET
    @Path("/division")
    public Response division(
            @QueryParam("a") @DefaultValue("0") double a,
            @QueryParam("b") @DefaultValue("1") double b) {
        
        try {
            double resultat = calculatrice.division(a, b);
            return Response.ok(new ResultatCalcul(Operation.DIVISION, a, b, resultat, "Succès", true))
                .build();
        } catch (ArithmeticException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ResultatCalcul(Operation.DIVISION, a, b, 0, e.getMessage(), false))
                .build();
        }
    }

     
    public static class ResultatCalcul {
        private String operation;
        private double operandeA;
        private double operandeB;
        private double resultat;
        private String message;
        private boolean succes;

        public ResultatCalcul() {}

        public ResultatCalcul(Operation operation, double a, double b, double resultat, 
                             String message, boolean succes) {
            this.operation = operation != null ? operation.name() : null;
            this.operandeA = a;
            this.operandeB = b;
            this.resultat = resultat;
            this.message = message;
            this.succes = succes;
        }

      
        public String getOperation() { return operation; }
        public void setOperation(String operation) { this.operation = operation; }
        
        public double getOperandeA() { return operandeA; }
        public void setOperandeA(double operandeA) { this.operandeA = operandeA; }
        
        public double getOperandeB() { return operandeB; }
        public void setOperandeB(double operandeB) { this.operandeB = operandeB; }
        
        public double getResultat() { return resultat; }
        public void setResultat(double resultat) { this.resultat = resultat; }
        
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        
        public boolean isSucces() { return succes; }
        public void setSucces(boolean succes) { this.succes = succes; }
    }
}