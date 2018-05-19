package my.tutorials.functionalInterface;

/**
 * Supply object of type U
 * @param <U> Out object
 */
@FunctionalInterface
public interface Supplier<U> {
    U get();
}
