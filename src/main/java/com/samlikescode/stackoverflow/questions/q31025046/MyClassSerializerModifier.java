package com.samlikescode.stackoverflow.questions.q31025046;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.util.List;

public class MyClassSerializerModifier extends BeanSerializerModifier {
        @Override
        public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
            if (beanDesc.getBeanClass() == MySpecificClass.class) {
                return new MySpecificClassSerializer((JsonSerializer<Object>) serializer);
            }
            return serializer;
        }

    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
        return super.changeProperties(config, beanDesc, beanProperties);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
