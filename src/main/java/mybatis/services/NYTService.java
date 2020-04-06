package mybatis.services;

import mybatis.models.nyt.Doc;
import mybatis.models.nyt.NYTAnalyzePOJO;
import mybatis.models.nyt.NYTBasePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NYTService {

    @Autowired
    RestTemplate restTemplate;
    final String nytBaseUrl = "https://api.nytimes.com/svc/search/v2/articlesearch.json";
    final String nytApiKey = "C4ha94O1qVOLXyl5kxQkkAOL5AZojQV3";

    public NYTBasePojo searchNYT(String searchTerm) {
        String request = nytBaseUrl + "?q=" + searchTerm + "&api-key=" + nytApiKey;
        NYTBasePojo obj = restTemplate.getForObject(request, NYTBasePojo.class);
        return obj;
    }


    public int numArticlesContain(String keyword, Doc[] docs) {

        int i = 0;

        for (Doc d : docs) {
            if (d.getSnippet().contains(keyword)) {
                i++;
            }
            if (d.getLead_paragraph().contains(keyword)) {
                i++;
            }
        }

        return i;

    }

/*
    public int numArticlesScanned(int num, Doc[] docs){
        // need to return how many articles were scanned
        for (num = 0; num > ; num++ )

        }
    }
*/
    public NYTAnalyzePOJO analyzeNYT(String keyword, String searchTerm) {

        String request = nytBaseUrl + "?q=" + searchTerm + "&api-key=" + nytApiKey;
        NYTBasePojo obj = restTemplate.getForObject(request, NYTBasePojo.class);

        int count = numArticlesContain(searchTerm, obj.getResponse().getDocs());

        NYTAnalyzePOJO analysis = new NYTAnalyzePOJO();
        analysis.setKeyword(keyword);
        analysis.setSearchTerm(searchTerm);
        analysis.setNumOccurrences(count);

        return analysis;
    }




}


