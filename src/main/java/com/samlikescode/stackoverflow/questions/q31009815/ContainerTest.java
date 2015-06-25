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
package com.samlikescode.stackoverflow.questions.q31009815;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;

/**
 * //todo(sb)
 */
public class ContainerTest {
    @Test
    public void testContainerSerialization_ObjectMapperConfig() throws JsonProcessingException {
    ObjectMapper om = new ObjectMapper()
            .registerModule(new ContainerModule2());
//            .registerModule(new Element1Module())
//            .setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        ObjectWriter objectWriter = om.writerWithDefaultPrettyPrinter();
        System.out.println("Full container: " + objectWriter.writeValueAsString(buildFakeContainerFull()));
        System.out.println("No Element 1: " + objectWriter.writeValueAsString(buildFakeContainerNoElement1()));
        System.out.println("No Element 2: " + objectWriter.writeValueAsString(buildFakeContainerNoElement2()));
        System.out.println("Empty Container: " + objectWriter.writeValueAsString(buildFakeContainerEmpty()));
    }

    private Container buildFakeContainerFull() {
        Container container = new Container();
        container.description = "an awesome description";
        Element1 element1 = new Element1();
        element1.f11 = "f11 value";
        element1.f12 = "f12 value";
        container.element1 = element1;
        Element2 element2 = new Element2();
        element2.f21 = "f21 value";
        element2.f22 = "f22 value";
        container.element2 = element2;
        return container;
    }

    private Container buildFakeContainerNoElement1() {
        Container container = new Container();
        container.description = "an awesome description";
        Element1 element1 = new Element1();
        element1.f11 = null;
        element1.f12 = null;
        container.element1 = element1;
        Element2 element2 = new Element2();
        element2.f21 = "f21 value";
        element2.f22 = "f22 value";
        container.element2 = element2;
        return container;
    }

    private Container buildFakeContainerNoElement2() {
        Container container = new Container();
        container.description = "an awesome description";
        Element1 element1 = new Element1();
        element1.f11 = "f11 value";
        element1.f12 = "f12 value";
        container.element1 = element1;
        return container;
    }

    private Container buildFakeContainerEmpty() {
        Container container = new Container();
        container.description = "an awesome description";
        return container;
    }
}
