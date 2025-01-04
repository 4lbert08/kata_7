package software.ulpgc.kata5.architecture.io;

import software.ulpgc.kata5.architecture.model.Pokemon;

public interface PokemonAdapter {
    Pokemon  adapt(Object o);
}
