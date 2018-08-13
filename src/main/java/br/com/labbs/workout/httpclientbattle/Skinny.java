package br.com.labbs.workout.httpclientbattle;

import br.com.labbs.workout.httpclientbattle.shared.HttpClient;
import skinny.http.HTTP;
import skinny.http.Request;
import skinny.http.Response;

public class Skinny implements HttpClient<Request, Response> {

    private static final String SKINNY = "Skinny";
    private final HTTP http = new HTTP();

    @Override
    public String getClientName() {
        return SKINNY;
    }

    @Override
    public Request newRequest(String url) {
        return Request.apply(url);
    }

    @Override
    public void addHeaderToRequest(Request request, String key, String value) {
        request = request.header(key, value);
    }

    @Override
    public Response execRequest(Request request, int i) throws Exception {
        return http.get(request);
    }

    @Override
    public int getResponseStatusCode(Response response) {
        return response.status();
    }
}
