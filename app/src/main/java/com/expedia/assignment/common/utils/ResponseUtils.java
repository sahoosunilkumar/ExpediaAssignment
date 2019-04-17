package com.expedia.assignment.common.utils;

import com.expedia.assignment.networking.api.Status;
import com.expedia.assignment.networking.model.IResponse;

import io.reactivex.annotations.Nullable;

public class ResponseUtils {
    private static boolean match(@Nullable IResponse response, @Status int status) {
        if (response != null) {
            return response.getStatus() == status;
        }
        return false;
    }

    public static <T> boolean isInProgress(@Nullable IResponse<T> response) {
        return match(response, Status.IN_PROGRESS);
    }

    public static <T> boolean isSuccess(@Nullable IResponse<T> response) {
        return match(response, Status.SUCCESS);
    }

    public static <T> boolean isError(@Nullable IResponse<T> response) {
        return match(response, Status.ERROR);
    }
}
