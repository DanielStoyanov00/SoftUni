package _05Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;


    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public List<String> getUrls() {
        return urls;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        boolean isValid = true;
        for (String number : numbers){
            char[] symbols = number.toCharArray();
            for (char symbol : symbols) {
                if (!Character.isDigit(symbol)){
                    sb.append("Invalid number!").append(System.lineSeparator());
                    isValid = false;
                    break;
                }
            }
            if (isValid){
                sb.append("Calling... " + number).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        boolean isValid = true;
        for (String url : urls){
            char[] symbols = url.toCharArray();
            for (char symbol : symbols) {
                if (Character.isDigit(symbol)){
                    sb.append("Invalid URL!").append(System.lineSeparator());
                    isValid = false;
                    break;
                }
            }
            if (isValid){
                sb.append("Browsing: " + url + "!").append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
