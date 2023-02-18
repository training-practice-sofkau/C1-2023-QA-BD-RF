package com.sofka.sofkau.integracion.modelo;
import com.github.javafaker.Faker;

import java.util.Random;

public class FakerLlenar {
    private static FakerLlenar random=null;
    private Faker faker=new Faker();
    private Random rand=new Random();
    private FakerLlenar(){
    }
    public static FakerLlenar getRandom(){
        if (random==null)
            random=new FakerLlenar();
        return random;
    }
    public Faker getFaker() {
        return faker;
    }
    public Random getRand() {
        return rand;
    }
}
