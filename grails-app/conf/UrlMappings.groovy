import org.springframework.context.i18n.LocaleContextHolder

class UrlMappings {

	static mappings = {
        "/"(view: "/shortener/index")
        "/favicon.ico"(redirect: "/images/favicon.ico")
        "/$code"(controller: "unshortener")
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "500"(view:'/error')
	}
}
