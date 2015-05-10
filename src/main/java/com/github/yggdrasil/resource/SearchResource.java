package com.github.yggdrasil.resource;


import com.codahale.metrics.annotation.Timed;
import com.github.yggdrasil.core.InsurancePlan;
import com.github.yggdrasil.core.InsuranceService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {

    @POST
    @Timed
    public List<InsurancePlan> doSearch(@QueryParam("zipCode") Optional<String> zipCode) {

        List<InsuranceService> insuranceServices = new ArrayList<InsuranceService>();

        insuranceServices.add(new InsuranceService("5500", "Doctor visits"));
        insuranceServices.add(new InsuranceService("2200", "Specialist visits"));
        insuranceServices.add(new InsuranceService("2255", "Generic Rx"));

        List<InsurancePlan> searchResults = new ArrayList<InsurancePlan>();

        searchResults.add(new InsurancePlan(0L, 4200.00, "Catastrophic", "Test Insurer Inc.", 150.44, "Test HMO 5500 series", insuranceServices));
        searchResults.add(new InsurancePlan(1L, 1200.00, "Bronze", "Connecticut Insurer LLC.", 250.00, "Test HMO 2200 series", insuranceServices));

        return searchResults;
    }

}
