package utils;

import io.qameta.allure.internal.shadowed.jackson.databind.JsonNode;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    //Read data from json
    public static void readJson(String filePath) throws IOException {

        ObjectMapper mapper =new ObjectMapper();
        JsonNode root = mapper.readTree(new File(filePath));

        for (JsonNode node : root){
            String name=node.get("name").asText();
            String role=node.get("role").asText();

            System.out.println("Name: "+name+" "+"Role: "+role);
        }

    }
}
