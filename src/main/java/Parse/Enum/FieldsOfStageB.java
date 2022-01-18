package Parse.Enum;

public enum FieldsOfStageB {
    IDNUM("IDNum"),
    IDTYPE("IDType"),
    FIRSTNAME("FirstName"),
    LASTNAME("LastName"),
    RESULTDATE("ResultDate"),
    BIRTHDATE("BirthDate"),
    LABCODE("LabCode"),
    STICKERNUMBER("StickerNumber"),
    RESULTTESTCORONA("ResultTestCorona"),
    VARIANT("Variant"),
    TESTTYPE("TestType");

    private final String field;

    FieldsOfStageB(String value) {
        this.field = value;
    }

    public String getField() {
        return field;
    }
}
