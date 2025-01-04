package software.ulpgc.kata5.app;

import software.ulpgc.kata5.architecture.model.Pokemon;
import software.ulpgc.kata5.architecture.view.PokemonDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;

public class SwingPokemonDisplay extends JPanel implements PokemonDisplay {
    private static final int IMAGE_WIDTH = 150;
    private static final int IMAGE_HEIGHT = 150;

    public SwingPokemonDisplay() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
    }

    @Override
    public void show(Pokemon pokemon) {
        removeAll();
        add(getSpritePanel(pokemon.normalSprite(), pokemon.name() + " (Normal)"));
        add(getSpritePanel(pokemon.shinySprite(), pokemon.name() + " (Shiny)"));
        add(new JLabel("Height: " + pokemon.height() + " Weight: " + pokemon.weight() + "lb" , SwingConstants.CENTER));
        addAbilitiesPanel(pokemon);
        revalidate();
        repaint();
    }

    private void addAbilitiesPanel(Pokemon pokemon) {
        JPanel abilitiesPanel = new JPanel(new BorderLayout());
        JLabel abilitiesLabel = new JLabel("Abilities: " + pokemon.abilities(), SwingConstants.CENTER);
        abilitiesPanel.add(abilitiesLabel, BorderLayout.SOUTH);
        add(abilitiesPanel);
    }

    private JPanel getSpritePanel(byte[] sprite, String text) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel imageLabel = new JLabel();
        JLabel textLabel = new JLabel(text, SwingConstants.CENTER);

        setImageToLabel(imageLabel, sprite);

        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(textLabel, BorderLayout.SOUTH);
        return panel;
    }

    private void setImageToLabel(JLabel label, byte[] sprite) {
        if (sprite != null && sprite.length > 0) {
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(sprite);
                Image image = ImageIO.read(bis);
                if (image != null) {
                    Image scaledImage = image.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(scaledImage));
                } else {
                    label.setIcon(null);
                    label.setText("Image not available");
                }
            } catch (Exception e) {
                label.setIcon(null);
                label.setText("Image not available");
                e.printStackTrace();
            }
        } else {
            label.setIcon(null);
            label.setText("No image provided");
        }
    }
}
