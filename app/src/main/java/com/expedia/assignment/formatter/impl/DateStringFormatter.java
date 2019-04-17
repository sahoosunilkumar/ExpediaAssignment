package com.expedia.assignment.formatter.impl;

import com.expedia.assignment.formatter.IFormatter;

import java.text.DateFormat;

import javax.inject.Inject;
import javax.inject.Named;

public class DateStringFormatter implements IFormatter<String, String> {
    private final DateFormat sourceFormat;
    private final DateFormat targetFormat;

    @Inject
    public DateStringFormatter(@Named("sourceFormat") DateFormat sourceFormat, @Named("targetFormat") DateFormat targetFormat) {
        this.sourceFormat = sourceFormat;
        this.targetFormat = targetFormat;
    }

    @Override
    public String format(String input) {
        try {
            return targetFormat.format(sourceFormat.parse(input));
        } catch (Exception ex) {
            return input;
        }
    }
}
