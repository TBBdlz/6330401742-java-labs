/*
  MatrixDisplay designs to let user input the matrix
  input format:
  <row dimension> <column dimension>
  next program will ask you to input matrix by row
  in dimension that user give program.
  eg. input
  [1]input dimension:2 2
  [2]input row1:1 2
  [3]input row2:3 4
  after user done input program will rearrange 
  and print variety of matrix to the screen
  <row matrix> <column matrix> <inverse row matrix>
  <inverse column matrix> <zig-zag matrix>
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 22 January 2021
*/
package yingyongwatthanakit.metee.lab4;

import java.util.Scanner;

public class MatrixDisplay {
    static int[][] matrix;
    static int rowDimension, columnDimension;
    public static void main(String[] args) {
        inputMatrix();
        showMatrix();
        showMatrixByRow();
        showMatrixByColumn();
        showMatrixByRowBackward();
        showMatrixByColumnBackward();
        showMatrixByRowZigzag();
    }

    static void inputMatrix() {
        // input row dimension and column dimension
        Scanner inputDimension = new Scanner(System.in);
        System.out.println("Enter number of row then number of column a matrix:");
        rowDimension = inputDimension.nextInt();
        columnDimension = inputDimension.nextInt();
        while ((rowDimension <= 0) || (columnDimension <= 0)) { // catching error code
            Scanner catchError = new Scanner(System.in);
            System.out.println("Number of column and row must be positive");
            rowDimension = catchError.nextInt();
            columnDimension = catchError.nextInt();
        }
        // input data in matrix
        matrix = new int[rowDimension][columnDimension];
        System.out.println("Enter your matrix by row.");
        for (int i = 0; i < rowDimension; i++) {
            Scanner inputData = new Scanner(System.in);
            String rawData = inputData.nextLine();
            String[] dataStr = rawData.split(" ");
            if (dataStr.length != columnDimension) { // more error catching code
                System.out.println("Matrix has " + rowDimension + " x " + columnDimension + " dimensions");
                System.out.println("Please enter correct matrix dimension");
                i--;
                continue;
            }
            int[] dataArray = new int[columnDimension];
            for (int j = 0; j < columnDimension; j++) {
                dataArray[j] = Integer.parseInt(dataStr[j]);
                matrix[i][j] = dataArray[j];
            }
        }
    }

    static void showMatrix() {
        System.out.println("Showing original matrix:");
        for (int i = 0; i < rowDimension; i++) {
            String[] dataArray = new String[columnDimension];
            for (int j = 0; j < columnDimension; j++) {
                dataArray[j] = String.valueOf(matrix[i][j]);
            }
            String row = String.join(" ", dataArray);
            System.out.println(row);
        }
    }

    static void showMatrixByRow() {
        String[] longArray = new String[rowDimension * columnDimension];
        int index = 0;
        for (int i = 0; i < rowDimension; i++) {
            for (int j = 0; j < columnDimension; j++) {
                longArray[index] = String.valueOf(matrix[i][j]);
                index++;
            }
        }
        String longRow = String.join(" ", longArray);
        System.out.println("Show matrix by rows : " + longRow);
    }

    static void showMatrixByColumn() {
        String[] verticalArray = new String[rowDimension * columnDimension];
        int index = 0;
        for (int j = 0; j < columnDimension; j++) {
            for (int i = 0; i < rowDimension; i++) {
                verticalArray[index] = String.valueOf(matrix[i][j]);
                index++;
            }
        }
        String verticalData = String.join(" ", verticalArray);
        System.out.println("Show matrix by columns : " + verticalData);
    }

    static void showMatrixByRowBackward() {
        String[] inverseLongArray = new String[rowDimension * columnDimension];
        int index = 0;
        for (int i = (rowDimension - 1); i >= 0; i--) {
            for (int j = (columnDimension - 1); j >= 0; j--) {
                inverseLongArray[index] = String.valueOf(matrix[i][j]);
                index++;
            }
        }
        String inverseLongRow = String.join(" ", inverseLongArray);
        System.out.println("Show matrix by rows backward : " + inverseLongRow);
    }

    static void showMatrixByColumnBackward() {
        String[] inverseVerticalArray = new String[rowDimension * columnDimension];
        int index = 0;
        for (int j = (columnDimension - 1); j >= 0; j--) {
            for (int i = (rowDimension - 1); i >= 0; i--) {
                inverseVerticalArray[index] = String.valueOf(matrix[i][j]);
                index++;
            }
        }
        String inverseVerticalData = String.join(" ", inverseVerticalArray);
        System.out.println("Show matrix by columns backward : " + inverseVerticalData);
    }

    static void showMatrixByRowZigzag() {
        String[] zigzagArray = new String[rowDimension * columnDimension];
        int index = 0;
        for (int i = 0; i < rowDimension; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < columnDimension; j++) {
                    zigzagArray[index] = String.valueOf(matrix[i][j]);
                    index++;
                }
            } else {
                for (int j = (columnDimension - 1); j >= 0; j--) {
                    zigzagArray[index] = String.valueOf(matrix[i][j]);
                    index++;
                }
            }
        }
        String zigzagData = String.join(" ", zigzagArray);
        System.out.println("Show matrix by rows zigzag : " + zigzagData);
    }
}