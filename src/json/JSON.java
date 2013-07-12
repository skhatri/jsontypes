package json;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

import java.io.StringWriter;

public class JSON {

    public static <T> T parse(String json, Class<T> c) throws Exception {
        MappingJsonFactory factory = createJsonFactory();
        JsonParser jsonParser = factory.createParser(json.getBytes("UTF-8"));
        return jsonParser.readValueAs(c);
    }

    public static String stringify(Object object) throws Exception {
        MappingJsonFactory factory = createJsonFactory();
        StringWriter jsonWriter = new StringWriter();
        JsonGenerator jsonGenerator = factory.createGenerator(jsonWriter);
        jsonGenerator.writeObject(object);
        return jsonWriter.toString();
    }

    private static MappingJsonFactory createJsonFactory() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new DateModule());
        mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector());
        return new MappingJsonFactory(mapper);
    }
}
