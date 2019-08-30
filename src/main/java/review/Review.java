package review;/*
 * @author atulyadav on 2019-08-27 14:39
 *
 * Review on a product, didnt used in our project, but we can use it.
 */

public class Review {

    private String productId;
    private String reviewContent;
    private String rating;
    private String userId;
    private long timeStamp;

    public Review(String productId, String reviewContent, String rating, String userId, long timeStamp) {
        this.productId = productId;
        this.reviewContent = reviewContent;
        this.rating = rating;
        this.userId = userId;
        this.timeStamp = timeStamp;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public static class ReviewBuilder {

        private String productId;
        private String reviewContent;
        private String rating;
        private String userId;
        private long timeStamp;


        public String getProductId() {
            return productId;
        }

        public ReviewBuilder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public String getReviewContent() {
            return reviewContent;
        }

        public ReviewBuilder setReviewContent(String reviewContent) {
            this.reviewContent = reviewContent;
            return this;
        }

        public String getRating() {
            return rating;
        }

        public ReviewBuilder setRating(String rating) {
            this.rating = rating;
            return this;
        }

        public String getUserId() {
            return userId;
        }

        public ReviewBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public long getTimeStamp() {
            return timeStamp;
        }

        public ReviewBuilder setTimeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public Review build() {
            return new Review(this.productId, this.reviewContent, this.rating, this.userId, this.timeStamp);
        }
    }

}
