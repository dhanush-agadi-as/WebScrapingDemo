package com.web_scraping.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;


import java.io.IOException;

@Component
public class BookScrapping {

    public void fetchBook() {
        String url = "https://books.toscrape.com/";

        try{
            Document document = Jsoup.connect(url).get();
            Elements books = document.select(".product_pod");
            System.out.println("++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Web Scraping from the books to scrape ");
            for(Element bk : books){
                String title = bk.select("h3 > a").text();
                String price = bk.select(".price_color").text();
                if(Double.parseDouble(price.substring(1))>=50.0){
                    System.out.println("title : " + title + " ,price : " + price);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }



}
