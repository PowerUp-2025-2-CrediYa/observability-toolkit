package com.pragma.observability;

public enum LogEvent{

    USER_CREATE_REQ("USR-001"),
    USER_CREATED("USR-002"),
    USER_DUPLICATED("USR-409"),
    USER_RULES_FAILED("USR-422"),

    DB_WRITE("INF-DB-001"),
    DB_CONSTRAINT("INF-DB-409");

    private final String code;

    LogEvent(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

