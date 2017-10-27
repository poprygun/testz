# Containerized version of the application

## Spin up a local docker registry

```bash
docker run -d -p 5000:5000 --restart=always --name registry registry:2
```

## Push app image to local registry
```bash
mvn clean package -Pdocker

mvn dockerfile:push
```

`mvn dockerfile:push` runs `docker push localhost:5000/testz/app` command

`docker push localhost:5000/testz/app` corresponds to setting in pom.xml plugin


docker pull localhost:5000/testz/app:0.0.1-SNAPSHOT

## Run app image

```bash
docker run -p 8080:8080 -t localhost:5000/testz/app:0.0.1-SNAPSHOT
```
## To add the image dependency in another project (local)

Add to the pom.xml

```xml
<build>
  <extensions>
    <extension>
      <groupId>com.spotify</groupId>
      <artifactId>dockerfile-maven-extension</artifactId>
      <version>1.3.6</version>
    </extension>
  </extensions>
</build>
```

```xml
<dependency>
  <groupId>testz</groupId>
  <artifactId>app</artifactId>
  <version>1.0-SNAPSHOT</version>
  <type>docker-info</type>
</dependency>
```