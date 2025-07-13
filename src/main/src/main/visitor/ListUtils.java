package main.visitor;

import java.util.List;

public class ListUtils {
    public static <T> T getLast(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        return list.get(list.size() - 1);
    }
}