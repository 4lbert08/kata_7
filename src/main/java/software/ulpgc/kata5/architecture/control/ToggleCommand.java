package software.ulpgc.kata5.architecture.control;

import software.ulpgc.kata5.architecture.io.PokemonLoader;
import software.ulpgc.kata5.architecture.model.Pokemon;
import software.ulpgc.kata5.architecture.view.PokemonDisplay;

public class ToggleCommand implements Command{
    private final PokemonLoader loader;
    private final PokemonDisplay display;

    public ToggleCommand(PokemonLoader loader, PokemonDisplay display) {
        this.loader = loader;
        this.display = display;
    }

    @Override
    public void execute() {
        Pokemon pokemon = loader.load();
        if(pokemon!=null)display.show(pokemon);
    }
}
