package com.mvs.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mvs.net.security.NoSSLv3SocketFactory;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;

import javax.net.ssl.SSLContext;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtil {

    public static <T> T initService(Class<T> clazz, String serviceAddress) {

        OkHttpClient.Builder client = new OkHttpClient.Builder();

        ApiUtil.enableClientTLSv1_2(client);

        // Create an SSLContext that uses our TLS and preventing using SSL(insecure protocol)
        SSLContext context = null;
        try {
            context = SSLContext.getInstance("TLS");

            context.init(null, null, null);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        //removing SSL from supported protocols
        NoSSLv3SocketFactory noSSLFactory = new NoSSLv3SocketFactory(context.getSocketFactory());

        //tell client to use SSL disabled context
        client.sslSocketFactory(noSSLFactory);

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(serviceAddress)
                .build();

        return retrofit.create(clazz);
    }

    public static void enableClientTLSv1_2(OkHttpClient.Builder builder) {

        //enables TLS for api before android 5.0
        ConnectionSpec spec = new
                ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_2)
                .cipherSuites(
                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
                .build();

        builder.connectionSpecs(Collections.singletonList(spec));
    }
}