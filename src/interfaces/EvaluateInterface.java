package interfaces;

import java.util.function.Predicate;

public interface EvaluateInterface<T> {
    boolean isNegative(T t);

    T check(T t, Predicate<T> p);
}
