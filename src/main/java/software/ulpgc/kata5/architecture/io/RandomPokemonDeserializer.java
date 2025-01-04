package software.ulpgc.kata5.architecture.io;

import com.google.gson.Gson;
import software.ulpgc.kata5.architecture.io.pojos.RandomPokemonGetResponse;

public class RandomPokemonDeserializer implements PokemonDeserializer{
    @Override
    public Object deserialize(String body) {
        return new Gson().fromJson(body, RandomPokemonGetResponse.class);
    }
}
