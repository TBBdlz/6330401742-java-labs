/*
  This ChangeMachine program 4 arguments
  <1-baht coins> <2-baht coins> <5-baht coins> <10-baht coins>
  The program calculates the total amount of money
  and print each 1000 bill, 500 bill, 100 bill, 20 bill to user
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 8 January 2021
*/
package yingyongwatthanakit.metee.lab2;

public class ChangeMachine {
    public static void main(String[] args) {
        if (args.length == 4) {
            int coin1 = Integer.parseInt(args[0]);
            int coin2 = Integer.parseInt(args[1]);
            int coin5 = Integer.parseInt(args[2]);
            int coin10 = Integer.parseInt(args[3]);
            // non-negative value only
            if ((coin1 < 0 || coin2 < 0) || (coin5 < 0 || coin10 < 0)) {
                System.err.println("ChangeMachine <1-baht coins> <2-baht coins> <5-baht coins> <10-baht coins>");
                System.exit(1);
            }
            // total money calculate from coins above
            int total = coin1 + (2 * coin2) + (5 * coin5) + (10 * coin10);
            int bill1000 = Math.floorDiv(total, 1000);
            int bill500 = Math.floorDiv(total - 1000 * bill1000, 500);
            int bill100 = Math.floorDiv(total - 1000 * bill1000 - 500 * bill500, 100);
            int bill20 =  Math.floorDiv(total - 1000 * bill1000 - 500 * bill500 - 100 * bill100, 20);
            int remain = total - (1000 * bill1000) - (500 * bill500) - (100 * bill100) - (20 * bill20);
            // print coins to the screen
            System.out.println("1-baht coins : " + coin1);
            System.out.println("2-baht coins : " + coin2);
            System.out.println("5-baht coins : " + coin5);
            System.out.println("10-baht coins : " + coin10);
            // print total to the screen
            System.out.println("Total amount : " + total);
            // print bills to the screen
            System.out.println("1000-baht bills : " + bill1000);
            System.out.println("500-baht bills : " + bill500);
            System.out.println("100-baht bills : " + bill100);
            System.out.println("20-baht bills : " + bill20);
            System.out.println("Money remain : " + remain);
        } else {
            System.err.println("ChangeMachine <1-baht coins> <2-baht coins> <5-baht coins> <10-baht coins>");
        }
    }
}