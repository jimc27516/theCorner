package thecorner


class SecurityInterceptor {
    SecurityInterceptor() {
        matchAll()
    }

    boolean before() {
        println("in before Interceptor controller is ${properties.controllerName}")
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
