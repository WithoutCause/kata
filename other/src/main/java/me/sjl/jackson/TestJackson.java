package me.sjl.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

public class TestJackson {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String out = mapper.writeValueAsString(SEX.MAN);
        System.out.println(out);

    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public static enum SEX {

        MAN(1, "男"), WOMEN(0, "女");

        SEX(int sex, String name) {
            this.sex = sex;
            this.name = name;
        }

        private int sex;

        private String name;

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
