package com.learn.java_version_lab.java18.exercise_16_UTF8_and_text_processing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Utf8TextProcessing {

    static void main(String[] args) throws IOException {

        Path filePath = Path.of("C:\\Users\\PC\\Pictures\\Repos\\java-version-lab\\src\\main\\java\\com\\learn\\java_version_lab\\java18\\exercise_16_UTF8_and_text_processing\\languages.txt");

        List<String> languages = List.of(
                "English",
                "සිංහල",       // Sinhala
                "தமிழ்",       // Tamil
                "Melayu",      // Malay
                "日本語"        // Japanese
        );

        // 1. Check the default charset
        System.out.println("Default Charset: " + Charset.defaultCharset());

        // 2. Write text using UTF-8 explicitly
        Files.write(filePath, languages, StandardCharsets.UTF_8);

        System.out.println("\nData written successfully.");

        // 3. Read text using UTF-8 explicitly
        List<String> readLanguages =
                Files.readAllLines(filePath, StandardCharsets.UTF_8);

        System.out.println("\nReading data from the file:");

        readLanguages.forEach(System.out::println);
    }
}
