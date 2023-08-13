public class BuilderRequest {
    protected final String httpMethod;
    protected final String headlines;
    protected String body = "";

    public BuilderRequest(String httpMethod, String headlines) {
        this.httpMethod = httpMethod;
        this.headlines = headlines;
    }

    public BuilderRequest body(String value) {
        this.body = value;
        return this;
    }

    public Request builder() {
        return new Request(this);
    }
}
