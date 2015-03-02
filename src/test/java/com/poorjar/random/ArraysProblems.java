package com.poorjar.random;

import org.junit.Test;

public class ArraysProblems
{
    @Test
    public void arrayProblem()
    {
        int[] inputArray = { 1, 5, 3, 7, 2, 8, 3, 4, 5 , 8, 3, 9, 7, 2, 9 };
        minDistance(9, 8, inputArray);

    }

    private static void minDistance(int x, int y, int[] inputArray)
    {
        int xPos = -1;
        int yPos = -1;
        int index = 0;
        int minDistance = 5000;

        for (int i : inputArray)
        {
            if (i == x)
            {
                xPos = index;
            }
            if (i == y)
            {
                yPos = index;
            }

            if (xPos != yPos && xPos > 0 && yPos > 0)
            {
                int tempDistance = 0;
                if (xPos > yPos)
                {
                    tempDistance = (xPos - yPos);
                }
                if (yPos > xPos)
                {
                    tempDistance = (yPos - xPos);
                }
                if (tempDistance < minDistance)
                {
                    minDistance = tempDistance;
                }
            }

            index++;
        }

        if (minDistance == 5000 || xPos < 0 || yPos < 0)
        {
            System.out.println("Could not determine distance");
        } else
        {
            System.out.println(minDistance);
        }
    }
}
