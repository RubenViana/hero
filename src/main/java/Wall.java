import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
    private Position position;
    public Wall(int c, int i) {
        position = new Position(c,i);
    }
    public void draw( TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#a7090f"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "*");
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

}
