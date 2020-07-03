package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class PayloadUtil {

    public static String getPetPayload(int id,String name,String status){
        return "{\n" +
                "  \"id\": "+id+",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \""+status+"\"\n" +
                "}";
    }

    public static String generateStringFromResource(String path) throws IOException {
        String petPayload = new String(Files.readAllBytes(Paths.get(path)));

        return petPayload;
    }

    public static int generateRandomId() {
        Random random = new Random();
        int num=random.nextInt(117 - 1) + 1;;
        while(num>=58&&num<=111){
            num=random.nextInt(117 - 1) + 1;
        }
        return num;

    }

}
