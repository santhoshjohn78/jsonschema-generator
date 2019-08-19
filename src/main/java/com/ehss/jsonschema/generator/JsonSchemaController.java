package com.ehss.jsonschema.generator;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/schema")
@RestController
public class JsonSchemaController {

    @Autowired
    SchemaGeneratorService schemaGeneratorService;

    @PostMapping(value = "/generator", consumes = "application/json",produces = "application/json")
    public String generateJSONSchema(@RequestBody String pojo){

        return schemaGeneratorService.generateSchema(pojo);
    }


    @PostMapping(value = "/generator/ping", consumes = "application/json",produces = "application/json")
    public String ping(@RequestBody String pojo){

        return pojo;
    }
}
