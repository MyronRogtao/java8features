package my.tutorials.behaviorparameterization.stratergy.generic;

/**
 * Map a given object of type <T> to type <R> </></>
 * @param <T> In object
 * @param <R> Out object
 */
public interface Mapper<T, R> {
    R map(T data);
}
