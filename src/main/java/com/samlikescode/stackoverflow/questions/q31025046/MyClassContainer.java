package com.samlikescode.stackoverflow.questions.q31025046;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MyClassContainer {
    public MyClass element1;
    public MyClass element2;

    public MyClassContainer() {
        element1 = new MyClass();
        element1.description = "yay a description";
        element1.id = 123;
        element2 = new MyClass();
        element2.description = "yay a description";
        element2.id = null;
    }
}
