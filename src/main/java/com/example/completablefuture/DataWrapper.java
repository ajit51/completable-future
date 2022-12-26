package com.example.completablefuture;

class DataWrapper {
    Integer integer;
    Double aDouble;
    String string;

    public DataWrapper(Integer integer, Double aDouble, String string) {
        this.integer = integer;
        this.aDouble = aDouble;
        this.string = string;
    }

    @Override
    public String toString() {
        return "DataWrapper{" +
                "integer=" + integer +
                ", aDouble=" + aDouble +
                ", string='" + string + '\'' +
                '}';
    }
}
