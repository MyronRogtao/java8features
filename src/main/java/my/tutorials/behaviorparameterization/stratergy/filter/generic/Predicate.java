package my.tutorials.behaviorparameterization.stratergy.filter.generic;

public interface Predicate<T> {

    boolean filter(T entity);
}
