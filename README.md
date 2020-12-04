# multipart

## Build

  mvn clean install

## Run Karaf
  
  tar -xf apache-karaf-4.3.0.tar.gz 
  apache-karaf-4.3.0/bin/karaf

## Deploy

```
feature:install scr 
bundle:install   mvn:org.apache.servicemix.specs/org.apache.servicemix.specs.jaxws-api-2.2/2.9.0
bundle:install   mvn:org.apache.servicemix.specs/org.apache.servicemix.specs.saaj-api-1.3/2.9.0
feature:repo-add mvn:org.apache.aries.jax.rs/org.apache.aries.jax.rs.features/1.0.10/xml
feature:install  aries-jax-rs-whiteboard   aries-jax-rs-whiteboard-jackson
bundle:install mvn:org.alex.soto/multipart/0.0.1-SNAPSHOT
```

# Test
In another terminal:

   curl -v -X PUT -F 'data@=README.md' http://localhost:8181/upload
