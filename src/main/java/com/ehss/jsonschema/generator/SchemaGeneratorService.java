package com.ehss.jsonschema.generator;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.fasterxml.jackson.module.jsonSchema.customProperties.HyperSchemaFactoryWrapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class SchemaGeneratorService {


    public String generateSchema(String json){
        String schemaStr="";
        try {
            ObjectMapper mapper = new ObjectMapper();
            DynamicJsonPojo pojo = mapper.readValue(json,DynamicJsonPojo.class);
            JsonNode jsonNode = mapper.readTree(json);

            ObjectMapper schemaMapper = new ObjectMapper();
            JsonNode schemaNode = schemaMapper.createObjectNode();
            Iterator<String> iterator = jsonNode.fieldNames();

            iterator.forEachRemaining(s -> {

                ((ObjectNode) schemaNode).putArray("required").add(s);

            });


            schemaStr= schemaMapper.writerWithDefaultPrettyPrinter()
                  .writeValueAsString(schemaNode);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return schemaStr;
    }
}
