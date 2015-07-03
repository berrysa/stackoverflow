/*
*  Copyright 2015 Vertafore, Inc.   All rights reserved.
*
*  Disclaimers:
*   This software is provided "as is," without warranty of any kind, express or
*   implied, including but not limited to the warranties of merchantability,
*   fitness for a particular purpose and non-infringement.  This source code
*   should not be relied upon as the sole basis for solving a problem whose
*   incorrect solution could result in injury to person or property. In no
*   event shall the author or contributors be held liable for any damages
*   arising in any way from the use of this software. The entire risk as to the
*   results and performance of this source code is assumed by the user.
*
*   Permission is granted to use this software for internal use only, subject
*   to the following restrictions:
*     1.  This source code MUST retain the above copyright notice, disclaimer,
*         and this list of conditions.
*     2.  This source code may be used ONLY within the scope of the original
*         agreement under which this source code was provided and may not be
*         distributed to any third party without the express written consent of
*         Vertafore, Inc.
*     3.  This source code along with all obligations and rights under the
*         original License Agreement may not be assigned to any third party
*         without the expressed written consent of Vertafore, Inc., except that
*         assignment may be made to a  successor to the business or
*         substantially all of its assets. All parties bind their successors,
*         executors, administrators, and assignees to all covenants of this
*         Agreement.
*
*   All advertising materials mentioning features or use of this software must
*   display the following acknowledgment:
*
*     Trademark Disclaimer:
*     All patent, copyright, trademark and other intellectual property rights
*     included in the source code are owned exclusively by Vertafore, Inc.
*/
package com.samlikescode.stackoverflow.questions.q31134030;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.ImmutableMap;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Schedule {
    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;

    private static final ImmutableMap<String, Schedule> WEEKDAY_TO_INT_MAP =
            ImmutableMap.<String, Schedule>builder()
                .put("SUNDAY", withIntWeekday(0))
                .put("MONDAY", withIntWeekday(1))
                .put("TUESDAY", withIntWeekday(2))
                .put("WEDNESDAY", withIntWeekday(3))
                .put("THURSDAY", withIntWeekday(4))
                .put("FRIDAY", withIntWeekday(5))
                .put("SATURDAY", withIntWeekday(6))
                .build();

    public static Schedule withIntWeekday(int weekdayInt) {
        Schedule schedule = new Schedule();
        schedule.setWeekday(weekdayInt);
        return schedule;
    }

    @JsonCreator
    public static Schedule fromString(String weekday) {
        return WEEKDAY_TO_INT_MAP.get(weekday);
    }

    private Integer weekday;

    public Schedule() {
    }

    @Weekday
    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(@Weekday int weekday) {
        this.weekday = weekday;
    }

    @Retention(RetentionPolicy.RUNTIME)
//    @IntDef({SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY})
    public @interface Weekday {
    }
}
