import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
    private int x, y;
    public Wall(int c, int i) {
        x = c;
        y = i;
    }
    public void draw( TextGraphics graphics) {

        graphics.setForegroundColor(TextColor.Factory.fromString("#0"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(x, y), "#");

    }
}
