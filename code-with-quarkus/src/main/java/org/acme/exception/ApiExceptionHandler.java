/*package org.acme.exception;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.LocalDateTime;

@Provider
public class ApiExceptionHandler implements ExceptionMapper<Throwable> {


    @Context
    UriInfo uriInfo;
    @Override
    public Response toResponse(Throwable ex) {
        if (ex instanceof NotFoundException) {
            return handleNotFoundException((NotFoundException) ex);
        }

        return handleInternalServerError(new InternalServerError("Internal Server Error"));
    }

    private Response handleNotFoundException(NotFoundException ex) {
        int statusCode = Response.Status.NOT_FOUND.getStatusCode();
        StandardErrorResponse errorResponse = new StandardErrorResponse(LocalDateTime.now(), statusCode,
                ex.getMessage(), uriInfo.getRequestUri().toString());
        return Response.status(statusCode).entity(errorResponse).build();
    }

    private Response handleInternalServerError(InternalServerError ex) {
        int statusCode = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        StandardErrorResponse errorResponse = new StandardErrorResponse(LocalDateTime.now(), statusCode,
                ex.getMessage(), uriInfo.getRequestUri().toString());
        return Response.status(statusCode).entity(errorResponse).build();
    }
}*/
