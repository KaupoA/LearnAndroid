package com.example.numbershapes;

public class Numbers extends MainActivity{

    static boolean isTriangular(double num) {

        if(num < 0) {
            return false;
        }

        int sum = 0;

        for(int n = 1; sum <= num; n++) {

          sum = sum + n;
          if(sum == num) {
              return true;
          }

        }

        return false;

    }

    static boolean isSquare(double num) {

        double sq = Math.sqrt(num);

        return sq == Math.floor(sq);

    }

}
