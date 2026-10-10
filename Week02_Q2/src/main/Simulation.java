package main;

import entity.CancerCell;
import entity.Cell;
import entity.EaterCell;
import entity.WhiteBloodCell;

import java.util.Scanner;

public class Simulation {
    public static Cell[] slide;  // The microscope slide, containing cells under experiment.

    public static Cell findAliveCellAndDrain(EaterCell c, String s){
        for (int i = 0; i < slide.length; i++){
            Cell myCell = slide[i];
            String classInSlide = "";
            if(myCell != null){
                classInSlide = (myCell.getClass() + "");
            }
            if(myCell != null && myCell.getHp() > 0 && classInSlide.equals("class entity." + s)) {
                c.suck(slide[i]);
                return slide[i];
            }
        }
        return null;
    }

    public static void mutateAllCancerCells(){
        //TODO: Implement this method
        for (Cell cell : slide) {
            if (cell instanceof CancerCell) {
                ((CancerCell) cell).mutate(); // If cell is a cancer cell, call the mutate method from CancerCell "(CancerCell) Cell"
            }
        }
		
    }

    public static boolean allCancerDead(){
        //TODO: Implement this method
        for (Cell cell : slide) {
            if (cell instanceof CancerCell && cell.getHp() > 0) return false; // If cell is a cancer cell and still has hp, it is not dead.
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of Cancer cells.");
        int cancerCells = Integer.parseInt(s.nextLine());

        System.out.println("Enter the number of White blood cells you will use to fight the Cancer cells.");
        int wbCells = Integer.parseInt(s.nextLine());

        System.out.println("Enter the number of normal cells for Cancer cells to feed on.");
        int normalCells = Integer.parseInt(s.nextLine());

        int totalCells = cancerCells + wbCells + normalCells;
        slide = new Cell[totalCells];

        // Set up the default cancer cell characteristics
        int slideIndex = 0;
        System.out.println("Enter the number of time steps for a Cancer cell to start dividing.");
        int stepsToDivide = Integer.parseInt(s.nextLine());

        System.out.println("Enter the speed that a Cancer cell eats another cell.");
        int eatingSpeed = Integer.parseInt(s.nextLine());

        //put Cancer Cells into the microscope slide.
        for(int i = 1; i <= cancerCells; i++) {
            slide[slideIndex++] = new CancerCell(stepsToDivide,eatingSpeed);
        }

        //put white blood Cells into the microscope slide.
        for (int i=1; i <= wbCells; i++) {
            slide[slideIndex++] = new WhiteBloodCell();
        }

        //put normal Cells into the microscope slide.
        for (int i = 1; i <= normalCells; i++){
            slide[slideIndex++] = new Cell();
        }

        while (true) {
            for (int i = 0 ; i < slide.length; i++) {
                if (slide[i] instanceof CancerCell) {
                    CancerCell slideCell = (CancerCell) (slide[i]);

                    Cell c = findAliveCellAndDrain(slideCell,"Cell");
                    if (((CancerCell) slide[i]).isDivideSuccess()) {
                        System.out.println("Cannot stop Cancer Cell division in time");
                        System.out.println("End Simulation");
                        return;
                    }
                } else if (slide[i] instanceof WhiteBloodCell) {
                    WhiteBloodCell slideCell = (WhiteBloodCell) (slide[i]);
                    Cell c = findAliveCellAndDrain(slideCell,"CancerCell");
                } else {
                    //Normal cell does nothing
                }



            }

            if (allCancerDead()) {
                System.out.println("Successfully stop Cancer Cell division in time");
                System.out.println("End Simulation");
                return;
            }

            System.out.println("Do you want Cancer Cells to mutate: 0 = No, 1 = Yes");
            int mutate = Integer.parseInt(s.nextLine());
            if (mutate == 1) {
                mutateAllCancerCells();
            }
        }
    }
}
