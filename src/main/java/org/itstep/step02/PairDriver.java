package org.itstep.step02;

// TODO: Пишите ваш код здесь

public class PairDriver {
    public static void main(String[] args) {

        Pair<String, Integer>[] stadiums = new Pair[6];
        stadiums[0] = new Pair<>("Bridgeforth Stadium", 25000);
        stadiums[1] = new Pair<>("Michigan Stadium", 109901);
        stadiums[2] = new Pair<>("Lane Stadium", 66233);
        stadiums[3] = new Pair<>("Old Trafford", 74310);
        stadiums[4] = new Pair<>("Etihad Stadium", 55097);
        stadiums[5] = new Pair<>("Santiago Bernabeu Stadium", 81044);

        System.out.println(stadiums[0]);
        System.out.println(largestStadium(stadiums));
    }

    public static String largestStadium(Pair<String, Integer>[] stadiums) {
        int peopleMax = 0;
        int count = 0;

        for (int i = 0; i < stadiums.length; i++) {
            if (stadiums[i].getSecond() > peopleMax) {
                peopleMax = stadiums[i].getSecond();
                count = i;
            }
        }
        return stadiums[count].getFirst() + "";
    }

}


//    БОНУСНЫЙ ВОПРОС №1: Что произойдет, если вы повторно воспроизведете проблему,
//    которую вы исправили на шаге 1 из предыдущего блока? Будет ли компилироваться полученный код?
//    Как вы думаете, почему обобщенные классы коллекций иногда называют «типобезопасными» коллекциями?
//
//    Ответ. Код не будет компилироваться до устранения проблемы (например изменить String на Integer).
//           Типобезопасными называют потому, что ошибку получаем на этапе компиляции, а не выполнения



//    БОНУСНЫЙ ВОПРОС №2: Перечислите некоторые причины, по которым класс Pair может быть
//    предпочтительнее класса ObjectPair. Можете ли вы предположить ситуации, в которых класс ObjectPair
//    может быть предпочтительнее класса Pair?

//    Ответ. Причины. 1. Класс Pair типобезопасный - четко прописан тип данных, в отличие от класса ObjectPair
//                    2. Легче читать код
//                    3. Не надо делать проверку соответствия данных требуемому типу

//          Класс ObjectPair предпочтительнее класса Pair: когда приходит несколько типов данных и это считается норм,
//                  т.е. мы изначально это используем