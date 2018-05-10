package my.tutorials.behaviorparameterization.helper;

import my.tutorials.behaviorparameterization.stratergy.generic.Predicate;

import java.util.ArrayList;
import java.util.List;

public class GenericHelper {

    private GenericHelper(){}

    public static <T> List<T> filterData(List<T> dataList, Predicate<T> predicate) {
        List<T> filteredData = new ArrayList<>();
        for(T data : dataList) {
            if(predicate.filter(data)) {
                filteredData.add(data);
            }
        }
        return filteredData;
    }
}
