package software.ulpgc.kata5.architecture.io;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Random;

public class RandomPokemonReader implements PokemonReader{
    @Override
    public String read() {
        try {
            Random random = new Random();
            int randomNum = random.nextInt((1025-1)+1)+1;
            String url = "https://pokeapi.co/api/v2/pokemon/"+randomNum;
            return read(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String read(String url) throws IOException {
        Connection.Response response = Jsoup.connect(url)
                .ignoreContentType(true)
                .header("accept", "text/*")
                .method(Connection.Method.GET)
                .execute();
        if (response.statusCode()>=200 && response.statusCode()<=299) return response.body();
        throw new RuntimeException();
    }
}
