package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        System.out.println(query);
        String lcase = query.toLowerCase();
        if (lcase.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (lcase.contains("what is")) {
            lcase = removeStart(lcase);
            if (lcase.contains("plus")) {
                String[] parts = lcase.split("plus");
                String firstStr = parts[0].replaceAll("\\D+", "");
                String secondStr = parts[1].replaceAll("\\D+", "");
                int firstInt = Integer.parseInt(firstStr);
                int secondInt = Integer.parseInt(secondStr);
                return firstInt + secondInt + "";
            }
            if (lcase.contains("multiplied")) {
                String[] parts = lcase.split("multiplied");
                String firstStr = parts[0].replaceAll("\\D+", "");
                String secondStr = parts[1].replaceAll("\\D+", "");
                int firstInt = Integer.parseInt(firstStr);
                int secondInt = Integer.parseInt(secondStr);
                return firstInt * secondInt + "";
            }
        }
        return "";
    }

    private String removeStart(String query) {
        return query.split(":")[1];
    }
}
