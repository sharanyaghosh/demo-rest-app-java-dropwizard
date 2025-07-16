package org.example;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Environment;

import org.example.config.BookstoreApiConfig;
import org.example.resources.BookResource;


public class BookstoreApi extends Application<BookstoreApiConfig> {
    public static void main(String[] args) throws Exception {
        new BookstoreApi().run(args);
    }

    @Override
    public void run(BookstoreApiConfig bookstoreApiConfig, Environment environment) {
        final BookResource resource = new BookResource();
        environment.jersey().register(resource);
    }
}