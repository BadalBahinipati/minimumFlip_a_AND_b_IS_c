package Coding_Challenges;

import java.util.*;

//Java code to get min flips required to have a & b = c
public class minimumFlip {
    static int getFlipCount(int a, int b, int c) {
        int flipCount = 0;
        for (int i = 0; i < 32; i++) {
            boolean ai = false;
            boolean bi = false;
            boolean ci = false;

            if ((a & (1 << i)) > 0)
                ai = true;
            if ((b & (1 << i)) > 0)
                bi = true;
            if ((c & (1 << i)) > 0)
                ci = true;

            if (ci) {
                if (!ai && !bi) // if ci = 1 and either ai or bi are 0 then we have to flip the 0 to 1
                    flipCount += 2;
                else if (!ai || !bi) // if ci = 1 and both ai and bi are 0 then we need to flip both to 1
                    flipCount++;
            } else {
                if (ai && bi) // if ci = 0 and both ai and bi are 1 then we need to flip any one of them to 0
                    flipCount++;
            }
        }
        return flipCount;
    }

    public static void main(String[] args) {
        int testcase, a, b, c;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();

        for (int i = 1; i <= testcase; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            System.out.println(getFlipCount(a, b, c));
        }
    }
}
