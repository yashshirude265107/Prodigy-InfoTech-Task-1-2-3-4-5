//Problem Statement:
// This program aims to scrape product data (name, price, and rating) from an e-commerce website and store it in a CSV file for further analysis or processing. By using Jsoup, the program connects to the website, extracts the required information, and writes it to a products.csv file.

// E-Commerce Product Data Scraper and Exporter
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

public class EcommerceDataScraper {

    public static void main(String[] args) {
        
        String url = "https://www.example-ecommerce.com/products"; 
        Document doc = null;
        
        try {
            doc = Jsoup.connect(url).get();            
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
                
        Elements products = doc.select("div.product");
        
        try (FileWriter csvWriter = new FileWriter("products.csv")) {            
            csvWriter.append("Name,Price,Rating\n");
                      
            for (Element product : products) {
                
                String name = product.select("h3.product-name").text();
                
                String price = product.select("span.price").text();
                
                String rating = product.select("div.stars").attr("data-rating");
                
                csvWriter.append(String.format("%s,$%s,%s\n", name, price, rating));
                
            }
            
            System.out.println("Data extracted to CSV successfully!");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
