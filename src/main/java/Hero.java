import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Hero {
    private Position position;
    public Hero(int x, int y){
        position = new Position(x,y);
    }


    public int getX() {
        return position.getX();
    }

    public void setX(int x) {
        position.setX(x);
    }

    public int getY() {
        return position.getY();
    }

    public void setY(int y) {
        position.setY(y);
    }

    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }

    public Position moveRight() {return new Position(position.getX() + 1, position.getY());}

    public Position moveLeft() {return new Position(position.getX() - 1, position.getY());}

    public void draw( Screen scr) {
        Screen s = scr;
        s.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('H')[0]);
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
