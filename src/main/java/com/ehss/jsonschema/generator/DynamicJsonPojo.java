package com.ehss.jsonschema.generator;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DynamicJsonPojo {


    Map<String, Object> detail = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetail(String key, Object value) {
        detail.put(key, value);
    }

    public Map<String,Object> getDetail(){
        return detail;
    }
}
