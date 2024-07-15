package com.zipcodewilmington.phonebook;
import java.sql.Array;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
       phonebook = (new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        phonebook.putIfAbsent(name, new ArrayList<>());
        phonebook.get(name).add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.putIfAbsent(name, new ArrayList<>());
        phonebook.get(name).addAll(Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        //Boolean isEntryPresent = phonebook.containsKey(name);
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.getOrDefault(name, new ArrayList<>());
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String,List<String>> entry : phonebook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> reversedKeys = phonebook.keySet().stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        //return new ArrayList<>(reversedKeys);
        return new ArrayList<>(phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
