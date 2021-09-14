package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        String result = "";
            if (string == null || string.isEmpty())
                throw new TooShortStringException();
            else {
                Matcher matcher = Pattern.compile("(\\s[^\\s.]+){4}").matcher(string);
                while (matcher.find())
                    result = matcher.group().trim();
            }
            if (result.equals(""))
                throw new TooShortStringException();
        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}

