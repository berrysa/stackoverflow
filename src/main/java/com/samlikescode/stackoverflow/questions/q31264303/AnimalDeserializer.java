package com.samlikescode.stackoverflow.questions.q31264303;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 *     public class ReferenceDeserializer extends JsonDeserializer<Animal> {

@Override
public Animal deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
ObjectCodec oc = jp.getCodec();
JsonNode node = oc.readTree(jp);

if (I have a root Animal)
{
deserialize the full animal
} else if (I have a List or a Animal which is not a root object)
{
load the Animal from database with the id received
}
return myAnimal:
}
}

 */
public class AnimalDeserializer extends JsonDeserializer<Animal> {
    private final JsonDeserializer<Object> defaultDeserializer

    @Override
    public Animal deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        if (!jp.isClosed()) {
            ObjectCodec oc = jp.getCodec();

            jp.

            TreeNode node = oc.readTree(jp);
            JsonToken jsonToken = node.asToken();

            if (!jsonToken.isStructStart()) {

            }



            return null;
        }
        return null;
    }
}
