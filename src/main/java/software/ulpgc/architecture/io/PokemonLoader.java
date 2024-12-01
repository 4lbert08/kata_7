package software.ulpgc.architecture.io;

import software.ulpgc.architecture.model.Pokemon;

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
