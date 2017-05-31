# SpringBoot-OAuth2-starter
### Spring Boot base with MongoDB and OAuth 2.0 authentication.
This is a quick-start base for java projects with Spring Boot, MongoDB and configured OAuth2 security.
### Running
* Download this base
* Start the MongoDB service/daemon in your system 
* Run project by `Application.class` or by `mvn clean install`, `java -jar target/*.jar`, or by `mvn spring-boot:run`

---
### [Oauth2](https://oauth.net/2/)-based security

Please, have a look at official [Spring example](http://projects.spring.io/spring-security-oauth/docs/oauth2.html) for
quick start, and base knowledge about this type of security. 

### Security Configuration

**IT IS IMPORTANT:** from Spring Boot version 1.5.0 you need to specify the oauth security filter order like this:

[application.yml]():

```yaml
security:
  oauth2:
    resource:
      filter-order: 3
```

You need to configure [Authorization Server](), [Resource Server]() and common [Web security]();

In [Web security]() you can provide your custom `UserDetailsService` to use database for storing users. Or use in-memory authentication.
The important thing that you should register `AuthenticationManager` to use that in Authorization Server:

[SecurityConfig]():

```java
@Bean
@Override
public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
}
```

Note that declaration of http routes security can be placed both in [Resource Server]() or [Web security](). In this project 
i placed it in [Resource Server]() config:

```java
http
    .requestMatcher(new OAuthRequestMatcher())
    .authorizeRequests()
    .antMatchers("/api/v1/user").hasRole("USER");
```

In [Authorization Server]() config you should set `AuthenticationManager` registered with [SecurityConfig](), along with token store:

```java
@Override
public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints
            .tokenStore(tokenStore())
            .authenticationManager(authenticationManager)
            .userDetailsService(userDetailsService)
            .pathMapping("/oauth/authorize", "/api/v1/authorize")
            .pathMapping("/oauth/token", "/api/v1/token")
            .pathMapping("/oauth/сheck_token", "/api/v1/token/check");
}
```

I used `InMemoryTokenStore()` which can be replaced with your custom store for storing token in database.

### Testing

