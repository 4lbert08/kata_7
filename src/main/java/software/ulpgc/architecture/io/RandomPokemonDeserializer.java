package software.ulpgc.architecture.io;

import com.google.gson.Gson;
import software.ulpgc.architecture.io.pojos.RandomPokemonGetResponse;

public class RandomPokemonDeserializer implements PokemonDeserializer{
    @Override
    public Object deserialize(String body) {
        return new Gson().fromJson(body, RandomPokemonGetResponse.class);
    }
}
