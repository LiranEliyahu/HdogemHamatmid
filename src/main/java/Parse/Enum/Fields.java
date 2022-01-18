package Parse.Enum;

public enum Fields {
    MDACODE("MDACODE"),
    IDNUM("IDNum"),
    IDTYPE("IDType"),
    FIRSTNAME("FirstName"),
    LASTNAME("LastName"),
    CITY("City"),
    STREET("Street"),
    BUILDINGNUMBER("BuildingNumber"),
    BARCODE("Barcode"),
    GETDATE("GetDate"),
    TAKEDATE("TakeDate"),
    RESULTDATE("ResultDate");

    private final String field;

    Fields (String value) {
        this.field = value;
    }

    public String getField() {
        return field;
    }
}
