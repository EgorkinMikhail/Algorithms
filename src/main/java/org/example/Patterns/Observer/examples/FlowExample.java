package org.example.Patterns.Observer.examples;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class FlowExample {
  public static void main(String[] args) throws InterruptedException {
    SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
    Flow.Subscriber<String> subscriber = new Flow.Subscriber<>() {
      @Override
      public void onSubscribe(Flow.Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
      }

      @Override
      public void onNext(String item) {
        System.out.println(item);
      }

      @Override
      public void onError(Throwable throwable) {
        throwable.printStackTrace();
      }

      @Override
      public void onComplete() {
        System.out.println("Done");
      }
    };

    publisher.subscribe(subscriber);
    publisher.submit("Hello, Flow!");
    publisher.close();
  }
}


