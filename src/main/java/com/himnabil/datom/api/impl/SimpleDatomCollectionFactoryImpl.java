package com.himnabil.datom.api.impl;

import com.himnabil.datom.api.DatomAssembler;
import com.himnabil.datom.api.DatomCollection;
import com.himnabil.datom.api.DatomCollector;
import com.himnabil.datom.api.SimpleDatomCollectionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author himna
 * @since 6/26/2017.
 */
public class SimpleDatomCollectionFactoryImpl implements SimpleDatomCollectionFactory {

    private Map<Class, DatomCollector> datomCollectors ;
    private Map<Class, DatomAssembler> datomAssemblers ;

    public SimpleDatomCollectionFactoryImpl() {
        datomCollectors = new HashMap<Class, DatomCollector>();
        datomAssemblers = new HashMap<Class, DatomAssembler>();
    }

    public DatomCollection getNewInstance() {
        return new SimpleDatomCollection(datomCollectors, datomAssemblers);
    }

    public <T> void setCollector(Class<T> toCollectClass, DatomCollector<T> collector) {
        datomCollectors.put(toCollectClass, collector);
    }

    public <T> void setAssembler(Class<T> toAssembleClass, DatomAssembler<T> assembler) {
        datomAssemblers.put(toAssembleClass , assembler);
    }
}
