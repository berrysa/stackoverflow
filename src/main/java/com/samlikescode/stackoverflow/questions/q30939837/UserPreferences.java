package com.samlikescode.stackoverflow.questions.q30939837;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;

/**
 * //todo(sb)
 */
    public class UserPreferences {
        public boolean offersNotifications;
        public boolean statusChangedNotifications;
        public boolean subscriptionNotifications;

        @JsonProperty("new_offers")
        @JsonDeserialize(using = NumericBooleanDeserializer.class)
        public boolean newOffersNotify;

        @JsonProperty("order_status_changed")
        @JsonDeserialize(using = NumericBooleanDeserializer.class)
        public boolean orderStatusChangedNotify;

        @JsonProperty("hot_offers")
        @JsonDeserialize(using = NumericBooleanDeserializer.class)
        public boolean hotOffersNotify;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("offersNotifications", offersNotifications)
                .add("statusChangedNotifications", statusChangedNotifications)
                .add("subscriptionNotifications", subscriptionNotifications)
                .add("newOffersNotify", newOffersNotify)
                .add("orderStatusChangedNotify", orderStatusChangedNotify)
                .add("hotOffersNotify", hotOffersNotify)
                .toString();
    }
}
