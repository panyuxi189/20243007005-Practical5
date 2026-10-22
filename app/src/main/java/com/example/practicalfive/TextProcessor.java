package com.example.practicalfive;

public class TextProcessor {

    public String processMunicipality(String municipality) {

        if (municipality == null) {
            return null;
        }

        String input = municipality.trim();

        if (input.isEmpty()) {
            return null;
        }

        if (input.equalsIgnoreCase("Beijing")) {
            return "Beijing";
        }

        if (input.equalsIgnoreCase("Shanghai")) {
            return "Shanghai";
        }

        if (input.equalsIgnoreCase("Tianjin")) {
            return "Tianjin";
        }

        if (input.equalsIgnoreCase("Chongqing")) {
            return "Chongqing";
        }

        return null;
    }
}