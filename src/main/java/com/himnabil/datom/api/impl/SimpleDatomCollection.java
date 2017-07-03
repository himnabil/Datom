package com.himnabil.datom.api.impl;

import com.himnabil.datom.api.DatomAssembler;
import com.himnabil.datom.api.DatomCollection;
import com.himnabil.datom.api.DatomCollector;

import java.util.HashMap;
import java.util.Map;

/**
 * @author himna
 * @since 6/27/2017.
 */
public class SimpleDatomCollection implements DatomCollection {

    private Map<String, Object> datomMap ;
    private Map<Class, DatomCollector> datomCollectors ;
    private Map<Class, DatomAssembler> datomAssemblers ;

    public SimpleDatomCollection(Map<Class, DatomCollector> datomCollectors, Map<Class, DatomAssembler> datomAssemblers) {
        this.datomCollectors = datomCollectors;
        this.datomAssemblers = datomAssemblers;
        this.datomMap = new HashMap<String, Object>();
    }

    public void setValue(String key, String value) {
        datomMap.put(key, value);
    }

    public void setValue(String key, int value) {
        datomMap.put(key, value);
    }

    public void setValue(String key, float value) {
        datomMap.put(key, value);
    }

    public void setValue(String key, double value) {
        datomMap.put(key, value);
    }

    public void setValue(String key, boolean value) {
        datomMap.put(key, value);
    }

    public void setValue(String key, byte value) {
        datomMap.put(key, value);
    }

    public void setValue(String key, char value) {
        datomMap.put(key, value);
    }

    public void setValue(String key, short value) {
        datomMap.put(key, value);
    }

    public <T> void setValue(String key, Class<T> valueClass, T value) {
        datomMap.put(key, value);
    }


    public <T> void collect(Class<T> toCollectClass, T toCollect) {
        DatomCollector<T> collector = datomCollectors.get(toCollectClass);
        Map<String , Object> datomCollected = collector.collect(toCollect);
        datomMap.putAll(datomCollected);
    }

    public <T> T assemble(Class<T> toAssembleClass) {
        DatomAssembler<T> assembler = datomAssemblers.get(toAssembleClass);
        return assembler.assemble(datomMap);
    }

    public <T> T getValue(String datomId, Class<T> valueClass) {
        Object valueAsObject = datomMap.get(datomId);
        return valueAsObject == null ? null : valueClass.cast(valueAsObject) ;
    }
}
