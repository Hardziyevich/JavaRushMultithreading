package com.javarush.task.task22.task2207;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        String s = null;
        String sa = "E:\\JAVAPROJECT\\Javarush\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task22\\task2207\\Test";
        try (FileChannel fileChannel = new FileInputStream(sa).getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) fileChannel.size());
            while (fileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                s = new String(byteBuffer.array(), StandardCharsets.UTF_8);
                byteBuffer.clear();
            }
        }
        System.out.println(s);
        String[] strings = s.split(" ");
        List<String> buff = new ArrayList<>();
        for (String asd:
             strings) {
            buff.add(asd);
        }
        Iterator<String> iterator = buff.iterator();
        while (iterator.hasNext()){

        }
    }
//E:\JAVAPROJECT\Javarush\JavaRushTasks\3.JavaMultithreading\src\com\javarush\task\task22\task2207\Test

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
