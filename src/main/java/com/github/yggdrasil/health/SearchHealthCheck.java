package com.github.yggdrasil.health;


import com.codahale.metrics.health.HealthCheck;

public class SearchHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {

        // In a typical production application, we wouldn't just return
        // Result.healthy() and call it a day. We'd actually want to test
        // that the search endpoint is actually returning data, most likely
        // by querying the database.
        // However in this application, all the data is fake and the points
        // don't matter (ok, so that's partly stolen from Whose Line Is It Anyway?)

        return Result.healthy();

    }
}
