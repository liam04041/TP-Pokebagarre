package com.montaury.pokebagarre.metier;

import org.assertj.core.api.Java6Assertions;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/*
 Tests réalisés :
    Sur <premierPokemon>.estVainqueurContre(<secondPoekmon>) :
    1 - le premier pokemon gagne car il a l'attaque la plus haute donc le premier gagne

    2 - le deuxieme pokemon gagne car il a l'attaque la plus haute donc le deuxieme gagne

    3 - les deux pokemons ont la meme attaque,
        mais le premier pokemon à la defense la plus haute donc le premier gagne

    4 - les deux pokemons ont la meme attaque,
        mais le deuxieme pokemon à la defense la plus haute donc le deuxième gagne

    5 - les deux pokemons ne sont pas les memes, mais ont exactement
        les memes statistiques donc le premier gagne.
 */

class PokemonTests {

    @Test
    public void pokemon_1_gagne_car_meilleure_attaque() {
        //GIVEN
        Pokemon strongerPokemon = new Pokemon("Dracaufeu", "url", new Stats(80, 50));
        Pokemon weakerPokemon = new Pokemon("Pikachu", "url", new Stats(60, 40));

        //WHEN
        boolean resultat = strongerPokemon.estVainqueurContre(weakerPokemon);

        //THEN
        assertThat(resultat).isTrue();
    }

    @Test
    public void test_attaque_plus_basse_ne_gagne_pas() {
        //GIVEN
        Pokemon strongerPokemon = new Pokemon("Dracaufeu", "url", new Stats(50, 40));
        Pokemon weakerPokemon = new Pokemon("Pikachu", "url", new Stats(80, 60));
        //WHEN
        boolean resultat = strongerPokemon.estVainqueurContre(weakerPokemon);
        //THEN
        assertThat(resultat).isFalse();
    }

    @Test
    public void test_attaque_egale_defense_gagne() {
        //GIVEN
        Pokemon strongerPokemon = new Pokemon("Dracaufeu", "url", new Stats(80, 60));
        Pokemon weakerPokemon = new Pokemon("Pikachu", "url", new Stats(80, 50));

        //WHEN
        boolean resultat = strongerPokemon.estVainqueurContre(weakerPokemon);

        //THEN
        assertThat(resultat).isTrue();
    }

    @Test
    public void test_defense_identique_premier_gagne() {
        //GIVEN
        Pokemon strongerPokemon = new Pokemon("Dracaufeu", "url", new Stats(80, 50));
        Pokemon weakerPokemon = new Pokemon("Pikachu", "url", new Stats(80, 50));

        //WHEN
        boolean resultat = strongerPokemon.estVainqueurContre(weakerPokemon);

        //THEN
        assertThat(resultat).isTrue();
    }

}