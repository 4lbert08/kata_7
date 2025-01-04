package software.ulpgc.kata5.app;

import software.ulpgc.kata5.architecture.control.ToggleCommand;
import software.ulpgc.kata5.architecture.io.PokemonLoader;
import software.ulpgc.kata5.architecture.io.RandomPokemonAdapter;
import software.ulpgc.kata5.architecture.io.RandomPokemonDeserializer;
import software.ulpgc.kata5.architecture.io.RandomPokemonReader;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        PokemonLoader loader = new PokemonLoader(
                new RandomPokemonReader(),
                new RandomPokemonDeserializer(),
                new RandomPokemonAdapter());
        mainFrame.put("toggle", new ToggleCommand(loader, mainFrame.getDisplay()));
        mainFrame.setVisible(true);
    }
}
