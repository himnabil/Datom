package com.himnabil.datom.spec;

import com.google.common.collect.ImmutableMap;
import com.himnabil.datom.api.DatomCollection;
import com.himnabil.datom.api.SimpleDatomCollectionFactory;
import com.himnabil.datom.api.impl.SimpleDatomCollectionFactoryImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author himna
 * @since 6/26/2017.
 */
public class SimpleUseCase {

    private final String DATOM_1 = "datom1";

    public class DataFormat_1{

        public String datom1Field1;

        public DataFormat_1() {}

        public String getDatom1Field1() {
            return datom1Field1;
        }

        public void setDatom1Field1(String datom1Field1) {
            this.datom1Field1 = datom1Field1;
        }
    }

    public class DataFormat_2{

        public String datom1Field2;

        public DataFormat_2() {}

        public DataFormat_2(String datom1Field2) {
            this.datom1Field2 = datom1Field2;
        }

        public String getDatom1Field2() {
            return datom1Field2;
        }

        public void setDatom1Field2(String datom1Field2) {
            this.datom1Field2 = datom1Field2;
        }
    }

    private SimpleDatomCollectionFactory datomCollectionFactory ;

    @Before()
    public void setUp(){
        datomCollectionFactory = new SimpleDatomCollectionFactoryImpl();
        datomCollectionFactory.setCollector(
                DataFormat_1.class,
                data -> ImmutableMap.
                        <String, Object>builder()
                        .put(DATOM_1, data.getDatom1Field1())
                        .build()
        );

        datomCollectionFactory.setAssembler(
                DataFormat_2.class,
                datomMap ->
                        new DataFormat_2((String) datomMap.get(DATOM_1))
        );
    }

    @Test
    public void useCase_001_collectClass() throws Exception {
        String datomValue = "datom1_value";

        DataFormat_1 dataFormat_1 = new DataFormat_1();
        dataFormat_1.setDatom1Field1(datomValue);

        DatomCollection datomCollection = datomCollectionFactory.getNewInstance();

        datomCollection.collect(DataFormat_1.class, dataFormat_1);
        DataFormat_2 dataFormat_2 = datomCollection.assemble(DataFormat_2.class);

        assertEquals(dataFormat_1.getDatom1Field1() , dataFormat_2.getDatom1Field2());
    }
}
