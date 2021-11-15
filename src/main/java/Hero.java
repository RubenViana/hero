import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Hero extends Element{
    public int coins = 0;
    public Hero(int x, int y){
        super(x,y);
    }
    public void draw( TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#407294"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(40, 20), new TerminalSize(40, 20 + 3), ' ');
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(new TerminalPosition(3, 21 ), "Coins retrieved : " + coins);

    }
}
