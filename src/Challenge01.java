import interfaces.PrintableInterface;

import java.util.function.Consumer;

public class Challenge01 {


    public static void main(String[] args) {
        Consumer<String> consumer = value -> System.out.println(value);
        PrintableInterface<String> printable = System.out::println;

        consumer.accept("Printable lambda");
        printable.print("Printable lambda");
    }
}
