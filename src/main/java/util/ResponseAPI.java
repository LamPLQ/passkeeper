package util;

public class ResponseAPI {

    private String message;
    private String requestStatusCode;

    public ResponseAPI(String message, String requestStatusCode){
        this.message = message;
        this.requestStatusCode = requestStatusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRequestStatusCode(String requestStatusCode) {
        this.requestStatusCode = requestStatusCode;
    }
}
