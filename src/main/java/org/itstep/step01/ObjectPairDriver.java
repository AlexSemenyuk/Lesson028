package org.itstep.step01;

/**
 * Класс для тестирования кортежа ObjectPair
 *
 * @author Nathan Sprague
 * @version V1, 8/2016
 */
public class ObjectPairDriver {

    /**
     * Создайте несколько пар стадионов, затем распечатайте название стадиона с наибольшей вместимостью.
     *
     * @param args Не используется
     */
    public static void main(String[] args) {

        ObjectPair[] stadiums = new ObjectPair[3];
        stadiums[0] = new ObjectPair("Bridgeforth Stadium", 25000);
        stadiums[1] = new ObjectPair("Michigan Stadium", 109901);
        stadiums[2] = new ObjectPair("Lane Stadium", 66233);

        System.out.println(stadiums[0]);
        System.out.println(largestStadium(stadiums));
    }

    /**
     * Возвращает название стадиона с наибольшей вместимостью.
     *
     * @param stadiums Массив ObjectPairs, где каждая пара содержит название стадиона, за которым следует целое число
     * @return Название стадиона с наибольшей вместимостью
     */
    public static String largestStadium(ObjectPair[] stadiums) {
        // TODO: реализуйте это метод в соответствии с комментариями
        int peopleMax = 0;
        int count = -1;
        for (int i = 0; i < stadiums.length; i++) {
            // це зайва перевірка. у будь якому разі буде ClassCastException
            if ( stadiums[i].getFirst() instanceof String && stadiums[i].getSecond() instanceof Integer) {
            } else {
                throw new ArrayStoreException();        // Предпринята попытка сохранения в массиве объекта недопустимого типа.
            }
        }

        for (int i = 0; i < stadiums.length; i++) {
                if ((int) stadiums[i].getSecond() > peopleMax) {
                    peopleMax = (int) stadiums[i].getSecond();
                    count = i;
                }
        }
        return stadiums[count].getFirst() + "";
    }

}


// БОНУСНЫЙ ВОПРОС: Почему компилируется эта строка кода?
// stadiums[0] = new ObjectPair("Bridgeforth Stadium", 25000);

// Выполняется неявное приведение к типам String (first) и Integer (second)
