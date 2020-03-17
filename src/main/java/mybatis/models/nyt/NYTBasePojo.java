package mybatis.models.nyt;

public class NYTBasePojo {

    private String status;
    private String copyright;
    private Response response;

    public NYTBasePojo(String status, String copyright, Response response) {
        this.status = status;
        this.copyright = copyright;
        this.response = response;
    }

    public NYTBasePojo() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "NYTBasePojo{" +
                "status='" + status + '\'' +
                ", copyright='" + copyright + '\'' +
                ", response=" + response +
                '}';
    }
}
