import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

abstract class Element {
    public Position position;
    public Element (int x, int y){
        position = new Position(x,y);
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public Position getPosition() {
        return position;
    }

    public int getX(){
        return position.getX();
    }
    public int getY(){
        return position.getY();
    }

    abstract void draw (TextGraphics graphics);

    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }
    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveRight() {return new Position(position.getX() + 1, position.getY());}
    public Position moveLeft() {return new Position(position.getX() - 1, position.getY());}
}
