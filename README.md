# spring boot OAuth2 Jwt

<h4>Cara menjalankan</h4>
<h5>spring-boot-oauth2-jwt</h5>

`mvn clean spring-boot:run`

buka browser, aplikasi jalan di port 8888. kemudian jalankan aplikasi kedua .

<h4>Cara menjalankan</h4>
<h5>spring-boot-oauth2-resource</h5>

`mvn clean spring-boot:run`

buka browser atau tab baru, aplikasi jalan di port 8080.


<h4>Mendapatkan token</h4>
masuk ke terminal atau cmd, lalu arahkan ke folder project  `spring-boot-oauth2-jwt` 
kemudian ketik ini di terminal 

`curl -X POST -vu clientGojekApp:mysecret 'http://localhost:8888/oauth/token?username=dickanirwansyah?password=rootroot&grant_type=password'`

jika berhasil outpuntnya adalah token, seperti pada kode dibawah ini :

```
{
  "access_token":"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjQ4NTM1MzIsInVzZXJfbmFtZSI6ImRpY2thbmlyd2Fuc3lhaCIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iLCJST0xFX0VNUExPWUVFIiwiUk9MRV9TVEFGRiJdLCJqdGkiOiI0ZTFjN2U2My1jODA2LTQwZjItOGQ0Ni1kYmU5YWZkMzA2ODEiLCJjbGllbnRfaWQiOiJjbGllbnRHb2pla0FwcCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.bHTgPWVwE6wauQLjF_vvB4DbMja7PScmuF_8BS3AU4ctwEtjDtiimNfNmt_hGA6NPrgDyy6KowVJpBWvOJbCdFUQOLVQ-zBiT5aGcOH9jlwmt3tHFtAUWtbQCahP8PEzw_u11_EPBHcqDFB3uEOjyKcniUvsnF738RD_6swJuR1Z83ikVzhs8b8bsf9dePevixm2-ffHsV-Cqj1kCMVmKtkU7Sa53BDBU-WElOqIQkdfInYVQHImWslmHIRbmG1aCNZKZOoLfPX34coSfh05ArjmOnBmuADpYn6fdxdw2qUs_B1N-6UdnKaLJcNKIvXtHpQctMVi7LDNKvWyvdpYoQ",
  "token_type":"bearer",
  "refresh_token":"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJkaWNrYW5pcndhbnN5YWgiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiYXRpIjoiNGUxYzdlNjMtYzgwNi00MGYyLThkNDYtZGJlOWFmZDMwNjgxIiwiZXhwIjoxNTI0ODUzNTMyLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9FTVBMT1lFRSIsIlJPTEVfU1RBRkYiXSwianRpIjoiZGNiZDY2NzctMWZlZC00Yjg5LTk0ZGQ* Connection #0 to host localhost left intact
  tZjE4MDhmOTZlN2UwIiwiY2xpZW50X2lkIjoiY2xpZW50R29qZWtBcHAifQ.w3MB_DlE4PTJXJYuhX-ga_VFwEv0zffsQW-57YmcS8jNFfH1OVSUFTJwpBirlJdkqKOpG1iM_6xpnJcVtaRuiFU_OsZY049LJfQd7iq8Pz5W6GHYQWzrij-5f_5ZrM-cb-A6V-4Kqbb7-i4h-KRHsBN9c4s5NUmvijFDdX6AkyWIPVewQQJPRH33jTEivpD13IwOCb8-B4oNx0-fS_3d2nPhyI7YVWaj9p3GB_bCkqzxX0zikQ1boKs_Uys6-MOPRQezWAIxhxbXmwj56i8RM29Qgo96uFBFPhlwuzzAxBCOOGnJCm7ruu46_ZmX0UqtU2rUhqMy3PXVqAekTlzJGw",
  "expires_in":35999,
  "scope":"read write",
  "jti":"4e1c7e63-c806-40f2-8d46-dbe9afd30681"
}
```

<h4>Mendapatkan Data</h4>
setelah token didapatkan, kemudian arahkan ke folder project `spring-boot-oauth2-jwt-resource`, kemudian ketikkan ini diterminal

`curl http://localhost:8080/api/barang -H "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjQ4NTM1MzIsInVzZXJfbmFtZSI6ImRpY2thbmlyd2Fuc3lhaCIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iLCJST0xFX0VNUExPWUVFIiwiUk9MRV9TVEFGRiJdLCJqdGkiOiI0ZTFjN2U2My1jODA2LTQwZjItOGQ0Ni1kYmU5YWZkMzA2ODEiLCJjbGllbnRfaWQiOiJjbGllbnRHb2pla0FwcCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.bHTgPWVwE6wauQLjF_vvB4DbMja7PScmuF_8BS3AU4ctwEtjDtiimNfNmt_hGA6NPrgDyy6KowVJpBWvOJbCdFUQOLVQ-zBiT5aGcOH9jlwmt3tHFtAUWtbQCahP8PEzw_u11_EPBHcqDFB3uEOjyKcniUvsnF738RD_6swJuR1Z83ikVzhs8b8bsf9dePevixm2-ffHsV-Cqj1kCMVmKtkU7Sa53BDBU-WElOqIQkdfInYVQHImWslmHIRbmG1aCNZKZOoLfPX34coSfh05ArjmOnBmuADpYn6fdxdw2qUs_B1N-6UdnKaLJcNKIvXtHpQctMVi7LDNKvWyvdpYoQ"`

ibaratnya `Authorization: Bearer xxxxxxxxx` adalah header, dan jangan lupa untuk ambil token `"access_token"` kemudian di copy paste
setalah `Bearer`. Jika berhasil maka outputnya adalah data barang, bisa dilihat pada kode dibawah ini:

```
[
  { 
    "idbarang":9,
    "name":"Buku harry potter deathly hallows",
    "description":"Novel",
    "unitprice":1000,
    "quantity":100
   },
  {
    "idbarang":10,
    "name":"Buku Java Programming",
    "description":"Ilmiah",
    "unitprice":25000,
    "quantity":19
    },
  { 
    "idbarang":11,
    "name":"Buku Lord Of The Ring",
    "description":"Novel",
    "unitprice":150000,
    "quantity":9
    },
  { 
    "idbarang":12,"name":"Buku Ruby For Beginer",
    "description":"Ilmiah",
    "unitprice":29000,
    "quantity":20
    },
  { 
    "idbarang":13,
    "name":"Buku Spiderman 4",
    "description":"Fiksi",
    "unitprice":30000,
    "quantity":11
    }
]
```

<h4>Schema Database MySQL OAuth2</h4>
sekema oauth2 mysql

```
create table oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
);

create table oauth_client_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);


CREATE TABLE oauth_access_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BLOB,
  authentication_id VARCHAR(256) DEFAULT NULL,
  user_name VARCHAR(256) DEFAULT NULL,
  client_id VARCHAR(256) DEFAULT NULL,
  authentication BLOB,
  refresh_token VARCHAR(256) DEFAULT NULL
);

CREATE TABLE oauth_refresh_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BLOB,
  authentication BLOB
);

create table oauth_code (
  code VARCHAR(256),
  authentication bytea
);

create table oauth_approvals (
  userId VARCHAR(256),
  clientId VARCHAR(256),
  scope VARCHAR(256),
  status VARCHAR(10),
  expiresAt TIMESTAMP,
  lastModifiedAt TIMESTAMP
);
```


