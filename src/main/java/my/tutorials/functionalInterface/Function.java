package my.tutorials.functionalInterface;

/**
 * Map object of type <T> to type <R>
 * @param <T> In object
 * @param <R> Out Object
 */
@FunctionalInterface
public interface Function<T, R> {
    R map(T object);
}
