import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;


import java.io.IOException;

public class Arena {
    private int width, height;
    private Hero hero;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10,10);
    }

    public void processKey(KeyStroke k) {
        switch (k.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
        }
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width  , height), ' ');
        hero.draw(graphics);
    }
    private void moveHero(Position position) {
        if (canMoveHero(position))
            hero.setPosition(position);
    }

    private boolean canMoveHero(Position position) {
        if (position.getX() < 0 || position.getX() > width - 1 || position.getY() < 0 || position.getY() > height - 1)
            return false;
        return true;
    }


}
