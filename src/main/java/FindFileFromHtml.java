import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindFileFromHtml {
    private String htmlCode;

    public FindFileFromHtml(String htmlCode) {
        this.htmlCode = htmlCode;
    }

    public String findLinks(int course) {
        String courseNumber = course + "_kurs";
        String result = null;
        String regex = "https" + "[^{,\\s\"]+" + courseNumber + "[^{,\\s\"]+" + ".pdf";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(htmlCode);
        while (matcher.find()) {
            result = (matcher.group());
        }
        return result;
    }
}
