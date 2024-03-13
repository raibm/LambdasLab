package interfaces;

@FunctionalInterface
public interface EvaluateInterface<T> {
    boolean isNegative(T t);
//
//    T check(T t, Predicate<T> p);
}
