package software.ulpgc.kata5.architecture.model;

import java.util.List;

public record Pokemon(String name, List<Ability> abilities, int height, int weight, byte[] normalSprite,byte[] shinySprite) {
}
