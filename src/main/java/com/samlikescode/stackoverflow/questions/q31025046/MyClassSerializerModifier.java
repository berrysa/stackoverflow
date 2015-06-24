package com.samlikescode.stackoverflow.questions.q31025046;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

    public class MyClassSerializerModifier extends BeanSerializerModifier {
        @Override
        public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
            if (beanDesc.getBeanClass() == MySpecificClass.class) {
                return new MySpecificClassSerializer((JsonSerializer<Object>) serializer);
            }
            return serializer;
        }
    }
