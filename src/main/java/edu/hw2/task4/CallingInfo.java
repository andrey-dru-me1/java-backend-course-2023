package edu.hw2.task4;

import org.jetbrains.annotations.NotNull;

public record CallingInfo(String className, String methodName) {

    public static @NotNull CallingInfo callingInfo() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[0];
        return new CallingInfo(stackTraceElement.getClassName(), stackTraceElement.getMethodName());
    }

}
