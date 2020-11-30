import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class Playpen {

    public void testMatches() {
        //does not match
        System.out.println("abcdefg".matches("c.e"));
        //does match because it follows the pattern
        System.out.println("abcdefg".matches("b.c.d.e.f.g"));

        System.out.println(Arrays.asList("23,42,64,hike".split(",")));

        System.out.println("Anne of the 1000 days".split(" "));

        System.out.println("Anne of the 1000 days".split("xxxx"));


        System.out.println("Anne of the 1000 days".split("aaaaa"));

//replaceAll() - replaces all occurences of the supplied regex
        //"one + one = 2".replaceAll("one","1")

    //replaceFirst() - replaces just the first occurence of
        //the supplied regex
        //"one +one = 2".replaceFirst("one","1")
        //>1 + one = 2
        String string = "x and tigers and bears, oh my!";
        String replaced = string.replaceAll("q","Lions");
        System.out.println(string == replaced);

        Pattern pattern = Pattern.compile(",");
        String[] split = pattern.split("12,34,56,78");
        System.out.println(Arrays.asList(split));

        Matcher matcher = pattern.matcher("12,34,56,78");

        Pattern pattern1 = Pattern.compile(
                "^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$");
        boolean matches;
        matches = pattern1.matcher("5112345678890123").matches();
        System.out.println(matches);
        matches = pattern1.matcher("2221012345678901").matches();
        System.out.println(matches);
        matches = pattern1.matcher("2721012345678901").matches();
        System.out.println(matches);


        //use pattern as a stream filter
        //List<String> valid = colelction.stream()
               // .filter(pattern.asPredicate())
               // .collect(Collectors.toList);



    }

    public void invalidRegex(){
        try {
            "some-string".matches("\\w\\d[]");
        }catch (PatternSyntaxException e){
            System.out.println("Index: " + e.getIndex());
            System.out.println("Pattern:" + e.getPattern());
            System.out.println("Message: " + e.getMessage());
        }
    }

    @Test
    public void testEscapeCharacter(){
        "i favor the numbers \"22\" and 34, not to mention the \\ character"
                +"\n\r A is octal \101").replaceFirst("\\d","4");
   //must use the \\ to specify the backslash characters or else the program will get confused
    }
//quantifiers
    /*
    *=0 or more
     + = 1 or more
     ? = 0 or 1
      {m,n} at least m and at most n
     Quantifier modes:
     * greedy
     * reluctant
     * possessive
     */

/*
capture group
(pattern)quantifier
e.g.
(\d+\w+){2/4}
or
(\w)+
 */
           /* int groupCount = matcher.grouCount();
            for(int i = 0; i<groupCount; i++)
                String group = matcher.group(1);
    */






private void display(Pattern pattern, String group){
    Matcher matcher = pattern.matcher(group);
    int count = matcher.groupCount();
    if (matcher.matches()){
        for(int i = -1; i <= count + 1; i++){
            System.out.println("s.sn", i, matcher.group(i));
        }
    }



    //Named Capture Groups
    //(?<spaces>\s+)(?<text>\w+)(?<digits>\d+)
    //matcher.group("text");

/*
@Test
public void testNamedGroup(){
 Pattern pattern = Pattern.compile(
 "(\\w+)(-\\w+))+-(\\w+)");*/

    //case insenstive flat
    //(?i)
    //((?i)my-pattern)
    //((?i)my-(?-i)pattern)
    //(?i:my-pattern)

    /*
    using capture groups
    parenthesized patterns that match a character squesnce
    easily extracted from your text
    back references:\1 or \k<name>
    replacement: $1 or ${name}
     */

    //Anchors and Boundaries
    /*
    matching occurences at (or not at)"
    word boundaries
    line boundaries
    matching occurences when following or preceding a pattern (or not):
    look- behind
    look -ahead
    negative look-behind
    negative look-ahead

    Boundaires
    \btom-tom\b
    tom-tom

    ^ = beginning of a line
    $ = end of a line
    \b = the position of, or after, a word character
    \B = the position of, or after, a non- word character
    \A = the beginning of the input string
    \G = the end of the previous match
    \Z = the end of the input except for possibly a final terminator
    \z = the end of the input


Line Terminator
line feed = \n
carriage-reutrn foloowed immediately by nelwline \r\n
standalone carriage-return \u0085
line-separator character \u2028
paragraph-separator character \u2029


@Test
public void testSplitAsStream(){
String text = " one, Two,  , Buckle,     my Shoe";
Pattern pattern = pattern.complile("(,\\s+)");
List<String> list = pattern
.splitAsStream(text)
.map(String::toUpperCase)
.collect(Collectors.toList()));
System.out.println(list);









     */






}




}
