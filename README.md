## TESTZ

Collection of techniques used in testing of spring applications.

[Hovefly Examples](hoverfly/README.md)

[Rest Assured Examples](rest-assured/README.md)

[Spring Boot Tests Examples](boottestz/README.md)

[Load Test Example](load/README.md)

Load test is written in scala using [gatling](https://gatling.io/).

### App module 

Demonstrates the use of docker file plugin to [containerize](app/README.md) the application

### Static Code Analysis

`app` module is used to generate reports.

From `app/` directory, run `mvn site:site` to generate code analysis reports.  Reports will be available from `target/site/index.html`