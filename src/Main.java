import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

// Задание 1.

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        System.out.println(predicate.test(-3));

        Predicate<Integer> predicate1 = x -> x > 0;
        System.out.println(predicate1.test(8));

// Задание 2.

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s + ", приветствую ;)))");
            }
        };
        consumer.accept("Ирина");

        Consumer<String> consumer1 = x -> System.out.println(x + ", приветствую ;)))");
        consumer1.accept("Ольга");

// Задание 3.

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                long c;
                return c = Math.round(aDouble);
            }
        };
        System.out.println(function.apply(25.135));

        Function<Double, Long> function1 = x -> Math.round(x);
        System.out.println(function1.apply(24.535));

// Задание 4.

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 101);
            }
        };
        System.out.println(supplier.get());

        Supplier<Integer> supplier1 = () -> (int) (Math.random() * 101);
        System.out.println(supplier1.get());

// Задание 5.

        String str = "Помиловать нельзя казнить.";

        Function<String, String> votTak = s -> str.substring(0, 10) + ", " + str.substring(11);

        Function<String, String> takVot = s -> str.substring(0, 17) + ", " + str.substring(18);

        System.out.println(ternaryOperator(containsSustr("нельзя"), votTak, takVot).apply(str));
    }

    public static Predicate<String> containsSustr (String substr) {
        return s -> s.contains(substr);
    }

    public static Function<String, String> ternaryOperator(Predicate<String> predicate,
                                                           Function<String, String> function1,
                                                           Function<String, String> function2)
    {
        return x -> (predicate.test(x)) ? function1.apply(x) : function2.apply(x);
    }
}