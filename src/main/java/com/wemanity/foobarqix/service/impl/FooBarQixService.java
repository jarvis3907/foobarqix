package com.wemanity.foobarqix.service.impl;

import com.wemanity.foobarqix.exception.InvalidNumberException;
import com.wemanity.foobarqix.model.Result;
import com.wemanity.foobarqix.service.IFooBarQixService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;


/**
 * The type Foo bar qix service.
 */
@Service
@Slf4j
public class FooBarQixService implements IFooBarQixService {

    private Map<Integer, String> fooBarQix;
    private Map<Integer, String> fooBarQixReplacement;

    /**
     * Instantiates a new Foo bar qix service.
     */
    public FooBarQixService() {
        fooBarQix = Map.of(3, "Foo", 5, "Bar", 7, "Qix");
        fooBarQixReplacement = Map.of(3, "Foo", 5, "Bar", 7, "Qix", 0, "*");
    }

    public Result process(String value) {
        int experimentValue;
        StringBuilder result = new StringBuilder();
        try {
            experimentValue = Integer.valueOf(value);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Invalid Number");
        }
        result.append(fooBarQix.keySet().stream().sorted().filter(key -> experimentValue % key == 0).map(fooBarQixReplacement::get)
                .collect(Collectors.joining()));
        result.append(value.chars()
                .mapToObj(c -> fooBarQixReplacement.getOrDefault(Character.getNumericValue(c),
                        (StringUtils.isEmpty(result.toString()) ? String.valueOf(Character.getNumericValue(c)) : "")))
                .collect(Collectors.joining()));

        return result.toString().isEmpty() ? Result.builder().result(value).build() : Result.builder().result(result.toString()).build();

    }
}
