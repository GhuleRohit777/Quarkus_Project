package org.acme.hibernate.orm.panache;

public class InvalidRequest extends RuntimeException {
    public InvalidRequest(String message) {
        super(message);
    }
}
