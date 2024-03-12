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
        // recupérer le début du texte jusqu'à la virgule
        // le mettre en majuscule
        // l'afficher
    }

    @ParameterizedTest
    @ValueSource(strings={
            "Montauban, la ville des boulets",
            "Toulouse, ville rose",
            "Pau, ville du roi Henri IV",
            "texte non conforme"
    })
    void exo2(String text){
        // idem exo1, en tenant compte du cas
        // où il n'y a pas de virgule
        //      => afficher message erreur
    }

}
