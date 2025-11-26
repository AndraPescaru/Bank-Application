package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.domain.*;

import java.util.*;

public class BankReport {

    public static int getNumberOfClients(Bank bank) {
        return bank.getClients().size();
    }

    public static int getNumberOfAccounts(Bank bank) {
        int count = 0;
        for (Client c : bank.getClients()) {
            count += c.getAccounts().size();
        }
        return count;
    }

    public static SortedSet<Client> getClientsSorted(Bank bank) {
        SortedSet<Client> sorted =
                new TreeSet<>(Comparator.comparing(Client::getName));
        sorted.addAll(bank.getClients());
        return sorted;
    }

    public static double getTotalSumInAccounts(Bank bank) {
        double sum = 0;
        for (Client c : bank.getClients()) {
            for (Account a : c.getAccounts()) {
                sum += a.getBalance();
            }
        }
        return sum;
    }

    public static SortedSet<Account> getAccountsSortedBySum(Bank bank) {
        SortedSet<Account> sorted =
                new TreeSet<>(Comparator
                        .comparingDouble(Account::getBalance)
                        .thenComparingInt(Account::getId));
        for (Client c : bank.getClients()) {
            sorted.addAll(c.getAccounts());
        }
        return sorted;
    }

    public static double getBankCreditSum(Bank bank) {
        double credit = 0;
        for (Client c : bank.getClients()) {
            for (Account a : c.getAccounts()) {
                if (a instanceof CheckingAccount) {
                    CheckingAccount ca = (CheckingAccount) a;
                    credit += ca.getOverdraft();   // credit acordat = overdraft
                }
            }
        }
        return credit;
    }

    public static Map<Client, Collection<Account>> getCustomerAccounts(Bank bank) {
        Map<Client, Collection<Account>> map = new HashMap<>();
        for (Client c : bank.getClients()) {
            map.put(c, c.getAccounts());
        }
        return map;
    }

    public static Map<String, List<Client>> getClientsByCity(Bank bank) {
        Map<String, List<Client>> map = new TreeMap<>();

        for (Client c : bank.getClients()) {
            String city = c.getCity();
            map.putIfAbsent(city, new ArrayList<>());
            map.get(city).add(c);
        }

        return map;
    }
}
