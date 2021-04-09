package me.sjl.mapstract.entity;

public class MapDemo {

    private String str;

    private Data data;

    public static class Data {

        private String dataName;

        private String dataNo;

        public String getDataName() {
            return dataName;
        }

        public void setDataName(String dataName) {
            this.dataName = dataName;
        }

        public String getDataNo() {
            return dataNo;
        }

        public void setDataNo(String dataNo) {
            this.dataNo = dataNo;
        }
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
