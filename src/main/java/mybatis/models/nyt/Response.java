package mybatis.models.nyt;

public class Response {

    Doc[] docs;
    Meta meta;

    public Doc[] getDocs() {
        return docs;
    }

    public void setDocs(Doc[] docs) {
        this.docs = docs;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
