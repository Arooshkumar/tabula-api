FROM clojure:lein-2.8.1-alpine as builder
LABEL maintainer="me@gavin.hk"

WORKDIR /usr/src/app

# Fetch dependencies and cache the layer unless project metadata changed

COPY project.clj VERSION ./
RUN lein deps

# Compile uberjar and copy a version agonistic jar for copy in the later stage
COPY . .
RUN \
  lein uberjar && \
  cp \
      target/hk.gavin.tabula-api-$(cat VERSION)-standalone.jar \
      target/hk.gavin.tabula-api-standalone.jar

# =============================================================================
FROM openjdk:8u151-jre-alpine3.7
LABEL maintainer="me@gavin.hk"

EXPOSE 8080

COPY --from=builder \
    /usr/src/app/target/hk.gavin.tabula-api-standalone.jar \
    /usr/src/app/hk.gavin.tabula-api-standalone.jar

CMD ["java", "-jar", "/usr/src/app/hk.gavin.tabula-api-standalone.jar"]