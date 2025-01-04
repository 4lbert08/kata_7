package software.ulpgc.kata5.architecture.io;

import software.ulpgc.kata5.architecture.model.Pokemon;

public class PokemonLoader {
    private final PokemonReader reader;
    private final PokemonDeserializer deserializer;
    private final PokemonAdapter adapter;

    public PokemonLoader(PokemonReader reader, PokemonDeserializer deserializer, PokemonAdapter adapter) {
        this.reader = reader;
        this.deserializer = deserializer;
        this.adapter = adapter;
    }

    public Pokemon load() {
        return adapter.adapt(deserializer.deserialize(reader.read()));
    }
}
