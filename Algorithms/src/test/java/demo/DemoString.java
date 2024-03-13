package demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DemoString {

    @Test
    void demoCase(){
        String city = "Montauban";
        String cityUpperCase = city.toUpperCase();
        boolean cityEmpty = city.isEmpty();
        System.out.println(cityUpperCase);
        System.out.println(cityEmpty);
    }

    @Test
    void exo1(){
        String text = "Montauban, la ville des boulets";
        // trouver la position de la première virgule
        int index = text.indexOf(",");
        // recupérer le début du texte jusqu'à la virgule
        String city = text.substring(0, index);
        // le mettre en majuscule
        String cityUpperCase = city.toUpperCase();
        // l'afficher
        System.out.println(cityUpperCase);
    }

    @ParameterizedTest
    @ValueSource(strings={
            "Montauban, la ville des boulets",
            "Toulouse, ville rose",
            "Pau, ville du roi Henri IV",
            "Angoulême, la ville de la BD",
            "texte non conforme"
    })
    void exo2(String text){
        // trouver la position de la première virgule
        int index = text.indexOf(",");
        if (index < 0){
            System.out.println("texte non conforme, il manque une virgule");
        } else {
            // recupérer le début du texte jusqu'à la virgule
            String city = text.substring(0, index);
            // le mettre en majuscule
            String cityUpperCase = city.toUpperCase();
            // l'afficher
            System.out.println(cityUpperCase);
        }
    }

    @Test
    void demoStringArray(){
        String[] cities = {"Toulouse", "Montauban", "Pau", "Angoulême"};
        System.out.println(Arrays.toString(cities));
        int n = cities.length;
        String city = cities[0];
        System.out.println(city);
        cities[0] = "Bordeaux";
        System.out.println(Arrays.toString(cities));
    }

    @Test
    void demoStringList(){
        List<String> cities = List.of("Toulouse", "Montauban", "Pau", "Angoulême");
        System.out.println(cities.getClass());
        System.out.println(cities);
        int n = cities.size();
        System.out.println("Number of cities: " + n);
        String city = cities.get(0);
        // cities.set(0, "Bordeaux"); // UnsupportedOperationException on List.of...
        List<String> cities2 = new ArrayList<>(cities);
        cities2.set(0, "Bordeaux");
        System.out.println(cities2);
    }

    @Test
    void demoMutableStringList(){
        List<String> cities = new ArrayList<>();
        System.out.println(cities);
        cities.add("Pau");
        System.out.println(cities);
        Collections.addAll(cities, "Toulouse", "Montauban", "Pau", "Angoulême");
        System.out.println(cities);
        cities.set(0, "Bordeaux");
        System.out.println(cities);
        for (String city: cities) {
            System.out.println("- " + city);
        }
    }

}
