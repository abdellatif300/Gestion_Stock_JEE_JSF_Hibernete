package com.service.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.service.Entitys.Articles_Stock;

import com.service.dao.Functtions;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class PythonServer extends ActionSupport {
    private List<Integer> idArt;
    private String glasses;

    public PythonServer(List<Integer> idArt, String glasses) {
        this.idArt = idArt;
        this.glasses = glasses;
    }

    public String getGlasses() {
        return glasses;
    }

    public void setGlasses(String glasses) {
        this.glasses = glasses;
    }

    public List<Integer> getIdArt() {
        return idArt;
    }

    public void setIdArt(List<Integer> idArt) {
        this.idArt = idArt;
    }

    public PythonServer() {
        super();

    }
    public String testGlasses(){
        Functtions fn =  ContextProvider.provideContext().getBean("stDao", Functtions.class);
        Articles_Stock art=fn.gitArticlById(idArt.get(0));
        setGlasses(art.getImgPng());
        return "success";
    }
    public static void runPythonCode() {
        try {
            // Create the ProcessBuilder
            ProcessBuilder pb = new ProcessBuilder("python", "faceGlasses/app.py");

            // Start the process
            Process process = pb.start();

            // Read the output from the process
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Process and use the output as needed
                System.out.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Python script executed with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
