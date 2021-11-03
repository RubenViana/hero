import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private int x,y;
    public Hero(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveUp() {
        y --;
    }

    public void moveDown() {
        y ++;
    }

    public void moveRight() {
        x ++;
    }

    public void moveLeft() {
        x --;
    }

    public void draw( Screen scr) {
        Screen s = scr;
        s.setCharacter(x, y, TextCharacter.fromCharacter('H')[0]);
    }

}
