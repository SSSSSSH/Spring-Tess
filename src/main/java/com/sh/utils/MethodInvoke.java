package com.sh.utils;

import java.lang.reflect.Method;

public class MethodInvoke {

    public static void main(String[] args) throws Exception {
        Method animalMethod = Animal.class.getDeclaredMethod("print");
        Method catMethod = Cats.class.getDeclaredMethod("print");

        Animal animal = new Animal();
        Cats cat = new Cats();
        animalMethod.invoke(cat);
        animalMethod.invoke(animal);

        catMethod.invoke(cat);
        catMethod.invoke(animal);
    }
}


class Animal {

    public void print() {
        System.out.println("Animal.print()");
    }

}


class Cats extends Animal {

    @Override
    public void print() {
        System.out.println("Cat.print()");
    }

}