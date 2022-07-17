package com.electrosignal.PhoneBook.service;

import com.electrosignal.PhoneBook.model.Person;
import com.electrosignal.PhoneBook.model.Root;
import com.electrosignal.PhoneBook.model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParserJsonService {


    @Value("${upload.jsonpath}")
    private String uploadJSonPath;

    private static final String TAG_SECONDNAME = "secondName";
    private static final String TAG_FIRSTNAME = "firstName";
    private static final String TAG_THIRDNAME = "thirdName";
    private static final String TAG_DEPARTMENT = "department";
    private static final String TAG_POSITION = "position";
    private static final String TAG_LOCATION = "location";
    private static final String TAG_PEOPLE_MAIN = "people";

    public Root parseFromFile(@AuthenticationPrincipal User user) {
        Root root = new Root();
        JSONParser parser = new JSONParser();

        // В try with resources указываем путь к файлу json
        try (FileReader reader = new FileReader(uploadJSonPath)) {

            JSONObject personJsonObject = (JSONObject) parser.parse(reader);

            JSONArray peopleJsonArray = (JSONArray) personJsonObject.get(TAG_PEOPLE_MAIN);

            List<Person> peopleList = new ArrayList<>();
            for (Object it : peopleJsonArray) {

                JSONObject peopleJsonObject = (JSONObject) it;

                String firstName = (String) peopleJsonObject.get(TAG_FIRSTNAME);
                String secondName = (String) peopleJsonObject.get(TAG_SECONDNAME);
                String thirdName = (String) peopleJsonObject.get(TAG_THIRDNAME);
                String department = (String) peopleJsonObject.get(TAG_DEPARTMENT);
                String position = (String) peopleJsonObject.get(TAG_POSITION);
                String location = (String) peopleJsonObject.get(TAG_LOCATION);
                String phoneNumber = (String) peopleJsonObject.get(null);

                Person people = new Person(firstName, secondName, thirdName, department, position, phoneNumber, location,  user);

                peopleList.add(people);
            }

            root.setPeople(peopleList);
        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }

        return root;
    }

}
