package com.samlikescode.stackoverflow.questions.q31310212;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;

/**
 * The OP's desired deserialization class.
 */
@JsonDeserialize(using = RecursiveLatLngDeserializer.class)
public class NearbyPlace {

    @JsonProperty("lat")
    private double latitude;

    @JsonProperty("lng")
    private double longitude;

    @JsonProperty("vicinity")
    private String vicinity;

    public NearbyPlace(double latitude, double longitude, String vicinity) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.vicinity = vicinity;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private double latitude;
        private double longitude;
        private String vicinity;

        public Builder setLatitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder setLongitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder setVicinity(String vicinity) {
            this.vicinity = vicinity;
            return this;
        }


        public NearbyPlace build() {
            return new NearbyPlace(latitude,
                    longitude,
                    vicinity);
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("latitude", latitude)
                .add("longitude", longitude)
                .add("vicinity", vicinity)
                .toString();
    }
}