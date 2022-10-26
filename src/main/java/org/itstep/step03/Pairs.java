package org.itstep.step03;

import org.itstep.step02.Pair;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

///**
// * Итерируемая коллекция объектов Pair.
// *
// * @author Michael S. Kirkpatrick and Nathan Sprague
// * @version V1, 8/2017
// */
public class Pairs<K, V> implements Iterable<Pair<K, V>> {
    Scanner scanner = new Scanner(System.in);
    private final int number = 10;
    /* TODO: Объявить массив фиксированного размера (максимум 10 элементов) объектов Pair */
    /**
     * Создайте коллекцию, в которой будут храниться элементы, добавленные парами.
     */
    Pair<K, V>[] pair = new Pair[number];


    public Pairs() {
    }

    /**
     * TODO: Создайте новую пару и добавьте ее в коллекцию, если есть место.
     *
     * @param first  Первый объект
     * @param second Второй объект
     * @return true - если пара была добавлена, false - в противном случае
     */
    public boolean addPair(K first, V second) {
//        System.out.println("second = " + second.getClass().getName());    // Проверка типа line
        for (int i = 0; i < pair.length; i++) {
            if (pair.length == number && pair[i] == null) {
                pair[i] = new Pair<>(first, second);
                return true;
            } else if (pair.length < number) {
                pair = Arrays.copyOf(pair, pair.length + 1);
                pair[pair.length-1] = new Pair<>(first, second);
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new PairIterator(pair);
    }

    /*
     * TODO: Реализуйте итератор здесь на основе документации API по адресу
     * https://docs.oracle.com/javase/10/docs/api/java/util/Iterator.html Throw the exceptions as
     * specified
     */
    private class PairIterator implements Iterator<Pair<K, V>> {

        //        private Pair <K, V>[] pair;
        private int index;


        public PairIterator(Pair<K, V>[] pair) {
//            this.pair = pair;
            this.index = -1;
        }


        /**
         * TODO: Проверить наличие следующего элемента в итераторе
         */
        @Override
        public boolean hasNext() {
//            if (++index >= pair.length){
//                throw new UnsupportedOperationException();
//            }
            return ++index < pair.length;
        }

        /**
         * TODO: Вернуть следующую пару в итератор.
         *
         * @throws NoSuchElementException - если больше нет элементов для итерации
         */
        @Override
        public Pair<K, V> next() {
            if (index < 0 ){
                throw new NoSuchElementException();
            }
            return pair[index];
        }

        /**
         * TODO: Удалите предыдущую пару, возвращенную функцией next()
         */
        @Override
        public void remove() {
            for (int i = index; i < pair.length; i++) {
                if (i != pair.length - 1) {
                    pair[i] = pair[i + 1];
                }
//                else {
//                    pair[i] = null;
//                }
            }
            pair = Arrays.copyOf(pair, pair.length - 1);
        }
    }

}
