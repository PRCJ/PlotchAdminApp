package com.plotch.sdk.utils;

import android.os.Bundle;

public interface RemoteLogger {

    void init();

    void log(TAG tag, Bundle params);

    void logApiEvent(ApiLog data);

    void logScreen(String screen, KEY event, Bundle extras);

    enum TAG {
        ERROR("ApiError"),
        APISUCCESS("ApiSuccess"),
        SCREEN("Screen");
        final String val;

        TAG(String s) {
            this.val = s;
        }

        @Override
        public String toString() {
            return val;
        }
    }

    enum KEY {
        USER_ID("userId"),
        INSTALL_ID("installId"),
        NETWORK("network"),
        DEVICE("device"),
        VERSION("version"),
        OS("os"),
        TAG("tag"),
        STATUS_CODE("statusCode"),
        BODY("body"),
        LATENCY("latency"),
        ON_START("onStart"),
        ON_RESUME("onResume"),
        SCREEN("screen"),
        TYPE("type"),
        ENDPOINT("endpoint");


        final String val;

        KEY(String s) {
            this.val = s;
        }

        @Override
        public String toString() {
            return val;
        }
    }

    class ApiLog {
        private String stacktrace;
        private int status;
        private String endpoint;
        private long latency;

        private ApiLog(Builder builder) {
            this.stacktrace = builder.stacktrace;
            this.status = builder.status;
            this.endpoint = builder.endpoint;
            this.latency = builder.latency;
        }

        public long getLatency() {
            return latency;
        }

        public String getStacktrace() {
            return stacktrace;
        }

        public int getStatus() {
            return status;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public static class Builder {
            private String stacktrace;
            private int status;
            private long latency;
            private String endpoint;

            public Builder stacktrace(String stacktrace) {
                this.stacktrace = stacktrace;
                return this;
            }

            public Builder status(int status) {
                this.status = status;
                return this;
            }

            public Builder endpoint(String endpoint) {
                this.endpoint = endpoint;
                return this;
            }

            public Builder latency(long latency) {
                this.latency = latency;
                return this;
            }

            public Builder fromPrototype(ApiLog prototype) {
                stacktrace = prototype.stacktrace;
                status = prototype.status;
                endpoint = prototype.endpoint;
                latency = prototype.latency;
                return this;
            }

            public ApiLog build() {
                return new ApiLog(this);
            }


        }
    }


}
