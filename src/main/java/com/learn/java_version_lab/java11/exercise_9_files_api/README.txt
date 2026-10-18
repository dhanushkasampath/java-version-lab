Let's build a practical Log Analyzer that

reads application.log,
counts ERROR and WARN messages,
identifies slow requests, and
generates a summary.txt report.

We'll use Java 11's Files.readString(), Files.writeString(), and Files.lines().


Note: summary.txt file get auto generated