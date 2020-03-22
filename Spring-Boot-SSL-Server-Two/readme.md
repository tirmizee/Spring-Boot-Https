	
### PKCS12

	keytool -genkeypair -alias local -keyalg RSA -keysize 2048 -validity 3650 -dname "CN=tirmizee.com, O=tirmizee" -ext "SAN:c=DNS:localhost,IP:172.20.10.4" -keystore local.p12 -storetype PKCS12 -storepass storepassword
	
	
	keytool -exportcert -alias local -file local-public.cer -keystore local.p12 -storepass storepassword