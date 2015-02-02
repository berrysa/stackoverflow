# What is the simplest way to configure the indentation spacing on a Jackson ObjectMapper?
----
I'm really struggling with the degree of complexity I am perceiving in solving this problem. As the title says: **What is a simple way to create a Jackson `ObjectMapper` with a 4-space `PrettyPrinter`?**

Bonus points: How can I **modify an existing** `ObjectMapper` to make it pretty print 4 spaces?

Through my research, I've found that the simplest way is to enable pretty printing generally is to set `INDENT_OUTPUT` on the mapper:

    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

However, this only enables the the `DefaultPrettyPrinter`, which has 2 spaces of indentation. I would like 4. To do this, it seems like I have to construct my own `ObjectMapper`, providing a `JsonFactory` with a `JsonGenerator` that has a `PrettyPrinter` that does 4 spaces. This is way too intense for something that is so so so simple on other platforms. Please tell me there is a simpler way.