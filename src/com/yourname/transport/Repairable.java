package com.yourname.transport;



public interface Repairable {


    void repair();

    default void printRepairStatus() {
        System.out.println("Объект готов к ремонту");
    }
}
