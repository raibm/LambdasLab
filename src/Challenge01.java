import interfaces.EvaluateInterface;
import interfaces.PrintableInterface;
import interfaces.RetrievableInterface;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Challenge01 {


    public static void main(String[] args) {
        Consumer<String> consumer = value -> System.out.println(value);
        PrintableInterface<String> printable = consumer::accept;

        printable.print("Printable lambda");

        RetrievableInterface<Integer> retrievable = value -> 77;
        Supplier<Integer> supplier = () -> retrievable.retrieve(77);

        System.out.println(supplier.get());


        EvaluateInterface<Integer> evaluateInterface = v -> v > 0;
        System.out.println(evaluateInterface.isNegative(-1));
        System.out.println(evaluateInterface.isNegative(1));

        Predicate<Integer> predicate = evaluateInterface::isNegative;
//        System.out.println(predicate.test());
    }
}
