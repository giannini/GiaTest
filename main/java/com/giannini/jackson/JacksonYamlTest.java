package com.giannini.jackson;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

/**
 * Created by Fenglin on 2017/5/11.
 */
public class JacksonYamlTest {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("main/resources/filebeat.dt.yml"));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\r\n");
        }
        String jsonstr = convertYamlToJson(sb.toString());
        System.out.println(jsonstr);

        convertJsonToYamlFile(jsonstr);

    }

    public static String convertYamlToJson(String yaml) throws IOException {

        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Object obj = yamlReader.readValue(yaml, Object.class);

        ObjectMapper jsonWriter = new ObjectMapper();
        return jsonWriter.writeValueAsString(obj);
    }

    public static void convertJsonToYamlFile(String json) throws IOException {
        Yaml yaml = new Yaml();
        Map<String, Object> map = (Map<String, Object>) yaml.load(json);

        Writer writer = new FileWriter("main/resources/out.dt.yml");
        yaml.dump(map, writer);

        String yamlstr = yaml.dump(map);

        BufferedReader br = new BufferedReader(new StringReader(yamlstr));

        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\r\n");
        }

        JSONObject obj = new JSONObject();
        obj.put("yaml", sb.toString());
        System.out.println(obj.toJSONString());

    }
}
