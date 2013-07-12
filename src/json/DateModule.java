package json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.joda.time.LocalDate;


public class DateModule extends SimpleModule {
    public DateModule() {
        addSerializer(LocalDate.class, new DateSerializer());
        addDeserializer(LocalDate.class, new LocalDateDeserializer());
    }
}
