package DataStructure;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 숫자의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String dummy = bf.readLine();
        System.out.println(Arrays.stream(bf.readLine().split("")).mapToInt(Integer::parseInt).sum());

    }

}
