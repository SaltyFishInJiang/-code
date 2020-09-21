package com.salty.algorithm.linear.hashtable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author ryan
 * @since 2020/09/21
 */
public class UrlVisitsSort {

    public static List<String> sort(List<String> urls) {
        TreeMap<Integer, List<String>> treeMap = Maps.newTreeMap();
        urls.stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.collectingAndThen(Collectors.toList(), List::size)))
                .forEach((k, v) -> {
                    treeMap.putIfAbsent(v, Lists.newArrayList());
                    treeMap.get(v).add(k);
                });
        return treeMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(sort(Arrays.asList("32", "43", "35", "35", "354", "345")));
    }
}
