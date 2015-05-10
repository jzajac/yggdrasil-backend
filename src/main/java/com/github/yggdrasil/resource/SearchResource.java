package com.github.yggdrasil.resource;


import com.codahale.metrics.annotation.Timed;
import com.github.yggdrasil.core.InsurancePlan;
import com.github.yggdrasil.core.InsuranceService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {

    @POST
    @Timed
    public List<InsurancePlan> doSearch(@QueryParam("zipCode") Optional<String> zipCode) {

        Random random = new Random();

        List<InsuranceService> insuranceServices = new ArrayList<InsuranceService>();

        insuranceServices.add(new InsuranceService("5500", "Doctor visits"));
        insuranceServices.add(new InsuranceService("2200", "Specialist visits"));
        insuranceServices.add(new InsuranceService("2255", "Generic Rx"));

        List<InsurancePlan> searchResults = new ArrayList<InsurancePlan>();

        searchResults.add(new InsurancePlan(random.nextLong(), random.nextInt(10000), "Catastrophic", "Test Insurer Inc.", random.nextInt(500), "Test HMO 5500 series", insuranceServices));
        searchResults.add(new InsurancePlan(random.nextLong(), random.nextInt(10000), "Bronze", "Connecticut Insurer LLC.", random.nextInt(500), "Test HMO 2200 series", insuranceServices));

        return searchResults;
    }

}
