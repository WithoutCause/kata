package me.sjl.paser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Entity {


    private Bean bean;

    @NoArgsConstructor
    @Data
    public static class Bean {
        @JsonProperty("key")
        private String key;
        @JsonProperty("type")
        private String type;

        private DataBean dataBean;

        @NoArgsConstructor
        @Data
        public static class DataBean {
            @JsonProperty("key")
            private String key;
            @JsonProperty("type")
            private String type;
            @JsonProperty("match")
            private String match;
            @JsonProperty("value")
            private String value;
            @JsonProperty("operate")
            private String operate;
            @JsonProperty("matchCode")
            private String matchCode;
            @JsonProperty("valuecode")
            private String valuecode;
        }


    }
}
