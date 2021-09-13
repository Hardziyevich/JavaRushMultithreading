package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.Objects;

/* 
Ошибка в equals/hashCode
*/

public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : !Objects.equals(solution1.date,date)) return false;
        if (solution != null ? !solution.equals(solution1.solution) : !Objects.equals(solution1.solution,solution)) return false;
        if (string != null ? !string.equals(solution1.string) : !Objects.equals(solution1.string,string)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anInt,string,aDouble,date,solution);
    }

    public static void main(String[] args) {

    }
}
