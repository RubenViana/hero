import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Hero extends Element{
    public Hero(int x, int y){
        super(x,y);
    }
    public void draw( TextGraphics graphics){

        graphics.setForegroundColor(TextColor.Factory.fromString("#407294"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
        //graphics.putString(new TerminalPosition(position.getX() * 2, position.getY() * 2), "\\/");
        //graphics.putString(new TerminalPosition(position.getX() * 2, position.getY() * 2 + 1), "/\\");
    }
}
