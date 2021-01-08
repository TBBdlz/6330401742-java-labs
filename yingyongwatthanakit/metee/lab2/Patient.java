/*
  This Patient program is to accept three arguments: patient name, patient age
  and country.  Its output format is
  Patient's name is <patient name>
  Patient's age is <patient age>
  <patient name> comes from  <patient country>
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 8 January 2021
*/
package yingyongwatthanakit.metee.lab2;

public class Patient {
    public static void main(String[] args) {
        if(args.length == 3) {
            System.out.println("Patient's name is " + args[0]);
            System.out.println("Patient's age is " + args[1]);
            System.out.println(args[0] + " comes from " + args[2]);
        }else {
            System.err.println("Patient <patient name> <patient age> <country>");
        }
    }
}