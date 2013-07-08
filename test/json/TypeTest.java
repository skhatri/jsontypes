package json;

import org.junit.Assert;
import org.junit.Test;

public class TypeTest {

    @Test
    public void testSerializationAndDeserialization() throws Exception {
        SpecialTask special = new SpecialTask();
        special.setOperator("skhatri");

        String specialSerialized = JSON.stringify(special);
        Assert.assertTrue(specialSerialized.contains("SpecialTask"));

        GenericTask generic = new GenericTask();
        generic.setName("khatri");

        String genericSerialized = JSON.stringify(generic);

        Assert.assertTrue(genericSerialized.contains("GenericTask"));

        SpecialTask anotherSpecial = JSON.parse(specialSerialized, SpecialTask.class);
        Assert.assertEquals("skhatri", anotherSpecial.getOperator());

        GenericTask anotherGeneric = JSON.parse(genericSerialized, GenericTask.class);
        Assert.assertEquals("khatri", anotherGeneric.getName());
    }
}
