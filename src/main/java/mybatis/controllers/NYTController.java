package mybatis.controllers;

import mybatis.models.nyt.NYTAnalyzePOJO;
import mybatis.models.nyt.NYTBasePojo;
import mybatis.services.NYTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nyt")
public class NYTController {


    @Autowired
    NYTService nytService;

    @GetMapping("/search")
    public NYTBasePojo returnApi(@RequestParam("q") String searchTerm) {
        NYTBasePojo retVal = new NYTBasePojo();
        retVal = nytService.searchNYT("warren");
        return retVal;

    }

    @GetMapping("/analyze")
    public NYTAnalyzePOJO analyze(
            @RequestParam("term") String searchTerm,
            @RequestParam("keyword") String keyword

    ) {
        NYTAnalyzePOJO analysis = new NYTAnalyzePOJO();
        analysis = nytService.analyzeNYT(searchTerm,keyword);

        return analysis;

    }
}
