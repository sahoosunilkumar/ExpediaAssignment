package com.expedia.assignment.networking.model;

/**
 * Type for response details
 *
 * @param <T>
 */
public interface IResponse<T> {
    T getData();

    Throwable getError();

    int getStatus();
}
