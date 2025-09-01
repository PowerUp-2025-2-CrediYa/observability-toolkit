package com.pragma.observability;

public interface  LogEvents {

    String USER_CREATE_REQ   = "USR-001";
    String USER_CREATED      = "USR-002";
    String USER_DUPLICATED   = "USR-409";
    String USER_RULES_FAILED = "USR-422";

    String DB_WRITE          = "INF-DB-001";
    String DB_CONSTRAINT     = "INF-DB-409";

}
