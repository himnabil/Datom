package com.himnabil.datom.api;

import java.util.Map;

/**
 * @author himna
 * @since 7/3/2017.
 */
public interface DatomAssembler <T> {

    T assemble(Map<String, Object> datomMap);
}