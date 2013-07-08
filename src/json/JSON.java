package json;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import java.io.StringWriter;

public class JSON {

    public static <T> T parse(String json, Class<T> c) throws Exception {
        MappingJsonFactory factory = createJsonFactory();
        JsonParser jsonParser = factory.createJsonParser(json.getBytes("UTF-8"));
        return jsonParser.readValueAs(c);
    }

    public static String stringify(Object object) throws Exception {
        MappingJsonFactory factory = createJsonFactory();
        StringWriter jsonWriter = new StringWriter();
        JsonGenerator jsonGenerator = factory.createJsonGenerator(jsonWriter);
        jsonGenerator.writeObject(object);
        return jsonWriter.toString();
    }

    private static MappingJsonFactory createJsonFactory() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector());
        return new MappingJsonFactory(mapper);
    }
}
