package com.rateLimiter;

public class TokenBucketTest {

    public static void main(String[] args) {
         TokenBucket tokenBucket = new TokenBucket(TokenBucketConstants.maxBucketSize,
                                   TokenBucketConstants.numberOfRequest,
                                   TokenBucketConstants.windowSizeForRateLimitInMilliSeconds);

         int numberOfConsumed = 0;
         long startTime = System.currentTimeMillis();

         // no of token consumed will be 40 in 4 intervals
         // Maximum 10 tokens will be consumed in each interval
         int totalTime = 20 * 1000;
         while ((System.currentTimeMillis() - startTime) < totalTime){
             boolean consumeSuccess = tokenBucket.tryConsume();
             //System.out.println("try consume = "+ consumeSuccess);
             if (consumeSuccess){
                 numberOfConsumed++;
                 System.out.println("Number of token consumed: " + numberOfConsumed);
             }
         }
    }
}
