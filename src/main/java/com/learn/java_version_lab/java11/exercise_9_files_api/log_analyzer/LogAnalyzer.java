package com.learn.java_version_lab.java11.exercise_9_files_api.log_analyzer;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class LogAnalyzer {

    private static final Path LOG_FILE =
            Path.of("/home/dhanushka/Documents/example-repos/JAVA_NEW_FEATURES/java-version-lab/src/main/java/com/learn/java_version_lab/java11/exercise_9_files_api/log_analyzer/application.log");

    private static final Path SUMMARY_FILE =
            Path.of("/home/dhanushka/Documents/example-repos/JAVA_NEW_FEATURES/java-version-lab/src/main/java/com/learn/java_version_lab/java11/exercise_9_files_api/log_analyzer/summary.txt");

    private static final int SLOW_REQUEST_THRESHOLD_MS = 1000;

    static void main(String[] args) {

        try {
            // 1. Read the entire file using Files.readString()
            String logContent = Files.readString(LOG_FILE); // *************

            System.out.println("Log file loaded successfully.");
            System.out.println("File size: "
                    + logContent.length() + " characters");

            // 2. Count ERROR messages using Files.lines()
            long errorCount;

            try (var lines = Files.lines(LOG_FILE)) {  // **********
                errorCount = lines
                        .filter(line -> line.contains("ERROR"))
                        .count();
            }

            // 3. Count WARN messages using Files.lines()
            long warnCount;

            try (var lines = Files.lines(LOG_FILE)) {
                warnCount = lines
                        .filter(line -> line.contains("WARN"))
                        .count();
            }

            // 4. Find slow requests using Files.lines()
            List<String> slowRequests;

            try (var lines = Files.lines(LOG_FILE)) {
                slowRequests = lines
                        .filter(LogAnalyzer::isSlowRequest)
                        .collect(Collectors.toList());
            }

            // 5. Count total lines
            long totalLines = logContent.lines().count();

            // 6. Build the summary report
            StringBuilder summary = new StringBuilder();

            summary.append("APPLICATION LOG SUMMARY\n");
            summary.append("=======================\n\n");

            summary.append("Total log lines: ")
                    .append(totalLines).append("\n");

            summary.append("ERROR count: ")
                    .append(errorCount).append("\n");

            summary.append("WARN count: ")
                    .append(warnCount).append("\n");

            summary.append("Slow request threshold: ")
                    .append(SLOW_REQUEST_THRESHOLD_MS)
                    .append(" ms\n");

            summary.append("Slow request count: ")
                    .append(slowRequests.size())
                    .append("\n\n");

            summary.append("SLOW REQUESTS\n");
            summary.append("-------------\n");

            if (slowRequests.isEmpty()) {
                summary.append("No slow requests found.\n");
            } else {
                for (String request : slowRequests) {
                    summary.append(request).append("\n");
                }
            }

            // 7. Write the summary using Files.writeString()
            Files.writeString(SUMMARY_FILE, summary.toString());  // ***********

            System.out.println("ERROR count: " + errorCount);
            System.out.println("WARN count: " + warnCount);
            System.out.println("Slow requests: " + slowRequests.size());

            System.out.println("Summary saved to: "
                    + SUMMARY_FILE.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Failed to process log file: "
                    + e.getMessage());
        }
    }

    private static boolean isSlowRequest(String line) {

        // Find the duration, for example: "completed in 1500ms"
        int markerIndex = line.indexOf("completed in ");

        if (markerIndex == -1) {
            return false;
        }

        int durationStart = markerIndex + "completed in ".length();
        int durationEnd = line.indexOf("ms", durationStart);

        if (durationEnd == -1) {
            return false;
        }

        try {
            long duration = Long.parseLong(
                    line.substring(durationStart, durationEnd).trim()
            );

            return duration > SLOW_REQUEST_THRESHOLD_MS;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
