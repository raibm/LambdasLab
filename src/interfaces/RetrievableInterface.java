package interfaces;

@FunctionalInterface
public interface RetrievableInterface<T> {
    T retrieve(T t);
}
