package com.ktb.app.pms.requestservice.config;


import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


public class SOAPConnector extends WebServiceGatewaySupport {

    public Object callWebService(String endpointUrl, Object request){

        try {
            final boolean isHttps = endpointUrl.toLowerCase().startsWith("https");
            HttpsURLConnection httpsConnection = null;
            // Open HTTPS connection
            if (isHttps) {
                // Create SSL context and trust all certificates
                SSLContext sslContext = SSLContext.getInstance("SSL");
                TrustManager[] trustAll
                        = new TrustManager[] {new TrustAllCertificates()};
                sslContext.init(null, trustAll, new java.security.SecureRandom());
                // Set trust all certificates context to HttpsURLConnection
                HttpsURLConnection
                        .setDefaultSSLSocketFactory(sslContext.getSocketFactory());
                // Open HTTPS connection
                URL url = new URL(endpointUrl);
                httpsConnection = (HttpsURLConnection) url.openConnection();
                // Trust all hosts
                httpsConnection.setHostnameVerifier(new TrustAllHosts());
                // Connect
                httpsConnection.connect();
            }
            // Send HTTP SOAP request and get response

            return getWebServiceTemplate().marshalSendAndReceive(endpointUrl, request);
        } catch (IOException
                | NoSuchAlgorithmException | KeyManagementException ex) {
            System.err.println("Error : "+ex.getLocalizedMessage());
        }
        return null;
    }
}


class TrustAllCertificates implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] certs, String authType) {
    }

    public void checkServerTrusted(X509Certificate[] certs, String authType) {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}

class TrustAllHosts implements HostnameVerifier {
    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}