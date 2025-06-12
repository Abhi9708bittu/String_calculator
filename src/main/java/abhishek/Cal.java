package abhishek;

import java.util.ArrayList;
import java.util.List;
public class Cal {
    public String add(String input) {
        List<String> errors = new ArrayList<>();
        List<Double> numbers = new ArrayList<>();
        String delimiter = ",|\n";
        int position = 0;
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf('\n');
            if (delimiterEnd == -1) return "Invalid input: No newline after custom delimiter";
            delimiter = java.util.regex.Pattern.quote(input.substring(2, delimiterEnd));
            input = input.substring(delimiterEnd + 1);
        }
        StringBuilder currentNumber = new StringBuilder();
        List<Integer> delimiterPositions = new ArrayList<>();
        List<String> tokens = new ArrayList<>();
        char[] chars = input.toCharArray();
        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || !Character.isDigit(chars[i]) && chars[i] != '.' && chars[i] != '-') {
                String token = currentNumber.toString();
                if (token.isEmpty()) {
                    if (i < chars.length)
                        errors.add("Number expected but '" + chars[i] + "' found at position " + i + ".");
                    else
                        errors.add("Number expected but EOF found.");
                } else {
                    try {
                        double num = Double.parseDouble(token);
                        if (num < 0) errors.add("Negative not allowed : " + (int)num);
                        else numbers.add(num);
                    } catch (NumberFormatException e) {
                        errors.add("Invalid number format at position " + (i - token.length()));
                    }
                }
                currentNumber.setLength(0);
            }
            if (i < chars.length && (Character.isDigit(chars[i]) || chars[i] == '.' || chars[i] == '-')) {
                currentNumber.append(chars[i]);
            }
        }
        if (!errors.isEmpty()) return String.join("\n", errors);
        double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
        return String.valueOf(sum);
    }
    public String multiply(String input) {
        String addResult = add(input);
        if (!addResult.matches("-?\\d+(\\.\\d+)?")) return addResult;
        String delimiter = ",|\n";
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf('\n');
            delimiter = java.util.regex.Pattern.quote(input.substring(2, delimiterEnd));
            input = input.substring(delimiterEnd + 1);
        }
        String[] tokens = input.split(delimiter);
        double product = 1;
        for (String token : tokens) {
            if (token.trim().isEmpty()) continue;
            double num = Double.parseDouble(token.trim());
            product *= num;
        }
        return String.valueOf(product);
    }
}






