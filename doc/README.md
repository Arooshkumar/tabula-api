# tabula-api 1.0.0

## API

The HTTP server will be listening to port `8080` by default. All the operations
are stateless.

You should not expose the API service to the Internet. It is designed to be an
internal component.

You should run the server behind a reverse proxy if you need authentication /
horizontal scaling.

### API documentations

See [`/doc/api`](api).

## Configurations

You can configure each runtime with environment variables or Java system
properties.

See [`/doc/configurations.md`](configurations.md) for more details.

## Docker image

The official Docker image is based on OpenJRE 8 and Alpine Linux 3.7.

### Example usage

`docker run --rm -ti -p8080:8080 gavinkflam/tabula-api:1.0.0`

## JAR

You can download the JAR file from the release page.

### Example usage

`java -jar tabula-java-1.0.0-standalone.jar`

## Compatibility

OpenJRE or OracleJRE 8, 9, 10, 11.
