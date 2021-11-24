package rocks.voss.jsonhelper.beans;

import lombok.Data;

@Data
public class GlossEntryBean {
    private String id;
    private String sortAs;
    private String glossTerm;
    private String acronym;
    private String abbrev;
    private GlossDefBean glossDef;
    private String glossSee;
}
