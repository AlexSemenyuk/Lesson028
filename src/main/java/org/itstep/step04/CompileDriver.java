package org.itstep.step04;

import org.itstep.step02.Pair;

/**
 * Обобщения. Вопросы о компиляции
 *
 * @author Nathan Sprague
 * @version V1, 8/2016
 */
public class CompileDriver {

    public static void main(String[] args) {

        // TODO: перед удалением комментариев отметьте каждую строчку, где есть присвоение - скомпилируется ли код или нет
        Pair<String, Integer> p1;
        Pair<String, Number> p2;
        Pair<Object, Object> p3;
        Pair<?, ?> p4;
        Pair<?, ? extends Number> p5;




        p1 = new Pair<String, Integer>("A", 7);             // да, т.к. строгое соответствие String, Integer
        int a = p1.getSecond();                             // да, т.к. выполняется неявное приведение Integer к int

//        p1 = new Pair<Integer, Double>(23, 12.0);         // нет, нет строгого соответствия (Integer, Double не соответствует String, Integer)
//
//        p2 = new Pair<String, Integer>("B", 8);           // нет, нет строгого соответствия, несмотря на то, что Integer наследуется от Number
//
//        p3 = new Pair<String, Integer>("C", 9);           // нет, нет строгого соответствия (String, Integer не соответствует Object, Object)
//
        p4 = new Pair<String, String>("House", "Car");      // Да, есть строгое совпадение (?, ? включает String, String)
        p4 = new Pair<String, Integer>("D", 10);            // Да, есть строгое совпадение (?, ? включает String, Integer)
//
//        Integer b = p4.getSecond();                       // нет, т.к. getSecond() может быть любым типом, и не обязательно Integer
        Integer c = (Integer) p4.getSecond();               // да, выполняется явное приведение и getSecond() задан типом Integer (см. строка 35)
                                                            // нет, если закомментировать 35 строку, то getSecond() будет строкой (см. строка 34),
                                                            //  которую нельзя привести к Integer
//
//        p5 = new Pair<String, String>("E", "G");          // нет, т.к. ? extends Number не включает String
        p5 = new Pair<String, Double>("E", 11.0);           // да т.к. ? extends Number включает Double
//        System.out.println("p5 = " + p5.getSecond());
        p5 = new Pair<String, Integer>("E", 11);            // да т.к. ? extends Number включает Double
//        System.out.println("p5 = " + p5.toString());


//        Integer d = p5.getSecond();                       // нет явного приведения, а getSecond() может быть любым (BigInteger, Byte, Double, Float, Integer, Long и Short)
        Integer e = (Integer) p5.getSecond();               // Да, т.к. любое число класса Number можно привести к Integer
    }

}
