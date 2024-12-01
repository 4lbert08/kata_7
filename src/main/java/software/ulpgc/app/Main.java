package software.ulpgc.app;

import software.ulpgc.architecture.control.ToggleCommand;
import software.ulpgc.architecture.io.PokemonLoader;
import software.ulpgc.architecture.io.RandomPokemonAdapter;
import software.ulpgc.architecture.io.RandomPokemonDeserializer;
import software.ulpgc.architecture.io.RandomPokemonReader;

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
