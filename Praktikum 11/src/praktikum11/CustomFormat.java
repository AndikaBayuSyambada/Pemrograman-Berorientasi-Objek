package praktikum11;

import java.text.DecimalFormat;

public class CustomFormat {
    public String customFormat(String pattern, double value) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        return myFormatter.format(value);
    }
}
