package com.samlikescode.stackoverflow.questions.q31310212;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.io.File;

public class NearbyPlaceTest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testNearbyPlaceDeserialization() throws Exception {
        JsonNode jsonNode = objectMapper.readTree(new File("input.json"));
        // or objectMapper.readValue(resultString, JsonNode.class);
        ImmutableList<NearbyPlace> nearbyPlaces = readLatLng(jsonNode,
                jsonNode.get("vicinity").asText(null),
                ImmutableList.builder());
        System.out.println(nearbyPlaces);
    }

    private static ImmutableList<NearbyPlace> readLatLng(JsonNode jsonNode,
                                                         String vicinity,
                                                         ImmutableList.Builder<NearbyPlace> placeBuilder) {
        JsonNode latNode = jsonNode.get("lat");
        JsonNode lngNode = jsonNode.get("lng");
        if (latNode != null && lngNode != null) {
            placeBuilder.add(NearbyPlace.builder()
                    .setLatitude(latNode.asDouble())
                    .setLongitude(lngNode.asDouble())
                    .setVicinity(vicinity)
                    .build());
        } else {
            jsonNode.elements().forEachRemaining((element) -> {
                readLatLng(element, vicinity, placeBuilder);
            });
        }
        return placeBuilder.build();
    }

    @Test
    public void testNearbyPlaceDeserializationOtherAnswer() throws Exception {
        final String placesResponse = "...";
        NearbyPlace place = null;
        final JsonNode placesNode = objectMapper.readTree(placesResponse);
        final JsonNode locationNode = placesNode.findPath("geometry").findPath("location");
        if (! locationNode.isMissingNode()) {
            place = objectMapper.treeToValue(locationNode, NearbyPlace.class);
        }
    }
}
