package StepDefenitions;

import Pojo.BreakinbadPojo;
import Pojo.SpeciesPojo;
import Pojo.ThronesPojo;
import Utils.PayloadUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class GameOfThrones_and_Breakingbad {

    @Test
    public void test1() throws URISyntaxException, IOException {

//        https://api.got.show/api/map/characters

        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.got.show").setPath("api/map/characters");

        HttpGet get = new HttpGet(uriBuilder.build());

        get.setHeader("Accept", "application");

        HttpResponse response = client.execute(get);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        ThronesPojo thronesPojo = objectMapper.readValue(response.getEntity().getContent(), ThronesPojo.class);

        int quantityMale = 0;
        int quantityFemale = 0;

        for (int i = 0; i < thronesPojo.getData().size(); i++) {

            if (thronesPojo.getData().get(i).isMale()) {
                quantityMale++;
            } else {
                quantityFemale++;
            }
        }
        System.out.println("Quantity male is: " + quantityMale);
        System.out.println("Quantity female is: " + quantityFemale);

//        Count number of characters who appeared in the same books
        List<String> A_Game_of_Thrones = new ArrayList<>();
        List<String> A_Clash_of_Kings = new ArrayList<>();
        List<String> A_Storm_of_Swords = new ArrayList<>();
        List<String> A_Feast_for_Crows = new ArrayList<>();
        List<String> A_Dance_with_Dragons = new ArrayList<>();
        List<String> The_Rogue_Prince = new ArrayList<>();
        List<String> The_Mystery_Knight = new ArrayList<>();
        List<String> The_Princess_and_The_Queen = new ArrayList<>();
        List<String> The_Hedge_Knight = new ArrayList<>();
        List<String> The_Winds_of_Winter = new ArrayList<>();


        for (int i = 0; i < thronesPojo.getData().size(); i++) {

            if (thronesPojo.getData().get(i).getBooks().contains("A Game of Thrones")) {
                A_Game_of_Thrones.add(thronesPojo.getData().get(i).getName());
            } else if (thronesPojo.getData().get(i).getBooks().contains("A Clash of Kings")) {
                A_Clash_of_Kings.add(thronesPojo.getData().get(i).getName());
            } else if (thronesPojo.getData().get(i).getBooks().contains("A Storm of Swords")) {
                A_Storm_of_Swords.add(thronesPojo.getData().get(i).getName());
            } else if (thronesPojo.getData().get(i).getBooks().contains("A Feast for Crows")) {
                A_Feast_for_Crows.add(thronesPojo.getData().get(i).getName());
            } else if (thronesPojo.getData().get(i).getBooks().contains("A Dance with Dragons")) {
                A_Dance_with_Dragons.add(thronesPojo.getData().get(i).getName());
            } else if (thronesPojo.getData().get(i).getBooks().contains("The Rogue Prince")) {
                The_Rogue_Prince.add(thronesPojo.getData().get(i).getName());
            } else if (thronesPojo.getData().get(i).getBooks().contains("The Mystery Knight")) {
                The_Mystery_Knight.add(thronesPojo.getData().get(i).getName());
            } else if (thronesPojo.getData().get(i).getBooks().contains("The Princess and the Queen")) {
                The_Princess_and_The_Queen.add(thronesPojo.getData().get(i).getName());
            } else if (thronesPojo.getData().get(i).getBooks().contains("The Hedge Knight")) {
                The_Hedge_Knight.add(thronesPojo.getData().get(i).getName());
            } else if (thronesPojo.getData().get(i).getBooks().contains("The Winds of Winter")) {
                The_Winds_of_Winter.add(thronesPojo.getData().get(i).getName());
            }
        }

        System.out.println("A Game of Thrones number of characters: " + A_Game_of_Thrones.size());
        System.out.println("A Clash of Kings number of characters: " + A_Clash_of_Kings.size());
        System.out.println("A Storm of Swords number of characters: " + A_Storm_of_Swords.size());
        System.out.println("A Feast for Crows number of characters: " + A_Feast_for_Crows.size());
        System.out.println("A Dance with Dragons number of characters: " + A_Dance_with_Dragons.size());
        System.out.println("The Rogue Prince number of characters: " + The_Rogue_Prince.size());
        System.out.println("The Mystery Knight number of characters: " + The_Mystery_Knight.size());
        System.out.println("The Princess and The Queen number of characters: " + The_Princess_and_The_Queen.size());
        System.out.println("The Hedge Knight number of characters: " + The_Hedge_Knight.size());
        System.out.println("The Winds of Winter number of characters: " + The_Winds_of_Winter.size());


    }

    @Test
    public void test2() throws URISyntaxException, IOException {

//        https://breakingbadapi.com/api/characters/1
        HttpClient client = HttpClientBuilder.create().build();

        int idNum = PayloadUtil.generateRandomId();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("breakingbadapi.com").setPath("api/characters/" +
                idNum + "");

        HttpGet get = new HttpGet(uriBuilder.build());

        get.setHeader("Accept", "application/json");

        HttpResponse response = client.execute(get);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        List<BreakinbadPojo> bbcPojos = objectMapper.readValue(response.getEntity().getContent(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, BreakinbadPojo.class));



            System.out.println(bbcPojos.get(0).getChar_id() + "->" + bbcPojos.get(0).getName());


    }


    @Test
    public void test3() throws URISyntaxException, IOException {

        // https://swapi.dev/api/species
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("swapi.dev").setPath("api/species");

        HttpGet get = new HttpGet(uriBuilder.build());

        get.setHeader("Accept", "application/json");

        HttpResponse response = client.execute(get);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        SpeciesPojo speciesPojos = objectMapper.readValue(response.getEntity().getContent(), SpeciesPojo.class);


        List<String> mammal = new ArrayList<>();
        List<String> artificial = new ArrayList<>();
        List<String> sentient = new ArrayList<>();
        List<String> gastropod = new ArrayList<>();
        List<String> reptile = new ArrayList<>();
        List<String> amphibian = new ArrayList<>();

        for (int i=0; i< speciesPojos.getResults().size(); i++){

            if (speciesPojos.getResults().get(i).getClassification().equalsIgnoreCase("mammal")){
                mammal.add(speciesPojos.getResults().get(i).getName());
            }else if (speciesPojos.getResults().get(i).getClassification().equalsIgnoreCase("artificial")) {
                artificial.add(speciesPojos.getResults().get(i).getName());
            }else if (speciesPojos.getResults().get(i).getClassification().equalsIgnoreCase("sentient")) {
                sentient.add(speciesPojos.getResults().get(i).getName());
            }else if (speciesPojos.getResults().get(i).getClassification().equalsIgnoreCase("gastropod")) {
                gastropod.add(speciesPojos.getResults().get(i).getName());
            }else if (speciesPojos.getResults().get(i).getClassification().equalsIgnoreCase("reptile")) {
                reptile.add(speciesPojos.getResults().get(i).getName());
            }else if (speciesPojos.getResults().get(i).getClassification().equalsIgnoreCase("amphibian")) {
                amphibian.add(speciesPojos.getResults().get(i).getName());
            }
        }

        System.out.println("Mammals: "+ mammal);
        System.out.println("Artificials: "+ artificial);
        System.out.println("Sentients: "+ sentient);
        System.out.println("Gastropods: "+ gastropod);
        System.out.println("Reptiles: "+ reptile);
        System.out.println("Amphibians: "+ amphibian);

    }

}
