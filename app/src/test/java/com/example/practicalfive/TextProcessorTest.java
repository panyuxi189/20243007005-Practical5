package com.example.practicalfive;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TextProcessorTest {

    @Test
    public void validMunicipalitiesAreProcessedCorrectly() {
        TextProcessor processor = new TextProcessor();

        assertEquals("Beijing", processor.processMunicipality("beijing"));
        assertEquals("Shanghai", processor.processMunicipality("SHANGHAI"));
        assertEquals("Tianjin", processor.processMunicipality("tianjin"));
        assertEquals("Chongqing", processor.processMunicipality("ChOnGqInG"));
    }

    @Test
    public void invalidMunicipalitiesReturnNull() {
        TextProcessor processor = new TextProcessor();

        assertNull(processor.processMunicipality("Guangzhou"));
        assertNull(processor.processMunicipality(""));
        assertNull(processor.processMunicipality("   "));
        assertNull(processor.processMunicipality(null));
    }
}