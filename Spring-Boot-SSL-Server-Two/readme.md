	
### Generate private-public key pair

- Generate private key

	keytool -genkeypair -alias local -keyalg RSA -keysize 2048 -validity 3650 -dname "CN=tirmizee.com, O=tirmizee" -ext "SAN:c=DNS:localhost,IP:172.20.10.4" -keystore local.p12 -storetype PKCS12 -storepass storepassword
	
- Generate public key
	
	keytool -exportcert -alias local -file local-public.cer -keystore local.p12 -storepass storepassword
	
### Property config

	server.ssl.key-alias=local
	server.ssl.key-store-password=storepassword
	server.ssl.key-store=classpath:keystore/local.p12
	server.ssl.key-store-type=PKCS12