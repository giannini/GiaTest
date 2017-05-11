package com.giannini.common;

import com.alibaba.fastjson.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.io.*;

public class TestFileReader {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        String filepath = "/Users/jiangningyu/Documents/Work/201705-天弘基金/test/filebeat_test1.yml";
        File file = new File(filepath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\r\n");
        }


        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", file.getName());
        jsonObject.put("config", sb.toString());

        System.out.println(jsonObject.toJSONString());

//        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/tmp/test.yaml")));
//        String config = jsonObject.getString("config");
//        bw.write(config, 0, config.length());
//        bw.flush();
        Yaml yaml = new Yaml();
        Object obj = yaml.load(jsonObject.getString("config"));



    }
}
