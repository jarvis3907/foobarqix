package com.wemanity.foobarqix.controller;

import com.wemanity.foobarqix.model.Result;
import com.wemanity.foobarqix.service.IFooBarQixService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Foo bar qix controller.
 */
@RestController
@RequestMapping(value = "compute")
public class FooBarQixController {

    private IFooBarQixService iFooBarQixService;

    /**
     * Instantiates a new Foo bar qix controller.
     *
     * @param iFooBarQixService the foo bar qix service
     */
    public FooBarQixController(IFooBarQixService iFooBarQixService) {
        this.iFooBarQixService = iFooBarQixService;
    }


    /**
     * Compute response entity.
     *
     * @param value the value
     * @return the response entity
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> compute(@RequestParam("value") String value) {
        return new ResponseEntity<>(iFooBarQixService.process(value),
                HttpStatus.OK);
    }

}
