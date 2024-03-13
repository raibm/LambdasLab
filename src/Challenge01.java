import Model.Person;
import interfaces.EvaluateInterface;
import interfaces.PrintableInterface;
import interfaces.RetrievableInterface;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Challenge01 {


    public static void main(String[] args) {
        System.out.println("Question 1:");
       /**
         1. In main() invoke the consumer() method; in consumer() do the following:
         a) Using a lambda expression, implement the Printable interface (typed for String). The relevant
         method just prints out the String argument it receives. Invoke the relevant method, passing in
         "Printable lambda".
         b) Using both a lambda expression and a method reference, implement 1a using a Consumer.

        Answers:
        */
        Consumer<String> consumer = value -> System.out.println(value);
        PrintableInterface<String> printable = consumer::accept;

        printable.print("Printable lambda");
        System.out.println("----------------------");
        System.out.println("Question 2:");

        /**
         2. In main() invoke the supplier() method; in supplier() do the following:
         a) Using a lambda expression, implement the Retrievable interface (typed for Integer). The relevant
         method just returns 77. Invoke the relevant method.
         b) Using a lambda expression, implement 2a using a Supplier

         Answers:
         */
        RetrievableInterface<Integer> retrievable = value -> 77;
        Supplier<Integer> supplier = () -> retrievable.retrieve(77);

        System.out.println(supplier.get());
        System.out.println("----------------------");
        System.out.println("Question 3:");

        /**
          In main() invoke the predicate() method; in predicate() do the following:
              a) Using a lambda expression, implement the Evaluate interface (typed for Integer). The relevant
              method returns true if the argument passed is < 0, otherwise it returns false. Invoke the relevant
              method twice – the first time pass in -1 and the second time pass in +1
              b) Using a lambda expression, implement 3a using a Predicate.
              c) Declare a generically-typed check() method (not in UML). The first parameter is generic and the
              second parameter is a Predicate, also generically typed. The check() method returns true/false.
              Invoke the check() method with the following Predicate lambda expressions:
                 we want to know if a number is even (true) – invoke check() with 4 and 7 (true and false).
                 we want to know if a String begins with “Mr.” – invoke check() with “Mr. Joe Bloggs” and
                    “Ms. Ann Bloggs”
                 we want to know if a person is an adult (age >= 18) – invoke check() with “Mike” who is 33
                     and 1.8 (metres assumed) in height; and “Ann” who is 13 and 1.4 (metres) in height

         */
        EvaluateInterface<Integer> evaluateInterface = v -> v < 0;
        System.out.println("Is -1 negative? "+evaluateInterface.isNegative(-1));
        System.out.println("Is 1 negative? "+evaluateInterface.isNegative(1));

        Predicate<Integer> predicate = evaluateInterface::isNegative;
        System.out.println("(predicate) Is 1 negative? "+predicate.test(1));

        Predicate<Integer> isEven = v -> v % 2 == 0;
        Predicate<String> isMr = v -> v.startsWith("Mr.");
        Predicate<Person> isAdult = v -> v.getAge() >= 18;
        System.out.println("Is 4 a even number? "+check(4, isEven));
        System.out.println("Is 7 a even number? "+check(7, isEven));
        System.out.println("Does Mr. Joe Bloggs start with its with 'Mr.'? "+check("Mr. Joe Bloggs", isMr));
        System.out.println("Does Ms. Ann Bloggs start with its with 'Mr.'? "+check("Ms. Ann Bloggs", isMr));
        System.out.println("Is Mike an adult? "+check(new Person("Mike", 33, 1.8), isAdult));
        System.out.println("Is Ann an adult? "+check(new Person("Ann", 13, 1.4), isAdult));
        System.out.println("----------------------");

    }

    public static <T> boolean check(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }
}
