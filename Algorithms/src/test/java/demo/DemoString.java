package demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

}
