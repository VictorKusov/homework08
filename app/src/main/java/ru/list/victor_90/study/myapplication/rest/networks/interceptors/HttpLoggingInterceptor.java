package ru.list.victor_90.study.myapplication.rest.networks.interceptors;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

public class HttpLoggingInterceptor implements Interceptor {
    private static final String TAG = "HTTP";

    public Response intercept(Interceptor.Chain chain) throws IOException {

        Request request = chain.request();
        Log.i(TAG, "Sending request " + request.url());
        Log.i(TAG, "Request connection " + chain.connection());
        Log.i(TAG, "Request Headers: " + request.headers());
        Log.i(TAG, "REQUEST BODY BEGIN");
        Log.i(TAG, bodyToString(request));
        Log.i(TAG, "REQUEST BODY END");

        Response response = chain.proceed(request);
        ResponseBody responseBody = response.body();
        String responseBodyString = response.body().string();

        // now we have extracted the response body but in the process
        // we have consumed the original response and can't read it again
        // so we need to build a new one to return from this method

        Response newResponse = response.newBuilder().body(ResponseBody.create(responseBody.contentType(),
                responseBodyString.getBytes())).build();

        Log.i(TAG, "Received response for " + response.request().url());
        Log.i(TAG, "Received response Headers: " + response.headers());
        Log.i(TAG, "RESPONSE BODY BEGIN");
        Log.i(TAG, responseBodyString);
        Log.i(TAG, "RESPONSE BODY END");

        return newResponse;
    }

    private static String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final Exception e) {
            return "did not work";
        }
    }
}
