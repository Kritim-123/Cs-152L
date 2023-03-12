import java.awt.*;

/**
 * Sand lab adapted from http://nifty.stanford.edu/2017/feinberg-falling-sand/
 *
 * Student name: Kritim Bastola
 *
 * METAL can stay at a fixed position.
 * METAL can hold sand, base and water, but when mixed with acid it disappears.
 * SAND can move down in water
 * ACID reacts with base to give water
 * STONE moves down in water
 *
 *
 * TODO: Document expected behavior of various materials here
 */
public class SandLab {

    /**
     * Enum for material types of the particles
     */
    public enum Material {
        EMPTY,
        METAL,

        SAND,

        WATER,

        ACID,

        STONE,

        BASE

        //TODO: add constants for additional particle types here

    }

    /** grid of particles of various materials*/
    private Material[][] grid;

    /** The display window */
    private SandDisplay display;

    /**
     * Create a new SandLab of given size.
     * @param numRows number of rows
     * @param numCols number of columns
     */
    public SandLab(int numRows, int numCols) {
        // TODO: Include names for all Materials used in simulation
        //       (Can you do it without manually listing them all?)
        String[] names = new String[]{"Empty", "Metal", "SAND", "WATER",
                "ACID", "STONE", "BASE"};
        display = new SandDisplay("Falling Sand", numRows, numCols, names);

        // TODO: initialize grid with empty cells
        grid = new Material[numRows][numCols];
        for (int i =0; i<numRows; i++){
            for (int j =0; j<numCols;j++){
                grid[i][j] = Material.EMPTY;
            }
        }
    }

    /**
     * called when the user clicks on a location using the given tool
     * @param row Row of location
     * @param col Column of location
     * @param tool Name of selected tool
     */
    public void locationClicked(int row, int col, String tool) {
        // TODO: update grid location with selected material
        grid[row][col] = Material.valueOf(tool);
    }

    /**
     * copies each element of grid into the display
     */
    public void updateDisplay() {
        // TODO: update display with colors based on grid contents
        for (int row=0; row< grid.length; row++){
            for (int col=0; col<grid[0].length; col++){

                switch (grid[row][col]){
                    case EMPTY -> display.setColor(row,col,Color.BLACK);

                    case STONE -> display.setColor(row, col, Color.darkGray);

                    case METAL -> display.setColor(row,col,Color.GRAY);

                    case SAND -> display.setColor(row,col,Color.YELLOW);

                    case WATER -> display.setColor(row,col,Color.BLUE);

                    case ACID -> display.setColor(row,col,Color.CYAN);

                    case BASE -> display.setColor(row,col,Color.GREEN);


                }

            }
        }
    }

    /**
     * Update the simulation by one step.
     * Called repeatedly.
     * Causes one random particle to maybe do something
     */
    public void step() {

        // TODO: select random location and update the particle if relevant
        int randomRow = (int) (Math.random()* grid.length-1);
        int randomCol = (int) (Math.random()* grid[0].length);



        while(randomCol== 0 || randomCol == grid[0].length-1){
            randomCol = (int) (Math.random()* grid[0].length);
        }



        switch (grid[randomRow][randomCol]){

            case SAND -> {
                if (grid[randomRow+1][randomCol]==Material.EMPTY){
                    grid[randomRow+1][randomCol]= Material.SAND;
                    grid[randomRow][randomCol] = Material.EMPTY;

                }
                if(grid[randomRow+1][randomCol]==Material.WATER){
                    grid[randomRow+1][randomCol]= Material.SAND;
                    grid[randomRow][randomCol] = Material.WATER;
                }


            }
            case WATER -> {
                if (grid[randomRow+1][randomCol]==Material.EMPTY){
                    grid[randomRow+1][randomCol]= Material.WATER;
                    grid[randomRow][randomCol]= Material.EMPTY;


                }
                if(grid[randomRow][randomCol-1] == Material.EMPTY){
                    grid[randomRow][randomCol-1] = Material.WATER;
                    grid[randomRow][randomCol+1] = Material.EMPTY;

                }
                if(grid[randomRow][randomCol+1] == Material.EMPTY){
                    grid[randomRow][randomCol+1] = Material.WATER;
                    grid[randomRow][randomCol-1]= Material.EMPTY;

                }


            }

            case ACID -> {
                if (grid[randomRow+1][randomCol]==Material.EMPTY){
                    grid[randomRow+1][randomCol]= Material.ACID;
                    grid[randomRow][randomCol]= Material.EMPTY;
                }

                if (grid[randomRow+1][randomCol]==Material.METAL ||
                        grid[randomRow+1][randomCol]==Material.STONE){

                    grid[randomRow+1][randomCol]= Material.ACID;

                }

                if(grid[randomRow][randomCol+1] == Material.METAL ||
                        grid[randomRow][randomCol+1] == Material.STONE)
                {
                    grid[randomRow][randomCol+1] = Material.ACID;
                    grid[randomRow][randomCol-1]= Material.EMPTY;

                }
                if(grid[randomRow][randomCol-1] == Material.METAL ||
                        grid[randomRow][randomCol-1] == Material.STONE){

                    grid[randomRow][randomCol-1] = Material.ACID;
                    grid[randomRow][randomCol+1]= Material.EMPTY;

                }

                if(grid[randomRow+1][randomCol]==Material.WATER){
                    grid[randomRow+1][randomCol]= Material.ACID;
                    grid[randomRow][randomCol] = Material.WATER;
                }


            }

            case STONE -> {
                if (grid[randomRow+1][randomCol]==Material.EMPTY){
                    grid[randomRow+1][randomCol]= Material.STONE;
                    grid[randomRow][randomCol]= Material.EMPTY;
                }
                if (grid[randomRow+1][randomCol]==Material.WATER){
                    grid[randomRow+1][randomCol]= Material.STONE;
                    grid[randomRow][randomCol]= Material.WATER;
                }

            }

            case BASE -> {
                if (grid[randomRow+1][randomCol]==Material.EMPTY){
                    grid[randomRow+1][randomCol]= Material.BASE;
                    grid[randomRow][randomCol]= Material.EMPTY;

            }
                if(grid[randomRow+1][randomCol]==Material.ACID){
                    grid[randomRow+1][randomCol] = Material.WATER;
                    grid[randomRow][randomCol] = Material.EMPTY;
                }

                if (grid[randomRow][randomCol-1]==Material.ACID){
                    grid[randomRow][randomCol-1] = Material.WATER;
                    grid[randomRow][randomCol+1] = Material.EMPTY;
                }

                if(grid[randomRow][randomCol+1]==Material.ACID){
                    grid[randomRow][randomCol+1] = Material.WATER;
                    grid[randomRow][randomCol-1] = Material.EMPTY;
                }

                if(grid[randomRow+1][randomCol]==Material.WATER){
                    grid[randomRow+1][randomCol]= Material.BASE;
                    grid[randomRow][randomCol] = Material.WATER;
                }


            }


        }

    }

    /**
     * Run the SandLab particle simulation.
     *
     * DO NOT MODIFY THIS METHOD!
     */
    public void run() {
        // keep updating as long as the program is running
        while (true) {
            // update some number of particles, as determined by the speed
            // slider
            for (int i = 0; i < display.getSpeed(); i++) {
                step();
            }
            // Update the display object's colors
            updateDisplay();
            // wait for redrawing and for mouse events
            display.repaintAndPause(1);

            int[] mouseLoc = display.getMouseLocation();
            //test if mouse clicked
            if (mouseLoc != null) {
                locationClicked(mouseLoc[0], mouseLoc[1],
                        display.getTool().toUpperCase());
            }
        }
    }

    /** Creates a new SandLab and sets it running */
    public static void main(String[] args) {
        SandLab lab = new SandLab(120, 80);
        lab.run();
    }
}
