package com.samlikescode.stackoverflow.questions.q31310212;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Objects;

/**
 * //todo(sb)
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Foo extends HashMap<String, String> {
    @JsonUnwrapped
    private HashMap<String, String> fooMap;

    private OffsetDateTime lastModifiedTime;

    public Foo() {
        super();
        lastModifiedTime = OffsetDateTime.now();
    }

    public void setLastModifiedTime(OffsetDateTime newTime) {
        this.lastModifiedTime = newTime;
    }

    public OffsetDateTime getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public static void main(String[] args) throws IOException {
        Foo f = new Foo();
        f.put("hello", "world");
        f.setLastModifiedTime(OffsetDateTime.now());

        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();

        String result = om.writeValueAsString(f);
        if(f.equals(om.readValue(result, new TypeReference<Foo>() {}))) {
            System.out.println("Wooo");
        } else {
            System.out.println("Booo: " + result);
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Foo)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Foo foo = (Foo) obj;
        return Objects.equals(getLastModifiedTime(), foo.getLastModifiedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLastModifiedTime());
    }

}