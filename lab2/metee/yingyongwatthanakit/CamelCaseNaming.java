/*
  This CamelCaseNaming takes 2 arguments: <first word> <second word>
  This program take first character and convert them to Capital.
  Other letter converts to lower case alphabet.
  And then program concat them together.
  EG. the input is: first second
      output is: FirstSecond
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 8 January 2021
*/
package lab2.metee.yingyongwatthanakit;

public class CamelCaseNaming {
    public static void main(String[] args) {
        if(args.length == 2) {
            String firstWord = args[0];
            String secondWord = args[1];
            System.out.println("The first word is " + firstWord);
            System.out.println("The second word is " + secondWord);
            // camelName merge two words together
            String camelName = Character.toUpperCase(firstWord.charAt(0))
                    + firstWord.substring(1,firstWord.length()).toLowerCase()
                    + Character.toUpperCase(secondWord.charAt(0))
                    + secondWord.substring(1, secondWord.length()).toLowerCase();
            // print output to the screen
            System.out.println("The concatenate with camel case is "+camelName);
        }else{
            System.err.println("CamelCaseNaming : <First word> <Second word>");
        }
    }
}
