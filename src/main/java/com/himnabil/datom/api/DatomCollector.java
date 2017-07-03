package com.himnabil.datom.api;

import java.awt.*;
import java.util.Map;

/**
 * @author himna
 * @since 7/3/2017.
 */
public interface DatomCollector<T> {

    Map<String , Object> collect (T toCollect );
}
