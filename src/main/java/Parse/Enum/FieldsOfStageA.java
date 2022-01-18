package Parse.Enum;

public enum FieldsOfStageA {
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

    FieldsOfStageA(String value) {
        this.field = value;
    }

    public String getField() {
        return field;
    }
}
