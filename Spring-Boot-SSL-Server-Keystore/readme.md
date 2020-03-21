### 

	keytool -genkeypair -alias server-keypair -keyalg RSA -keysize 2048 -validity 3650 -dname "CN=tirmizee.com, O=tirmizee" -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -keypass keypassword -keystore keystore.jks -storepass storepassword

### 
	
	keytool -exportcert -alias server-keypair -file publickey.cer -keystore keystore.jks -storepass storepassword

### 

	keytool -importcert -keystore truststore.jks -alias public-key -file publickey.cer -storepass clintstorepass -noprompt
	