package thecorner


class SecurityInterceptor {
    SecurityInterceptor() {
        matchAll().except(controller:'Home', action:'login').except(controller:'Register', action:'registerPerson')
    }

    boolean before() {
        println( actionName )
        if (!session.user && (actionName != "login" && actionName != "registerPerson")) {
            redirect(controller: "Home", action: "login")
            return false
        }
        return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
