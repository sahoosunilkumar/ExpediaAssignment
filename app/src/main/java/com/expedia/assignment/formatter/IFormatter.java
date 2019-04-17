package com.expedia.assignment.formatter;

public interface IFormatter<K, V> {
    V format(K input);
}
