import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private Screen screen;
    private Arena arena;
    private TextGraphics graphics;
    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(100, 50);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            graphics = screen.newTextGraphics();
        } catch (IOException e) {
            e.printStackTrace();
        }
        arena = new Arena(100, 50);
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    public void run() throws IOException {
        while(arena.getRunning()) {
            draw();
            com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
            arena.processKey(key);
        }
        screen.close();
    }
}
