import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;


import javax.management.monitor.MonitorSettingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width, height;
    private Hero hero;
    private Monster monster;
    private List<Wall> walls;
    private List<Coin> coins;
    public boolean gameOver = false;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10, 10);
        monster = new Monster(2,2);
        this.walls = createWalls();
        this.coins = createCoins();
    }

    public void processKey(KeyStroke k) {
        switch (k.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp()); moveMonster(); verifyMonsterCollisions(hero.getPosition());
                break;
            case ArrowDown:
                moveHero(hero.moveDown()); moveMonster(); verifyMonsterCollisions(hero.getPosition());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft()); moveMonster(); verifyMonsterCollisions(hero.getPosition());
                break;
            case ArrowRight:
                moveHero(hero.moveRight()); moveMonster(); verifyMonsterCollisions(hero.getPosition());
                break;
        }
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall (c,0));
            walls.add(new Wall (c,height - 1 ));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0,r));
            walls.add(new Wall (width - 1, r ));
        }
        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Coin c =new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            if (c.getPosition().equals(hero.getPosition()))
                continue;
            coins.add(c);
        }
        return coins;
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#00ff80"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        monster.draw(graphics);
        hero.draw(graphics);
    }

    private void moveHero(Position position) {
        if (canMoveHero(position)) {
            hero.setPosition(position);
            retrieveCoins();
        }
    }
    private void moveMonster(){
        monster.setPosition(new Position(monster.getX(), monster.getY())); // falta implementar o move do 'M' !
    }

    private void  verifyMonsterCollisions(Position position){
        if (monster.getPosition().equals(position)) {
            gameOver = true;
            System.out.println("YOU DIED !");
        }
    }

    private boolean canMoveHero(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }
    private void retrieveCoins(){
        if (coins.size() == 0) {
            gameOver = true;
            System.out.println("YOU RETRIEVED ALL THE COINS !");
        }
        for (Coin coin : coins)
            if (hero.getPosition().equals(coin.getPosition())){
                coins.remove(coin);
                hero.coins ++;
                break;
            }
    }
}
