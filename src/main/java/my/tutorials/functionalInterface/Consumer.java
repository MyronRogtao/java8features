package my.tutorials.functionalInterface;

/**
 * Consume the object <T> supplied to the consume method.
 * @param <T>
 */
@FunctionalInterface
public interface Consumer<T> {
    void consume(T object);
}
