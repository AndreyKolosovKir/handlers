public class Request {
    protected final String httpMethod;
    protected final String headlines;
    protected String body;

    public Request(BuilderRequest builderRequest) {
        this.httpMethod = builderRequest.httpMethod;
        this.headlines = builderRequest.headlines;
        this.body = builderRequest.body;
    }

    public String toString() {
        return "[Method: " + httpMethod +
                "; Headlines:" + headlines +
                "; Body:" + body +
                "]\r\n";
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getHeadlines() {
        return headlines;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
