package com.himnabil.datom.api;

/**
 * @author himna
 * @since 6/26/2017.
 */
public interface DatomCollection {

    void setValue (String key , String value);
    void setValue (String key , int value);
    void setValue (String key , float value);
    void setValue (String key , double value);
    void setValue (String key , boolean value);
    void setValue (String key , byte value);
    void setValue (String key , char value);
    void setValue (String key , short value);
    <T> void setValue (String key , Class<T> valueClass, T value);


    <T> void collect (Class<T> toCollectClass, T toCollect);
    <T> T assemble(Class<T> toAssembleClass);
    <T> T getValue (String datomId, Class<T> valueClass );


}
