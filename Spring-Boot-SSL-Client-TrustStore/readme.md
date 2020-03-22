### Way 1
 
	static {
		ClassLoader classLoader = SpringBootSslTrustStoreApplication.class.getClassLoader();
		File file = new File(classLoader.getResource("client-truststore.jks").getFile());
		String absolutePath = file.getAbsolutePath();
		System.setProperty("javax.net.ssl.trustStore",absolutePath);
		System.setProperty("javax.net.ssl.trustStorePassword", "clintstorepass");
		System.setProperty("javax.net.ssl.trustStoreType", "JKS");
	}
	
### Way 2

	-Djavax.net.ssl.trustStore=C:\Users\Lenovo-User\eclipse-workspace\Spring-Boot-Https\Spring-Boot-SSL-Client-TrustStore\target\classes\client-truststore.jks
	-Djavax.net.ssl.trustStorePassword=clintstorepass
	-Djavax.net.ssl.trustStoreType=JKS
	-Djavax.net.debug=all
	
### Truststore

	keytool -importcert -keystore truststore.jks -alias lcvemhb7 -file lcvemhb7-public.cer -storepass clintstorepass -noprompt
	
	keytool -importcert -keystore truststore.jks -alias local -file local-public.cer -storepass clintstorepass -noprompt
	
	