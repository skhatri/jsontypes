package json;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class TypeTest {

    @Test
    public void testSerializationAndDeserialization() throws Exception {
        SpecialTask special = new SpecialTask();
        special.setOperator("skhatri");

        String specialSerialized = JSON.stringify(special);
        Assert.assertTrue(specialSerialized.contains("SpecialTask"));

        LocalDate now = new LocalDate();

        GenericTask generic = new GenericTask();
        generic.setCreatedDate(now);
        generic.setName("khatri");

        String genericSerialized = JSON.stringify(generic);

        String todayAsString = now.toString("dd/MM/yyyy");
        Assert.assertTrue(genericSerialized.contains("GenericTask"));
        Assert.assertTrue(genericSerialized.contains(todayAsString));

        SpecialTask anotherSpecial = JSON.parse(specialSerialized, SpecialTask.class);
        anotherSpecial.setCreatedDate(new LocalDate());
        Assert.assertEquals("skhatri", anotherSpecial.getOperator());


        GenericTask anotherGeneric = JSON.parse(genericSerialized, GenericTask.class);
        Assert.assertEquals("khatri", anotherGeneric.getName());

    }
}
