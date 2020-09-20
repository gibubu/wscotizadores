package com.estructura.cotizadores.configurations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Value("${app.client.id}")
	private String CLIENT_ID;
	@Value("${app.client.secret}")
	private String CLIENT_SECRET;
	@Value("${host.full.dns.auth.link}")
	private String AUTH_SERVER;

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("com.api.BonosAgentes.controllers"))
				.paths(PathSelectors.any()).build()
				.securityContexts(Collections.singletonList(securityContext()))
				.securitySchemes(Arrays.asList(securityScheme()))
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder()
				.title("Afirme Seguros - Servicios Web Agentes ")
				.description(
						" Servicios Web transferencia de archivos fortimax - Afirme Seguros")
				.contact(
						new Contact(
								"WSSGROUP - Internacional de Sistemas SA de CV",
								"http://www.wssgroup.com",
								"gsotof@wssgroup.com")).termsOfServiceUrl("#")
				.license("Afirme Seguros")
				.licenseUrl("https://www.afirmeseguros.com").version("1.0.0")
				.build();
	}

	private SecurityScheme securityScheme() {
		List<AuthorizationScope> authorizationScopeList = new ArrayList<AuthorizationScope>();
		authorizationScopeList.add(new AuthorizationScope("read", "read all"));
		authorizationScopeList
				.add(new AuthorizationScope("write", "access all"));

		List<GrantType> grantTypes = new ArrayList<GrantType>();
		GrantType passwordCredentialsGrant = new ResourceOwnerPasswordCredentialsGrant(
				AUTH_SERVER + "/oauth/token");
		grantTypes.add(passwordCredentialsGrant);

		return new OAuth("oauth2", authorizationScopeList, grantTypes);
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth())
				.build();
	}

	private List<SecurityReference> defaultAuth() {
		final AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
		authorizationScopes[0] = new AuthorizationScope("read", "read all");
		authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
		authorizationScopes[2] = new AuthorizationScope("write", "write all");

		return Collections.singletonList(new SecurityReference("oauth2",
				authorizationScopes));
	}

	@SuppressWarnings("deprecation")
	@Bean
	public SecurityConfiguration security() {
		return new SecurityConfiguration(CLIENT_ID, CLIENT_SECRET, "", "",
				"Bearer access token", ApiKeyVehicle.HEADER,
				HttpHeaders.AUTHORIZATION, "");
	}

	@Bean
	public SecurityScheme apiKey() {
		return new ApiKey(HttpHeaders.AUTHORIZATION, "apiKey", "header");
	}

	@Bean
	public SecurityScheme apiCookieKey() {
		return new ApiKey(HttpHeaders.COOKIE, "apiKey", "cookie");
	}
}
