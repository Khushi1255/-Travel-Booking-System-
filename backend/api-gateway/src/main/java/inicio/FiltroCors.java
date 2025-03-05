package inicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;


@Configuration
public class FiltroCors {

	private static final String ALLOWED_HEADERS = "x-requested-with, authorization, Content-Type, Content-Length, Authorization, credential, X-XSRF-TOKEN";
	private static final String ALLOWED_METHODS = "GET, PUT, POST, DELETE, OPTIONS, PATCH";
	private static final String ALLOWED_ORIGIN = "*";
	//private static final String MAX_AGE = "7200"; //2 hours (2 * 60 * 60) 

	//Nota:
	//Segun lo que estuve analizando la Interface WebFilter es una interface
	//funcional debido a que tiene un unico metodo abstracto. Dicho metodo es:
	//reactor.core.publisher.Mono<Void> filter(ServerWebExchange exchange,
	// 													WebFilterChain chain)
    //El cual me permite procesar la solicitud web y (opcionalmente) delegar 
	//en el siguiente WebFilter a través del WebFilterChain proporcionado.
	//Por ser WebFilter una interface funcional puedo retornar una implementacion 
	//de esta usando una funcion lambda(java 8).
	@Bean
	public WebFilter corsFilter() 
	{
		return (ServerWebExchange ctx, WebFilterChain chain) -> {
			ServerHttpRequest request = ctx.getRequest();
			//Devuelve verdadero si la solicitud es CORS válida 
			//verificando la presencia del encabezado Origen y 
			//asegurándose de que los orígenes sean diferentes.
			if (CorsUtils.isCorsRequest(request)) 
			{
				ServerHttpResponse response = ctx.getResponse();
				HttpHeaders headers = response.getHeaders();
				headers.add("Access-Control-Allow-Origin", ALLOWED_ORIGIN);
				headers.add("Access-Control-Allow-Methods", ALLOWED_METHODS);	       
				headers.add("Access-Control-Allow-Headers", ALLOWED_HEADERS);
			}
			return chain.filter(ctx);
		};
	}
	
}
