package com.giassi.microservice.demo2.rest.users.exceptions;

import java.util.Objects;

public class ErrorDetails implements java.io.Serializable {

    private final String message;

    private final long timestamp;

    public ErrorDetails(final String message) {
        this.timestamp = System.currentTimeMillis();
        this.message = message;
    }

    public ErrorDetails(String message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDetails that = (ErrorDetails) o;
        return timestamp == that.timestamp && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, timestamp);
    }
}
