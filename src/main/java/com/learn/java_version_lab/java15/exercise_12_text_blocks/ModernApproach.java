package com.learn.java_version_lab.java15.exercise_12_text_blocks;

public class ModernApproach {
    static void main() {
        String sql = """
        SELECT e.id, e.name, e.salary
        FROM employee e
        WHERE e.department = 'IT'
        ORDER BY e.salary DESC
        """;

        System.out.println(sql);

        String json = """
        {
          "id": 1,
          "name": "Dhanushka",
          "department": "IT"
        }
        """;

        System.out.println(json);

        String xml = """
        <employee>
            <id>1</id>
            <name>Dhanushka</name>
            <department>IT</department>
        </employee>
        """;

        System.out.println(xml);

        String html = """
        <html>
        <body>
            <h1>Employee Details</h1>
            <p>Name: Dhanushka</p>
            <p>Department: IT</p>
        </body>
        </html>
        """;

        System.out.println(html);
    }
}
