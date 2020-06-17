package com.yevhensuturin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionChallengeMain {
    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        System.out.println(challenge1.matches("I want a bike."));

        String regExp = "I want a \\w+.";
        System.out.println(challenge1.matches(regExp));
        System.out.println(challenge2.matches(regExp));

        String regExp1 = "I want a (bike|ball)+.";
        System.out.println(challenge1.matches(regExp1));
        System.out.println(challenge2.matches(regExp1));

        Pattern challenge3Pattern = Pattern.compile(regExp);
        Matcher challenge3Matcher = challenge3Pattern.matcher(challenge1);
        System.out.println(challenge3Matcher.matches());
        challenge3Matcher = challenge3Pattern.matcher(challenge2);
        System.out.println(challenge3Matcher.matches());

        String challenge4 = "Replace all blanks with underscores";
        System.out.println(challenge4.replaceAll("\\s", "_"));

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        System.out.println(challenge5.matches("[a-g]+"));
        System.out.println(challenge5.matches("[abcdefg]+"));

        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("^[A-z][a-z]+\\.\\d+$"));

        String challenge8 = "abcd.135uvqz.7tzik.999";
        Pattern challenge8Pattern = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher challenge8Matcher = challenge8Pattern.matcher(challenge8);
        while(challenge8Matcher.find()){
            System.out.println("Occurrence : " + challenge8Matcher.group(1));
        }

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern challenge9Pattern = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher challenge9Matcher = challenge9Pattern.matcher(challenge9);
        while(challenge9Matcher.find()){
            System.out.println("Occurrence : " + challenge9Matcher.start(1) + " : " + (challenge9Matcher.end(1)-1) );
        }

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        Pattern challenge11Pattern = Pattern.compile("(\\{)(.+?)(\\})");
        Matcher challenge11Matcher = challenge11Pattern.matcher(challenge11);
        while(challenge11Matcher.find()){
            System.out.println("Occurrence : " + challenge11Matcher.group(2));
        }

        System.out.println("Challenge11a");
        String challenge11a = "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x, y}, {5, 123}";
        Pattern challenge11aPattern = Pattern.compile("(\\{)(\\d+, \\d+)(\\})");
        Matcher challenge11aMatcher = challenge11aPattern.matcher(challenge11a);
        while(challenge11aMatcher.find()){
            System.out.println("Occurrence : " + challenge11aMatcher.group(2));
        }

        System.out.println("Challenge12");
        String challenge12 ="11111";
        System.out.println(challenge12.matches("[0-9]{5}"));
        System.out.println(challenge12.matches("^\\d{5}$"));

        System.out.println("Challenge13");
        String challenge13 ="11111-1111";
        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));

        System.out.println("Challenge14");
        String challenge14 ="11111-1111";
        String challenge14a ="11111";
        System.out.println(challenge14.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge14a.matches("^\\d{5}(-\\d{4})?$"));
    }
}
