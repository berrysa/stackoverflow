package com.samlikescode.stackoverflow.questions.q30939837;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

@JsonIgnoreProperties(ignoreUnknown=true)
public class User {
    @JsonProperty("customer_id")
    public int id;
    @JsonProperty("firstname")
    public String firstName;
    @JsonProperty("lastname")
    public String lastName;
    @JsonProperty("email")
    public String email;
    @JsonProperty("telephone")
    public String phone;
    @JsonProperty("token_api")
    public String token;
    @JsonProperty("token_expire_unix") //this needs to match the json key
    public int tokenExpireTime;
    @JsonProperty("preferences")
    public UserPreferences userPreferences;

    public String getUserFirstName() {
        return firstName;
    }

    public String getUserLastName() {
        return lastName;
    }

    public String getUserEmail() {
        return email;
    }

    public String getUserIconUrl() {
        return null;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("email", email)
                .add("phone", phone)
                .add("token", token)
                .add("tokenExpireTime", tokenExpireTime)
                .add("userPreferences", userPreferences)
                .toString();
    }
}
