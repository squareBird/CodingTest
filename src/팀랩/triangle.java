package 팀랩;

import java.util.HashSet;

public class triangle {

    public static void main(String[] args) {

        int n = 0;

        HashSet<Integer> set = new HashSet();


        for (int a = 1; a < 1000; a++) {
            for (int b = 1; b < 1000; b++) {
                for (int c = 1; c < 1000; c++) {
                    if ((a * a + b * b == c * c) && (a * b / 2 <= 8192)) {
                        n++;
                    }

                }
            }
        }
        System.out.println("n = " + n/2);


        }
    }
