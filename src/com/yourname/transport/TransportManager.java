package com.yourname.transport;

import java.util.*;

public class TransportManager {

    private List<Transport> allTransports = new ArrayList<>();

    private Map<String, Transport> transportById = new HashMap<>();

    private Set<String> uniqueTransportTypes = new HashSet<>();

    private List<Repairable> repairableItems = new ArrayList<>();

    public void addTransport(Transport transport) {
        allTransports.add(transport);
        transportById.put(transport.id, transport);
        uniqueTransportTypes.add(transport.type);
        if (transport instanceof Repairable) {
            repairableItems.add((Repairable) transport);
            System.out.println("[Repairable] Добавлен в список для сервиса");
        }
        System.out.println("---");
    }

    public Transport findById(String id) {
        System.out.println("[Map] Поиск по ID '" + id + "': ");
        Transport foundByMap = transportById.get(id);

        System.out.println("[List] поиск перебором: ");
        Transport findByList = null;
        for (Transport t : allTransports) {
            if (t.id.equals(id)) {
               findByList = t;
                break;
            }
        }

        if (foundByMap != null) {
            System.out.println("НАЙДЕН - " + foundByMap.getInfo());
            if (foundByMap == findByList) {
                System.out.println("[Важно] Оба поиска вернули один и тот же объект в памяти.");
            }
        } else {
            System.out.println("НЕ НАЙДЕН");
        }
        return foundByMap;
    }

    public void printUniqueTypes() {
        System.out.println("\n=== Уникальные виды транспорта (из Set<String>) ===" );
        System.out.println(uniqueTransportTypes);
        for (String type : uniqueTransportTypes) {
            System.out.println("  - " + type);
        }
    }

    public void printAllTransports() {
        System.out.println("\n=== Весь транспорт в порядке добавления (из List<Transport>) ===");
        for (Transport t : allTransports) {
            System.out.println(t.getInfo());
        }
    }

    public void sendAllRepairableToService() {
        System.out.println("\n=== Отправка на сервис (только Repairable) ===");
        if (repairableItems.isEmpty()) {
            System.out.println("Нет ремонтируемого транспорта");
            return;
        }
        int count = 0;
        for (Repairable item : repairableItems) {
                count++;
                System.out.println(count + ". ");
                item.printRepairStatus();
                item.repair();
                System.out.println();
        }
    }
}
