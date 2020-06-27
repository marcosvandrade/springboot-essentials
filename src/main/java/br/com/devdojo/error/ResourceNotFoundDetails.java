package br.com.devdojo.error;

/**
 * @author William Suane for DevDojo on 6/13/17.
 */
public class ResourceNotFoundDetails {

    public String developerMessage;
    public String title;
    public String detail;
    public long timestamp;
    public int status;

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourceNotFoundDetails build() {
            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
            resourceNotFoundDetails.developerMessage = this.developerMessage;
            resourceNotFoundDetails.title = this.title;
            resourceNotFoundDetails.detail = this.detail;
            resourceNotFoundDetails.timestamp = this.timestamp;
            resourceNotFoundDetails.status = this.status;
            return resourceNotFoundDetails;
        }
    }
}