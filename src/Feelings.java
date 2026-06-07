package com.mycompany.mentalproject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Feelings implements Command {
        
    private String getCurrentDate()
    {
        LocalDate today = LocalDate.now();

        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = today.format(customFormatter);
        
        return date;
    }
    
    File jsonFile = new File("C:\\Users\\atsse\\OneDrive\\Documents\\NetBeansProjects\\mentalProject\\src\\main\\java\\com\\mycompany\\mentalproject\\feelingsByDate.json");
    
    @Override
    public void execute(String[] optionalParameters)
    {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject;

            // 1. Check if the file exists and is not empty; if not, initialize a base structure
            if (jsonFile.exists() && jsonFile.length() > 0) {
                try (FileReader reader = new FileReader(jsonFile)) {
                    jsonObject = (JSONObject) parser.parse(reader);
                }
            } else {
                jsonObject = new JSONObject();
                jsonObject.put("feelings", new JSONArray());
            }

            // 2. Extract the "feelings" array
            JSONArray feelingsArray = (JSONArray) jsonObject.get("feelings");

            // 3. Create and add your new feeling object
            JSONObject newFeeling = new JSONObject();
            newFeeling.put("feeling", optionalParameters);
            newFeeling.put("date", getCurrentDate());
            
            feelingsArray.add(newFeeling);

            // 4. Save the modified JSON object back into the file
            try (FileWriter writer = new FileWriter(jsonFile)) {
                writer.write(jsonObject.toJSONString());
                writer.flush(); // Flush the stream to guarantee everything writes to disk
            }

            System.out.println("Successfully updated "+ jsonFile.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
