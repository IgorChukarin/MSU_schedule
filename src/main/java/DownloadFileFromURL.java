import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadFileFromURL {
    public void download(String pdfLink, File fileLocation) {
        try {
            URL url = new URL(pdfLink);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            BufferedInputStream input = new BufferedInputStream(http.getInputStream());
            FileOutputStream ouputfile = new FileOutputStream(fileLocation);
            BufferedOutputStream bufferOut = new BufferedOutputStream(ouputfile, 1024);

            System.out.println("Your download is now complete.");

            bufferOut.close();
            input.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
