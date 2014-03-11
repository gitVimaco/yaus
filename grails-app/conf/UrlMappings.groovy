import org.springframework.context.i18n.LocaleContextHolder

class UrlMappings {

	static mappings = {
        // Root: show shortener index to allow user input
        "/"(view: "/shortener/index")
        // Avoid unshortening favicon requests
        "/favicon.ico"(redirect: "/images/favicon.ico")
        // Take the string behind slash as unshortener parameter
        "/stats"(controller: "stats")
        "/$code"(controller: "unshortener")
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "500"(view:'/error')
	}
}
