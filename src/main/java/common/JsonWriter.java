package common;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class JsonWriter {

    private final ObjectMapper mapper;

    public JsonWriter() {
        this.mapper = new ObjectMapper();
        this.mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    }

    public void writeObjectAsJsonToFile(File file, Object object) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, object);
    }

}
