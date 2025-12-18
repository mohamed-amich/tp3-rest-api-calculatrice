package com.example.rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/api")
public class RestApplication extends Application {

    /**
     * Enregistre les classes de ressources REST
     * @return Ensemble des classes de ressources
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CalculRest.class);
        return classes;
    }
}