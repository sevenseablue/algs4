package edu.princeton.cs.algs4;

import java.util.Objects;

public class IntDouble {
    int i;
    double d;

    public IntDouble(int i, Double d) {
        this.i = i;
        this.d = d;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public static int parseI(IntDouble id){
        return id.getI();
    }

    public static double parseD(IntDouble id){
        return id.getD();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntDouble intDouble = (IntDouble) o;
        return i == intDouble.i &&
                Double.compare(intDouble.d, d) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, d);
    }
}
