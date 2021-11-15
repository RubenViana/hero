import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class Wall extends Element{
    public Wall(int c, int i) {
        super(c,i);
    }
    public void draw( TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#a7090f"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "*");
    }
}
