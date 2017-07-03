package com.himnabil.datom.api;

/**
 * @author himna
 * @since 7/3/2017.
 */
public interface SimpleDatomCollectionFactory extends DatomCollectionFactory{

    <T> void setCollector ( Class<T> toCollectClass , DatomCollector<T> collector );
    <T> void setAssembler ( Class<T> toAssembleClass , DatomAssembler<T> assembler );
}
