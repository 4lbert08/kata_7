package software.ulpgc.kata5.architecture.io.pojos;

import java.util.List;

public record
RandomPokemonGetResponse(String name, List<AbilityContainer> abilities, int height, int weight, Sprite sprites) {

    public record AbilityContainer(Ability ability, boolean is_hidden) {}
    public record Ability(String name) {}
    public record Sprite(String front_default, String front_shiny) {}
}
