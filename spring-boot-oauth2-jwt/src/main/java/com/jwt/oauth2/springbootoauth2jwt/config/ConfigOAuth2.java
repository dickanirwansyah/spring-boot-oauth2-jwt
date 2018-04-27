package com.jwt.oauth2.springbootoauth2jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class ConfigOAuth2 extends AuthorizationServerConfigurerAdapter{

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private ConfigJdbc configJdbc;

    @Bean
    public JwtAccessTokenConverter tokenEnhacer(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKeySigningKey);
        converter.setVerifierKey(publicVerifyKey);
        return converter;
    }

    @Bean
    public JwtTokenStore jwtTokenStore(){
        return new JwtTokenStore(tokenEnhacer());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)throws Exception{
        endpoints
                .authenticationManager(authenticationManager)
                .tokenStore(jwtTokenStore())
                .accessTokenConverter(tokenEnhacer());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security)throws Exception{
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer client)throws Exception{
        client
                .jdbc(configJdbc.dataSource());
    }

    //PRIVATE KEY
    private String privateKeySigningKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEogIBAAKCAQEA5aP/2VEGL/ZneHWof9prZTLbrS6WVAyLsADq4HE6Jzhpdvqi\n" +
            "JRNRFmMJZjWXgQAuT+IdhLQJZWZKBhCWKs6m8nUWKVN3C2/gFKIud9NMsYZh5FGP\n" +
            "ftE0r1wKKBr4/FCKPvQ+azTENRLa9nL/OCfW9Um2FnA3OZ2O1t83r8OEk2Ks9wjR\n" +
            "YoH90pH8hqIjrJKvImlpSTCctzrhzr4UPuA9takH9XJJR44eopbaTPD/JpmysnzS\n" +
            "vj7Zo7RUmDbmyVW0PP67LBRF5uZikujsixKMlHzJgatsD4mLEc5VvbR+GqZ4zc1n\n" +
            "ilYt4GgqM5pzP2v59IdqPzUpP7xFIb1arD/8iwIDAQABAoIBAA/dtN+e6X6G179K\n" +
            "4clzndfwG51ripdkBoKyjYfUSuBK1X6S8oD9RKz3Sr71FPKkwI5kYQW6KqwG1TZ2\n" +
            "DuoGPSKjVFSmn6L6p9DFI9DDmJjrX/gWaoOokKtNAKaktm84YVTYKzfc/XFtTBOa\n" +
            "/mcy2Xc5EIucVTR13liaM47BQ3erSCYQJvqxf0TZA1uqjJD9JHbtgijoEcE8IqqC\n" +
            "WN4NRVIugj/qJqwIvjhOzXNGbuumNKkA78xoJLIAuLrYh7HoS0jvNAp7BQXqnY6G\n" +
            "HW/cwatom/UpXpCn+cFLhQ5U7b+ulnQ0n20lP1C4sSfrwQdNhFRz5srxIe86E8yl\n" +
            "devOHoECgYEA9e8oKJbkjvkIQSC8sXpQUhGHO7z/m1ZU3khsjtBAdrtsMzhPVZqE\n" +
            "B4rqF7DHN5JyoYCsX0FDBGV6b7jR8WKIGacXPFEdWI2m1j8OCtVhza12udU54ql1\n" +
            "LxFp6uvBxogIesTIAH/wm8B1ctP/UIxnRNVeODyNFEWbYh0v8ZAhH4UCgYEA7wof\n" +
            "PlhAmelaOq5h0Ia9/AtYKnid28OeVI/8TGuQNV5uVUe+K2k6W8g9K2znnsEXq+y/\n" +
            "q7kkejXHTvXwH1POqsx91D6F4Yk2TkxpIZkSWu99DRX60wI0VgzCIszcUubzlPHH\n" +
            "r07hs0HetYeVM7a4EF/ThxuJgJp3joKsBYhxgM8CgYB9L8/xWV3eqUVaYZ+rd+eK\n" +
            "3wFHl11FZRyuSY944ujth1n8eJ1ppc2vSTb/+CxwTUusiiM0GbRTeJRqalnz1YQS\n" +
            "Csv5GBEoEnLqfA5Z1WSDndjhn3hnuHq+Cs8vlfJ9bKFkXOax2m5P2hfu65r7FX07\n" +
            "vKDJX4kw2H3P46uT+xnhQQKBgESsV8WFfSm6jJ2HM7rAuxwJ9k5dUJyuWnJY21bp\n" +
            "IAj1FCWT8uJt3MI5iLlNFE3bk31lCru++OfTQ2s/5LhbT2hqT0wGmlftH5jnAt0Q\n" +
            "KOHPI9H6mpC8dWSzTaLJ0BJRH3GO9Js8wkLJjb4BMbAlskOiBBcwphQ4TFi42crN\n" +
            "JC6pAoGAAe3I4OFaJOmQgDkf8NZ8n0bk8shSDNeWXtRudoTGHuf7brdyX3RxS7ui\n" +
            "jhUiwj0ENEBtHuxpxdP1rR95Ti5m80folqKuUKZmfwcQx8Eh16mQeg8x5OziDDaz\n" +
            "4egrrINBkb62RaS32VyT+becVqzGB0dJaLVDdYGwoqAYYNL+nZU=\n" +
            "-----END RSA PRIVATE KEY-----\n";

    private String publicVerifyKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5aP/2VEGL/ZneHWof9pr\n" +
            "ZTLbrS6WVAyLsADq4HE6JzhpdvqiJRNRFmMJZjWXgQAuT+IdhLQJZWZKBhCWKs6m\n" +
            "8nUWKVN3C2/gFKIud9NMsYZh5FGPftE0r1wKKBr4/FCKPvQ+azTENRLa9nL/OCfW\n" +
            "9Um2FnA3OZ2O1t83r8OEk2Ks9wjRYoH90pH8hqIjrJKvImlpSTCctzrhzr4UPuA9\n" +
            "takH9XJJR44eopbaTPD/JpmysnzSvj7Zo7RUmDbmyVW0PP67LBRF5uZikujsixKM\n" +
            "lHzJgatsD4mLEc5VvbR+GqZ4zc1nilYt4GgqM5pzP2v59IdqPzUpP7xFIb1arD/8\n" +
            "iwIDAQAB\n" +
            "-----END PUBLIC KEY-----";
}
