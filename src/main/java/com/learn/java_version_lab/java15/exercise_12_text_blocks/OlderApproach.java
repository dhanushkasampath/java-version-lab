package com.learn.java_version_lab.java15.exercise_12_text_blocks;

public class OlderApproach {
    static void main() {
        String sql = "SELECT e.id, e.name, e.salary " +
                "FROM employee e " +
                "WHERE e.department = 'IT' " +
                "ORDER BY e.salary DESC";

        System.out.println(sql);

        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"Dhanushka\",\n" +
                "  \"department\": \"IT\"\n" +
                "}";

        System.out.println(json);

        String xml = "<employee>\n" +
                "    <id>1</id>\n" +
                "    <name>Dhanushka</name>\n" +
                "    <department>IT</department>\n" +
                "</employee>";

        System.out.println(xml);

        String html = "<html>\n" +
                "<body>\n" +
                "    <h1>Employee Details</h1>\n" +
                "    <p>Name: Dhanushka</p>\n" +
                "    <p>Department: IT</p>\n" +
                "</body>\n" +
                "</html>";

        System.out.println(html);
    }
}
