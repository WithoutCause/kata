package me.sjl.mapstract.entity;

public class MapTargetDemo {

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

        @Override
        public String toString() {
            return "Data{" +
                    "dataName='" + dataName + '\'' +
                    ", dataNo='" + dataNo + '\'' +
                    '}';
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

    @Override
    public String toString() {
        return "MapTargetDemo{" +
                "str='" + str + '\'' +
                ", data=" + data +
                '}';
    }
}
