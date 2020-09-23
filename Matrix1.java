package com.company;

import java.util.Random;

class Matrix {

    int n, m;
    int[][] mainMatrix;

    public Matrix(int n, int m)
    {
        this.n = n;
        this.m = m;
        this.mainMatrix = new int[this.n][this.m];
    }

    public Matrix(int [][] paramMatrix)
    {
        this.n = paramMatrix.length;
        this.m = paramMatrix[0].length;
        this.mainMatrix = paramMatrix;
    }

    public int getElement(int n, int m)
    {
        return this.mainMatrix[n][m];
    }

    public void setElement(int n, int m, int value)
    {
        this.mainMatrix[n][m] = value;
    }

    public int getVerticalLength() //количество строк
    {
        return this.mainMatrix.length;
    }

    public int getHorizontalLength() //количество столбцов
    {
        return this.mainMatrix[0].length;
    }

    public void fillRandomValues()
    {
        Random rand = new Random();

        for(int i = 0; i < this.n; i++)
        {
            for(int j = 0; j < this.m; j++)
            {
                this.mainMatrix[i][j] = rand.nextInt(100);
            }
        }
    }

    public void displayMatrix()
    {
        for(int i = 0; i < this.n; i++)
        {
            for(int j = 0; j < this.m; j++)
            {
                System.out.print(this.mainMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transpone(int[][] paramMatrix) //транспонирование
    {
        int[][] qweMatrix = new int[paramMatrix[0].length][paramMatrix.length];
        for(int i = 0; i < paramMatrix[0].length; i++)
        {
            for(int j = 0; j < paramMatrix.length; j++)
            {
                qweMatrix[i][j] = paramMatrix[j][i];
            }
        }
        return qweMatrix;
    }
/*
    public static Matrix transpone(Matrix paramMatrix)
    {
        Matrix tmpMatrix = new Matrix(paramMatrix.m, paramMatrix.n);
        for(int i = 0; i < paramMatrix.m; i++)
        {
            for(int j = 0; j < paramMatrix.n; j++)
            {
                tmpMatrix.setElement(i, j, paramMatrix.getElement(j, i));
            }
        }
        return tmpMatrix;
    }
*/
    public static Matrix add(Matrix first, Matrix second)  {
            Matrix qweMatrix = new Matrix(first.getVerticalLength(), second.getHorizontalLength());
            for (int i = 0; i < qweMatrix.getHorizontalLength(); i++) {
                for(int j = 0; j < qweMatrix.getVerticalLength(); j++){
                    qweMatrix.setElement(i, j, first.getElement(i, j) + second.getElement(i, j));
                }
            }
            return qweMatrix;

    }
/*
    public static Matrix subtract (Matrix first, Matrix second) {
        if(first.getVerticalLength() != second.getVerticalLength() ||
                first.getHorizontalLength() != second.getHorizontalLength())
            throw  new NotEqualLengthsOfMatrixException();
        else {
            Matrix qweMatrix = new Matrix(first.getVerticalLength(), second.getHorizontalLength());
            for (int i = 0; i < qweMatrix.getHorizontalLength(); i++) {
                for(int j = 0; j < qweMatrix.getVerticalLength(); j++){
                    qweMatrix.setElement(i, j, first.getElement(i, j) - second.getElement(i, j));
                }
            }
            return qweMatrix;
        }
    }

 */
    public static Matrix multiply (Matrix first, Matrix second) throws NotEqualLengthsOfMatrixException {
        Matrix qweMatrix;
        int n = first.getVerticalLength();
        int m = second.getHorizontalLength();
        int o = second.getVerticalLength();
        int[][] tmpArr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for (int k = 0; k < o; k++) {
                    tmpArr[i][j] += first.getElement(i, k) * second.getElement(k, j);
                    }
                }
            }
            qweMatrix = new Matrix(tmpArr);
            return qweMatrix;
        }
    }
}


//class NotEqualLengthsOfMatrixException extends Exception {}


class MatrixMain {

    public static void main(String[] args)
    {
        //int[][] A = {{-1, 1, -1}, {1, -1, 1}, {-1, 1, -1}};
        //int[][] B = {{1, -1, 1}, {-1, 1, -1}, {1, -1, 1}};

        int[][] A =   {{33,34,12},
                {33,19,10},
                {12,14,17},
                {84,24,51},
                {43,71,21}};

        int[][] B =  {{10,11,34,55},
                {33,45,17,81},
                {45,63,12,16}};




        Matrix x = new Matrix(A);
        Matrix y = new Matrix(B);
        x.displayMatrix();
        y.displayMatrix();

        Matrix mM = Matrix.multiply(x, y);

        mM.displayMatrix();

    }
}


