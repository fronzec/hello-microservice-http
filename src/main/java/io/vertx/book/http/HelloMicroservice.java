package io.vertx.book.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class HelloMicroservice extends AbstractVerticle {

  @Override
  public void start() {
    //Routing and parameters
    Router router = Router.router(vertx);
    router.get("/").handler(rc -> rc.response().end("Hello"));
    router.get("/:name").handler(rc-> rc.response().end("Hello" + rc.pathParam("name")));
    vertx.createHttpServer().requestHandler(router::accept).listen(8080);
  }

}
