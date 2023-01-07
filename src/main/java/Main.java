import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        String scheduleWebSiteUrl = "https://cs.msu.ru/studies/schedule";
        Document htmlCode = getHtmlCode(scheduleWebSiteUrl);
        String htmlString = htmlCode.select("a[href]").toString();
        System.out.println(htmlString);
        System.out.println();
        findWantedLink(htmlString);

        String link = "https://cs.msu.ru/sites/cmc/files/docs/3_kurs_osen_2022_18.pdf";
        File fileLoc = new File("C:\\Users\\Zigor\\Desktop\\MSU_schedule\\result.pdf");

        DownloadFileFromURL downloadFileFromURL = new DownloadFileFromURL();
        downloadFileFromURL.download(link, fileLoc);
    }

    public static Document getHtmlCode(String scheduleWebSiteUrl) {
        Document htmlDoc = null;
        try {
            htmlDoc = Jsoup.connect(scheduleWebSiteUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return htmlDoc;
    }

    public static ArrayList<String> findWantedLink(String htmlString) {
        String regex = "\"https:" + "[^,]+" + ".pdf\">";
        ArrayList<String> links = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(htmlString);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        for (String link : links) {
            System.out.println(link);
        }
        return links;
    }
}
