import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.security.cert.X509Certificate;

    // ========================================
    // 3. UNSAFE TLS CERTIFICATE VALIDATION
    // ========================================

    public void disableCertificateValidation()
            throws Exception {

        TrustManager[] trustAllCertificates =
                new TrustManager[] {

                    new X509TrustManager() {

                        public X509Certificate[]
                        getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }

                        public void checkClientTrusted(
                                X509Certificate[] certs,
                                String authType) {
                            // Intentionally does nothing
                        }

                        public void checkServerTrusted(
                                X509Certificate[] certs,
                                String authType) {
                            // Intentionally does nothing
                        }
                    }
                };

        SSLContext context =
                SSLContext.getInstance("TLS");

        context.init(
                null,
                trustAllCertificates,
                new java.security.SecureRandom()
        );

        HttpsURLConnection
                .setDefaultSSLSocketFactory(
                        context.getSocketFactory()
                );
    }
}