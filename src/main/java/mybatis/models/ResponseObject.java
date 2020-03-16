package mybatis.models;

// create Response object so that all API responses will have the same structure


import java.util.ArrayList;

public class ResponseObject<T> {

    T data;
    // make generic so you can put anything in there later
    String message;
    int response_code;

    public ResponseObject() {
    }

    public ResponseObject(T data, String message, int response_code) {
        this.data = data;
        this.message = message;
        this.response_code = response_code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }
}
