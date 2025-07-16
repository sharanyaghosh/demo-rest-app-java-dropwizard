package org.example.resources;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.jetty.http.HttpStatus;

import java.net.URI;
import java.util.UUID;

@Path("/v1/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    @POST
    @Path("/{mode}")
    public Response createBook(
            final @PathParam("mode") String mode,
            final String rawRequestBody) {
        // TODO: Implement
        final String bookId = String.valueOf(UUID.randomUUID());

        if ("SYNC".equalsIgnoreCase(mode)) {
            return Response.created(URI.create(bookId)).build();
        } else if ("ASYNC".equalsIgnoreCase(mode)) {
            return Response.accepted().build();
        }
        return Response.status(HttpStatus.BAD_REQUEST_400, "Invalid Creation mode").build();
    }

    @GET
    public Response listBooks(@QueryParam("author") String authorName) {
        // TODO: Implement
        return Response.ok("author = " + authorName).build();
    }

    @GET
    @Path("/{bookId}")
    public Response getBook(@PathParam("bookId") String bookId) {
        // TODO: Implement
        return Response.ok(bookId).build();
    }

    @DELETE
    @Path("/{bookId}")
    public Response deleteBook(@PathParam("bookId") String bookId) {
        // TODO: Implement
        return Response.noContent().build();
    }

    @PATCH
    public Response badBookOperation() {
        return Response.status(HttpStatus.FORBIDDEN_403).build();
    }
}
