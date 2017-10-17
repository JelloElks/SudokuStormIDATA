package com.JelloElks;

import java.util.Random;

public class Sudoku {

    private static int[][] grid = new int[4][4];
    private static String s;
    private static Random rand = new Random();
    private static Random rand2 = new Random();
    private static int max = 4;
    private static int min = 1;

    static void Create(int[][] grid) {

        for (int i = 0; i < 4; i++) {
            //System.out.println("i: "+i);

            for (int j = 0; j < 4; j++) {
                grid[i][j] = (i * 2 + i / 2 + j) % 4 + 1;
                //System.out.println(grid[i][j] = (i * 2 + i / 2 + j) % 4 + 1);
            }
        }
        ChangeCell(grid);
    }

    static void ChangeCell(int[][] grid) {

        int findVal1 = rand.nextInt(4)+1;
        int findVal2 = rand2.nextInt(4)+1;

        int xParam1, yParam1, xParam2, yParam2;
        xParam1 = yParam1 = xParam2 = yParam2 = 0;

        for (int i = 0; i < 4; i += 2) {

            for (int k = 0; k < 4; k += 2) {

                for (int j = 0; j < 2; j++) {

                    for (int z = 0; z < 2; z++) {
                        if (grid[i + j][k + z] == findVal1) {
                            xParam1 = i + j;
                            yParam1 = k + z;
                        }

                        if (grid[i + j][k + z] == findVal2) {
                            xParam2 = i + j;
                            yParam2 = k + z;
                        }

                    }
                }
                grid[xParam1][yParam1] = findVal2;
                grid[xParam2][yParam2] = findVal1;
            }
        }

        delRand(grid);
    }

    private static void delRand(int[][] grid) {
        for (int i = 0; i < 4; i++) {
            int randomPosition = (int) Math.floor(Math.random() * grid.length);
            //int random = rand.nextInt(4);
            grid[i][randomPosition] = 0;
        }
        Draw(grid,s);
    }

    static void Draw(int[][] grid, String _s) {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                //System.out.println(grid[x][y]);
                s += (Integer.toString(grid[x][y])+" ");
            }
            s += "\n";
        }
        System.out.println(s);
        //Test
        //_s = s;
        //s = "";
    }


    //Not in use
    /*
    static void Update(int[][] grid, int shuffleLevel){
        for (int repeat = 0; repeat < shuffleLevel; repeat++) {
            //ChangeCell(grid, rand.nextInt(4)+1, rand2.nextInt(4)+1);
        }

    }
    */


    public static void main(String[] args) {

        s = "";
        Create(grid);
        //Update(grid,10);
        //ChangeCell(grid);
        //Draw(grid,s);
        //delRand(grid);

        //ChangeCell(grid, 1, 1);
        //Draw(grid, "a");

    }
}