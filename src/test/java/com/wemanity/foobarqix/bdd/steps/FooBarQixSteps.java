package com.wemanity.foobarqix.bdd.steps;

import com.wemanity.foobarqix.model.Result;
import cucumber.api.java8.En;
import io.restassured.response.Response;
import org.junit.Assert;

/**
 * The type Foo bar qix steps.
 */
public class FooBarQixSteps extends BaseStep implements En {

    /**
     * Instantiates a new Foo bar qix steps.
     */
    public FooBarQixSteps(){
        When("users wants to compute foobarqix for {string}", (String testContext) -> {
            String computeUrl = "/compute?value="+testContext;
            executeGet(computeUrl);
        });
        Then("the server should handle it and the status code is {int}", this::accept);
        Then("the response should be {string}",this::verifyResult);

    }


    private void accept(int expectedResult) {
        Response response = testContext().getResponse();
        Assert.assertEquals(response.getStatusCode(), expectedResult);
    }

    private void verifyResult(String expectedResult) {
        Response response = testContext().getResponse();
        Result result = response.getBody().as(Result.class);
        Assert.assertEquals(result.getResult(), expectedResult);
    }
}
