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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.common.base.Strings;

import java.io.IOException;

public class ContainerModule2 extends SimpleModule {
    private static final String NAME = "ContainerModule";

    public ContainerModule2() {
        super(NAME);
        addSerializer(Container.class, new ContainerSerializer());
    }

    public static class ContainerSerializer extends JsonSerializer<Container> {
        @Override
        public void serialize(Container container, JsonGenerator jg, SerializerProvider serializers) throws IOException {
            if (container != null) {
                // start object and write description
                jg.writeStartObject();
                jg.writeStringField("description", container.description);

                // only write Element1 if one of its members exist
                Element1 element1 = container.element1;
                if (element1 != null) {
                    if (!Strings.isNullOrEmpty(element1.f11)
                            && !Strings.isNullOrEmpty(element1.f12)) {
                        jg.writeFieldName("element1");
                        jg.writeObject(element1);
                    }
                }

                // only write Element2 if one of its members exist
                Element2 element2 = container.element2;
                if (element2 != null) {
                    if (!Strings.isNullOrEmpty(element2.f21)
                            && !Strings.isNullOrEmpty(element2.f22)) {
                        jg.writeFieldName("element2");
                        jg.writeObject(element2);
                    }
                }

                // close the Container object
                jg.writeEndObject();
            }
        }
    }
}


