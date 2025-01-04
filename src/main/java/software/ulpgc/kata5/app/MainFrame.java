package software.ulpgc.kata5.app;

import software.ulpgc.kata5.architecture.control.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private SwingPokemonDisplay display;

    public MainFrame() {
        commands = new HashMap<>();
        setLayout(new BorderLayout());
        setTitle("Kata_5");
        setSize(850, 275);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        display = new SwingPokemonDisplay();
        add(BorderLayout.CENTER, display);
        add(BorderLayout.SOUTH, button());
    }

    public void put(String key, Command value) {
        commands.put(key, value);
    }

    public SwingPokemonDisplay getDisplay() {
        return display;
    }

    private Component button() {
        JButton button = new JButton("Generate a Pokemon");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (commands.containsKey("toggle")) commands.get("toggle").execute();
            }
        });
        return button;
    }
}
