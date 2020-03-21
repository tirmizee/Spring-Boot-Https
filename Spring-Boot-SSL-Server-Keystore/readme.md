### Generate  public/private keypair

	keytool -genkeypair -alias server-keypair -keyalg RSA -keysize 2048 -validity 3650 -dname "CN=server,O=tirmizee.com" -keypass keypassword -keystore server-keystore.jks -storepass storepassword
	
ss

	keytool -genkeypair -alias server-keypair -keyalg RSA -keysize 2048 -validity 3650 -dname "CN=server,O=tirmizee.com" -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -keypass keypassword -keystore server-keystore.jks -storepass storepassword

ss
	
	keytool -exportcert -alias server-keypair -file public-key.cer -keystore server-keystore.jks -storepass storepassword

99

	keytool -importcert -keystore client-truststore.jks -alias public-key -file public-key.cer -storepass clintstorepass -noprompt
	
	
	keytool -export -keystore server-keystore.jks -alias server-keypair -file myCertificate.crt -storepass storepassword