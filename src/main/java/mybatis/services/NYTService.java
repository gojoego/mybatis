package mybatis.services;

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
}


