## Default Jackson Behavior
I can't tell if you have a good understanding of Jackson or not, I believe that what you want to accomplish could be handled by Jackson without much custom intervention:

### Case 1: A single `Animal` object

    { "id": 123456, "food": "biscuit", "comment": "black with white pows" }

↓

    Animal animal = objectMapper.readValue(new File("animalObject.json"), Animal.class);

↓

    Animal{id=123456, food=biscuit, comment=black with white pows}

### Case 2: A list of `Animal`s or an object containing an `Animal`

    { "animals": [ { "id":123456 }, { "id":987654 } ] }

↓

    Zoo zoo = objectMapper.readValue(new File("animalArray.json"), Zoo.class);

↓

    Zoo{animals=[Animal{id=123456, food=null, comment=null}, Animal{id=987654, food=null, comment=null}]}

And the same behavior for an object with `Animal` as a property.

## Using Jackson to Handle Multiple Response Structures
Assuming you are stuck in a situation where you have to handle 2+ responses structures in a single resource, you _could_ write a custom deserializer to tackle your problem. The danger is that you put yourself at risk for code that ends up recursing through multiple levels of a JSON tree--work that Jackson is already reliably providing to you. If you have control of these workflows it would be better to try and make the API more consistent.

### Detecting JSON structure in a custom deserializer
If you were set on writing a custom deserializer, it certainly is possible, but again it will be difficult to write bug free and has potential to be very inefficient.

> <code>if (I have a root Animal)</code>

You could detect if the object can be deserialized as an animal by trying to deserialize it and if an exception is thrown you know it doesn't match.

> <code>if (I have a List or a Animal which is not a root object)</code>

{
        ...
    } else if (I have a List or a Animal which is not a root object)
        {
         load the Animal from database with the id received
       }