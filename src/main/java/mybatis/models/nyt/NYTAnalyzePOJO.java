package mybatis.models.nyt;

public class NYTAnalyzePOJO {

    String searchTerm;
    String keyword;
    int numOccurrences;
    int numArticlesScanned;

    public NYTAnalyzePOJO(String searchTerm, String keyword, int numOccurrences, int numArticlesScanned) {
        this.searchTerm = searchTerm;
        this.keyword = keyword;
        this.numOccurrences = numOccurrences;
        this.numArticlesScanned = numArticlesScanned;
    }

    public NYTAnalyzePOJO() {
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getNumOccurrences() {
        return numOccurrences;
    }

    public void setNumOccurrences(int numOccurrences) {
        this.numOccurrences = numOccurrences;
    }

    public int getNumArticlesScanned() {
        return numArticlesScanned;
    }

    public void setNumArticlesScanned(int numArticlesScanned) {
        this.numArticlesScanned = numArticlesScanned;
    }
}
