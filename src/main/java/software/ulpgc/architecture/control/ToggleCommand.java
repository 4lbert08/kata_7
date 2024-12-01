package software.ulpgc.architecture.control;

import software.ulpgc.architecture.io.PokemonLoader;
import software.ulpgc.architecture.model.Pokemon;
import software.ulpgc.architecture.view.PokemonDisplay;

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
