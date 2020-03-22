### Generate private-public key pair

- Generate private key 

	keytool -genkeypair -alias lcvemhb7 -keyalg RSA -keysize 2048 -validity 365 -dname "CN=laptop-lcvemhb7, O=tirmizee" -keypass keypassword -keystore serverone.jks -storepass storepassword

- Generate public key 
	
	keytool -exportcert -alias lcvemhb7 -file lcvemhb7-public.cer -keystore serverone.jks -storepass storepassword

### Property config

	server.ssl.key-alias=lcvemhb7
	server.ssl.key-password=keypassword
	server.ssl.key-store-password=storepassword
	server.ssl.key-store=classpath:keystore/serverone.jks
	server.ssl.key-store-type=JKS
	
### Run 
	
- VM arguments
	
	-Djavax.net.debug=all
	
### Console

	found key for : lcvemhb7
	chain [0] = [
	[
	  Version: V3
	  Subject: CN=laptop-lcvemhb7, O=tirmizee
	  Signature Algorithm: SHA256withRSA, OID = 1.2.840.113549.1.1.11
	
	  Key:  Sun RSA public key, 2048 bits
	  modulus: 20068792122729721580488870450737542899452456223291378884641535376151445009916957641314201421938964953399668941573077068806102801335855349227228036170632881807783536294748592508996210909295923618269343052746110091425300962986075441411721461271208143533879765522885840411675890075255706487808049861611280908886005048096826004981657787023748475778415482361054571207804798842657426276262607407592036348326221034820519249871138045152246667667642746950443003276989762871728789155659378812559449513653945121879639950828068887710210133093329058163070790803641168109381856006485591389722676933263731046269489880992006415208769
	  public exponent: 65537
	  Validity: [From: Sun Mar 22 13:18:48 ICT 2020,
	               To: Mon Mar 22 13:18:48 ICT 2021]
	  Issuer: CN=laptop-lcvemhb7, O=tirmizee
	  SerialNumber: [    2db605e0]
	
	Certificate Extensions: 1
	[1]: ObjectId: 2.5.29.14 Criticality=false
	SubjectKeyIdentifier [
	KeyIdentifier [
	0000: 4E F0 2D EC CB F5 53 C0   2B D7 69 84 9D C7 16 A6  N.-...S.+.i.....
	0010: 15 F0 97 AA                                        ....
	]
	]
	
	]
	  Algorithm: [SHA256withRSA]
	  Signature:
	0000: 20 53 46 28 8E 75 C2 29   65 EA A8 10 32 A0 67 86   SF(.u.)e...2.g.
	0010: 7B DC 12 1C FE 0D 95 77   5F B0 D2 E3 B6 03 AF 87  .......w_.......
	0020: FF 54 D4 BB DC 4D 66 6A   11 0D 9F A6 BE B4 D4 E9  .T...Mfj........
	0030: 20 53 70 9C 25 04 E5 34   C4 FD 28 FA 53 BB 9D 72   Sp.%..4..(.S..r
	0040: 53 EC 5E 79 BB C7 73 3D   35 49 2E 6B E8 BD 97 C0  S.^y..s=5I.k....
	0050: B9 D7 7D 75 10 C0 D0 F7   97 3C 9D 75 82 0F BC 53  ...u.....<.u...S
	0060: DD 6D F4 D2 68 84 A3 08   CF 42 F9 9A E9 8D 5D 2D  .m..h....B....]-
	0070: EA D8 A8 ED B7 CC A4 9B   94 F7 65 94 4F D9 F3 60  ..........e.O..`
	0080: 04 29 54 1C 0F F6 1B EF   0F 2F F8 2D 39 42 EC E9  .)T....../.-9B..
	0090: 72 DC 40 2F 9E 26 1B 7D   CB C0 AD 76 01 BC E4 89  r.@/.&.....v....
	00A0: C3 B1 E7 A5 51 E9 FD 66   54 A1 2B D2 E0 DA 0D 06  ....Q..fT.+.....
	00B0: B4 25 AE 53 46 58 41 0A   DB 5F CE FF EA BB 61 70  .%.SFXA.._....ap
	00C0: 95 59 16 2E 5B C0 47 B3   5E 64 45 24 7F 5B 68 79  .Y..[.G.^dE$.[hy
	00D0: 19 05 00 76 60 F9 3A 7D   B5 C1 CB D8 7C FB 9D 62  ...v`.:........b
	00E0: 88 E5 CA 72 A8 D9 C2 13   04 2D A2 77 42 35 57 68  ...r.....-.wB5Wh
	00F0: 99 E2 53 0B F1 4A B5 F0   D6 AA F9 1E 9E C6 2B E2  ..S..J........+.
	
	]
	***
	Inaccessible trust store: C:\Program Files\Java\jre1.8.0_221\lib\security\jssecacerts
	trustStore is: C:\Program Files\Java\jre1.8.0_221\lib\security\cacerts
	trustStore type is: jks
	trustStore provider is: 
	the last modified time is: Sun Oct 06 22:19:57 ICT 2019
	adding as trusted cert:
	  Subject: CN=Entrust Root Certification Authority - EC1, OU="(c) 2012 Entrust, Inc. - for authorized use only", OU=See www.entrust.net/legal-terms, O="Entrust, Inc.", C=US
	  Issuer:  CN=Entrust Root Certification Authority - EC1, OU="(c) 2012 Entrust, Inc. - for authorized use only", OU=See www.entrust.net/legal-terms, O="Entrust, Inc.", C=US
	  Algorithm: EC; Serial number: 0xa68b79290000000050d091f9
	  Valid from Tue Dec 18 22:25:36 ICT 2012 until Fri Dec 18 22:55:36 ICT 2037
