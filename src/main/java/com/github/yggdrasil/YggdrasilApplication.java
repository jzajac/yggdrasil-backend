package com.github.yggdrasil;

import com.github.yggdrasil.health.SearchHealthCheck;
import com.github.yggdrasil.resource.SearchResource;
import io.dropwizard.Application;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class YggdrasilApplication extends Application<YggdrasilConfiguration> {

    public static void main(String[] args) throws Exception {
        new YggdrasilApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<YggdrasilConfiguration> bootstrap) {

        // Add Java8 support to Dropwizard, otherwise when using Java8 features
        // (such as Optional<T>) Jersey will throw an exception when running app
        // see: https://github.com/dropwizard/dropwizard-java8
        bootstrap.addBundle(new Java8Bundle());
    }

    @Override
    public void run(YggdrasilConfiguration yggdrasilConfiguration, Environment environment) throws Exception {

        // Set up CORS
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Set allowed origins
        // In a *real* production app, this would be much more restrictive than a wildcard
        cors.setInitParameter("allowedOrigins", "*");

        // Set allowed headers
        cors.setInitParameter("allowedHeaders", "X-Requested-With, Content-Type,Accept,Origin");

        // Set allowed methods
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        // Register health checks
        final SearchHealthCheck searchHealthCheck = new SearchHealthCheck();

        environment.healthChecks().register("search", searchHealthCheck);

        // Register searchResource
        final SearchResource searchResource = new SearchResource();

        environment.jersey().register(searchResource);

    }
}
