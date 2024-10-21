package org.acme.hibernate.orm.panache;


import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CustomExceptionMapper implements ExceptionMapper<InvalidRequest> {

    @Override
    public Response toResponse(InvalidRequest exception) {
        // Customize your response here
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse(exception.getMessage()))
                .build();
    }
}

class ErrorResponse {
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
