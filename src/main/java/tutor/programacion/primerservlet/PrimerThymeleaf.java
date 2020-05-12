package tutor.programacion.primerservlet;

import javax.servlet.ServletContext;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

public class PrimerThymeleaf {

    private final TemplateEngine templateEngine;

    public PrimerThymeleaf(final ServletContext ctx) {

        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(ctx);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        
        // tiempo en cache
        templateResolver.setCacheTTLMs(3600000L);
        
        // desactivar la cache, true para activarla
        templateResolver.setCacheable(false);

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }
}
