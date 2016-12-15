/**
 * Created by Yingzhi on 13/01/2016.
 */
package im.irrational;

import nc.Game;
import nc.player.AbstractPlayer;

import java.util.Random;

public class IrrationalPlayer extends AbstractPlayer {
    private final Game game;
    private int action;

    public IrrationalPlayer(Random random, Game game) {
        super(random);
        this.game = game;
        action = -1;
    }

    @Override
    public int getAction() {
        final int[][] grid = game.getGrid();
        if (grid[0][0] == Game.EMPTY) {
            action = Game.LEFT;
        }
        else if (canMoveUp(grid)){
            action = Game.UP;
            System.out.println("UP");
        }
        else if (canMoveLeft(grid)){
            action = Game.LEFT;
            System.out.println("LEFT");
        }
        else if (canMoveRight(grid)){
            action = Game.RIGHT;
            System.out.println("RIGHT");
        }
        else{
            action = Game.DOWN;
            System.out.println("DOWN");
        }
        //wait
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return action;
    }

    private boolean canMoveRight(final int[][] grid) {
        for(int row = 0; row < grid.length; row++){
            for (int column=grid[row].length-2; column>=0; column--){
                if(grid[row][column] != Game.EMPTY) {
                    for (int c = column + 1; c < grid[row].length; c++) {
                        if(grid[row][c] == grid[row][column] || grid[row][c] ==Game.EMPTY){
                            return true;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean canMoveLeft(final int[][] grid) {
        for(int row = 0; row<grid.length; row++){
            for(int column=1; column<grid[row].length; column++){
                if(grid[row][column] != Game.EMPTY){
                    for(int c = column-1; c >=0; c--){
                        if (grid[row][c] == Game.EMPTY){
                            return true;
                        }
                        else if(grid[row][c] == grid[row][column]){
                            return true;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean canMoveUp(final int[][] grid) {
        for(int row = 1; row<grid.length; row++){
            for(int column=0; column<grid[row].length; column++){
                if(grid[row][column] != Game.EMPTY){
                    for(int r = row-1; r >=0; r--){
                        if(grid[r][column]==Game.EMPTY){
                            return true;
                        }
                        else if(grid[r][column] == grid[row][column]) {
                            return true;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }

//    private static final boolean isTileInGrid(int[][] grid, int row, int column) {
//        return row > -1 &&
//                row < grid.length &&
//                column > -1 &&
//                column < grid[row].length;
//    }
}
