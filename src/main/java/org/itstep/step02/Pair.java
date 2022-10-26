package org.itstep.step02;

// TODO: Реализуйте здесь обобщенный класс Pari

import java.io.Serializable;

public class Pair<T, S> implements Serializable {
    private T first;
    private S second;

    /**
     * Создаем объект ObjectTuple на базе двух объектов.
     *
     * @param first  первый объект
     * @param second второй объект
     */
    public Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "<" + first.toString() + ", " + second.toString() + ">";
    }

}
