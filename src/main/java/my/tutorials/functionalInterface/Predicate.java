package my.tutorials.functionalInterface;

/**
 * Perform operation on <T> that evaluates to boolean
 * @param <T>
 */
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T object);
}
