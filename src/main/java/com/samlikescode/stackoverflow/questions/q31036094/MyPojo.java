package com.samlikescode.stackoverflow.questions.q31036094;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = MyPojoDeserializer.class)
public class MyPojo {
//    @JsonDeserialize(contentConverter = MyKeyToListConverter.class)
    public List<Integer> keys;

}
