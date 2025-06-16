package filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/*") // Intercepte toutes les requêtes
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Optionnel : initialisation du filtre
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Convertir en HttpServletRequest pour récupérer le chemin
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String chemin = httpRequest.getRequestURI();
            System.out.println("[Filtre] Requête interceptée : " + chemin);
        }

        // Continuer la chaîne (laisser passer la requête)
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Optionnel : nettoyage
    }
}
