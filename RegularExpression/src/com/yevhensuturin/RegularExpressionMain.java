package com.yevhensuturin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionMain {
    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);

        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphaNumeric = "abcDeeeF12Ghhiiiiijkl99z";
        System.out.println(alphaNumeric.replaceAll(".", "Y"));

        //Using ^ means to consider only if the pattern from start of the string
        System.out.println(alphaNumeric.replaceAll("^abcDeee", "YYY"));
        String secondString = "abcDeeeF12GhhabcDeeeiiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        System.out.println(alphaNumeric.matches("^hello"));
        System.out.println(alphaNumeric.matches("^abcDeee"));
        System.out.println(alphaNumeric.matches("^abcDeeeF12Ghhiiiiijkl99z"));

        // $ - means the end of the string
        System.out.println(alphaNumeric.replaceAll("ijkl99z$", "THE END"));

        // [] - to match for specific letters
        System.out.println(alphaNumeric.replaceAll("[aei]", "X"));
        System.out.println(alphaNumeric.replaceAll("[aei]", "I replaced the letter here"));
        System.out.println(alphaNumeric.replaceAll("[aei][Fj]", "X"));
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphaNumeric = "abcDeeeF12Ghhiiiiijkl99z";
        //[^ej] - match all the symbols except ej
        System.out.println(newAlphaNumeric.replaceAll("[^ej]", "X"));
        System.out.println(newAlphaNumeric.replaceAll("[absdef345678]", "X"));
        //range specification
        System.out.println(newAlphaNumeric.replaceAll("[a-fA-F3-8]", "X"));
        //(?i) - no case sensitivity
        //(?u) - unicode string
        System.out.println(newAlphaNumeric.replaceAll("(?iu)[a-f3-8]", "X"));
        //replace all the digital
        System.out.println(newAlphaNumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphaNumeric.replaceAll("\\d", "X"));
        //replace all non digits
        System.out.println(newAlphaNumeric.replaceAll("\\D", "X"));

        String hasWhiteSpace = "I have blanks and \ta tab and also a new line\n";
        System.out.println(hasWhiteSpace);
        //remove all while space
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
        //replace tab
        System.out.println(hasWhiteSpace.replaceAll("\t", "X"));
        //replace all non white space character
        System.out.println(hasWhiteSpace.replaceAll("\\S", "X"));
        //replace 0-9 a-z A-z _
        System.out.println(newAlphaNumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\w", "X"));
        //each word is surrounded by the replacement string
        System.out.println(hasWhiteSpace.replaceAll("\\b", "<div>"));

        //Quantifiers
        String thirdAlphaNumeric = "abcDeF12Ghhiiiiijkl99z";
        //{3} - the number of the preceding character
        System.out.println(thirdAlphaNumeric.replaceAll("^abcDe{3}", "YYY"));
        //+ - match a number of preceding character could be placed before
        System.out.println(thirdAlphaNumeric.replaceAll("^abcDe+", "YYY"));
        //+ - match a 0 or number of preceding character could be placed before
        System.out.println(thirdAlphaNumeric.replaceAll("^abcDe*", "YYY"));
        //{2,5} a number of preceding character should be from 2 to 5
        System.out.println(thirdAlphaNumeric.replaceAll("^abcDe{2,5}", "YYY"));
        System.out.println(thirdAlphaNumeric.replaceAll("h+i*j", "YYY"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is summary.</p>");

        System.out.println(htmlText);
        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find()){
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        //*? locates the nearest </h2> group of symbols (turn * quantifier into a lazy quantifier)
        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()){
            System.out.println("Occurrence " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);
        System.out.println(h2TextMatcher.matches());

        h2TextMatcher.reset();
        while (h2TextMatcher.find()){
            System.out.println("Occurrence: \n\tgroup(1):" + h2TextMatcher.group(1) + "\n\tgroup(2):"+ h2TextMatcher.group(2)+ "\n\tgroup(3):"+ h2TextMatcher.group(3));
        }

        //logical AND OR
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));

        //[^abc] - logical NOT all characters except abs
        String tvTest = "tstvtkt";
        //match two symbols: t and some symbol but not v
//        String tNotVRegExp = "t[^v]";
        //negative look ahead expression
//        String tNotVRegExp = "t(?!v)";
//        positive look ahead
        String tNotVRegExp = "t(?=v)";

        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while (tNotVMatcher.find()){
            System.out.println("Occurrence: "+tNotVMatcher.start() + " to "+tNotVMatcher.end());
        }

//        ^[\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4}$
        String phone1 = "1234567890";
        String phone2 = "(123) 456-7890";
        String phone3 = "123 456-7890";
        String phone4 = "(123)456-7890";

        System.out.println("phone1 = " + phone1.matches("^[\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4}$"));
        System.out.println("phone2 = " + phone2.matches("^[\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4}$"));
        System.out.println("phone3 = " + phone3.matches("^[\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4}$"));
        System.out.println("phone4 = " + phone4.matches("^[\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4}$"));

//        Visa number
        // ^4[0-9]{12}([0-9]{3})?$
        String visa1 = "4444444444444"; // should match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));
    };
}
