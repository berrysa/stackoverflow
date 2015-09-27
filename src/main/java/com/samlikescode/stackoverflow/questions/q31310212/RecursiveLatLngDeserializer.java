package com.samlikescode.stackoverflow.questions.q31310212;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;

import java.io.IOException;

/**
 * //todo(sb)
 */
public class RecursiveLatLngDeserializer extends JsonDeserializer<ImmutableList<NearbyPlace>> {
    @Override
    public ImmutableList<NearbyPlace> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return readLatLng(p.readValueAsTree(), ImmutableList.builder());
    }

    private static ImmutableList<NearbyPlace> readLatLng(JsonNode jsonNode, ImmutableList.Builder<NearbyPlace> placeBuilder) {
        JsonNode latNode = jsonNode.get("lat");
        JsonNode lngNode = jsonNode.get("lng");
        if (latNode != null && lngNode != null) {
            placeBuilder.add(NearbyPlace.builder()
                    .setLatitude(latNode.asDouble())
                    .setLongitude(lngNode.asDouble())
                    .build());
        } else {
            jsonNode.elements().forEachRemaining((element) -> {
                readLatLng(element, placeBuilder);
            });
        }
        return placeBuilder.build();
    }
}
