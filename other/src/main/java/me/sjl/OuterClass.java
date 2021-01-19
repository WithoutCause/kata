package me.sjl;

public class OuterClass {

    public static void main(String[] args) {
        OuterClass.InnerClass i = new OuterClass().new InnerClass();
        i.setA(18);

        System.out.println(i.getA());
    }


    public class InnerClass {

        private Integer a;

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }
    }

}
