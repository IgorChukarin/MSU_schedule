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
        String htmlString = htmlCode.toString();

        FindFileFromHtml findFileFromHtml = new FindFileFromHtml(htmlString);

        String schedulePdfLink = findFileFromHtml.findLinks(4);
        File fileLoc = new File("C:\\Users\\Zigor\\Desktop\\projects\\MSU_schedule\\result.pdf");
        DownloadFileFromURL downloadFileFromURL = new DownloadFileFromURL();
        downloadFileFromURL.download(schedulePdfLink, fileLoc);
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
}
