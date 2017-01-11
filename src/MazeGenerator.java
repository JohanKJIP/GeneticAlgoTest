import java.util.Random;

/**
 * Created by Johan on 17/12/2016.
 */
public class MazeGenerator {
    private Random rand = new Random();
    private Cell[][] grid;
    private static int HEIGHT;
    private static int WIDTH;

    public MazeGenerator(int width,int height) {
        this.HEIGHT = height;
        this.WIDTH = width;
        grid = new Cell[width+1][height+1];
        mapGenerator();
    }

    public boolean isWall(int x, int y) {
        return grid[x][y].getIsWall();
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public static int getHeight() {
        return HEIGHT;
    }

    public static int getWidth() {
        return WIDTH;
    }

    public boolean randomBool() {
        return rand.nextBoolean();
    }

    public void randomMazeGenerator() {
        for (int i=0; i<HEIGHT-1 ; i+=5) {
            for (int j=0; j<WIDTH-1; j+=5) {
                grid[i][j] = new Cell(randomBool());
            }
        }
    }

    public void mapGenerator() {
        //fill with empty cells
        for(int i=0; i<WIDTH; i++) {
            for(int j=0; j<HEIGHT; j++) {
                grid[i][j] = new Cell(false);
            }
        }
        //make walls
        for (int i = 50; i<WIDTH-50; i += 5) {
            grid[i][30] = new Cell(true);
        }
        for (int i = 30; i<HEIGHT-300; i += 5) {
            grid[50][i] = new Cell(true);
            grid[WIDTH - 50][i] = new Cell(true);
        }
        //make obstacles
        for (int i = 380; i<WIDTH-380; i += 5) { //first
            grid[i][150] = new Cell(true);
        }
        for (int i = 480; i<WIDTH-50; i += 5) {
            grid[i][150] = new Cell(true);
        }
        for (int i = 50; i<WIDTH-480; i += 5) {
            grid[i][150] = new Cell(true);
        }
        for (int i = WIDTH/2+20; i<WIDTH-50; i += 5) { //second
            grid[i][250] = new Cell(true);
        }
        for (int i = 50; i<WIDTH/2-20; i += 5) {
            grid[i][250] = new Cell(true);
        }
        for (int i = 380; i<WIDTH-380; i += 5) { //third
            grid[i][350] = new Cell(true);
        }
        for (int i = 480; i<WIDTH-50; i += 5) {
            grid[i][350] = new Cell(true);
        }
        for (int i = 50; i<WIDTH-480; i += 5) {
            grid[i][350] = new Cell(true);
        }
        //Random OLD VERSION
        /*make obstacles
        for (int i=60; i<=HEIGHT-60; i += 10) {
            for (int j=40; j<=WIDTH-60; j += 10) {
                grid[i][j] = new Cell(randomBool());
            }
        }*/
        //make opening
        for (int i=WIDTH/2-50; i<WIDTH/2+50; i++) {
            for (int j=60; j<130 ; j++) {
                grid[i][j] = new Cell(false);
            }
            grid[i][HEIGHT-50] = new Cell(false);
        }
    }
}