package software.ulpgc.kata5.architecture.io;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import software.ulpgc.kata5.architecture.io.pojos.RandomPokemonGetResponse;
import software.ulpgc.kata5.architecture.model.Ability;
import software.ulpgc.kata5.architecture.model.Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RandomPokemonAdapter implements PokemonAdapter{
    @Override
    public Pokemon adapt(Object o) {
        RandomPokemonGetResponse response = (RandomPokemonGetResponse) o;
        try {
            return adaptResponse(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Pokemon adaptResponse(RandomPokemonGetResponse response) throws IOException {

        return new Pokemon(
                response.name(),
                getAbilitiesOf(response),
                response.height(),
                response.weight(),
                getArrayOfBytesOf(response.sprites().front_default()),
                getArrayOfBytesOf(response.sprites().front_shiny())
        );
    }

    private byte[] getArrayOfBytesOf(String url) throws IOException {
        return Jsoup.connect(url)
                .ignoreContentType(true)
                .method(Connection.Method.GET)
                .execute()
                .bodyAsBytes();
    }

    private List<Ability> getAbilitiesOf(RandomPokemonGetResponse response) {
        List<Ability> abilities = new ArrayList<>();
        for (RandomPokemonGetResponse.AbilityContainer container: response.abilities()) {
            abilities.add(new Ability(container.ability().name(), container.is_hidden()));
        }
        return abilities;
    }
}
