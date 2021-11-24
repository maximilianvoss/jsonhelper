package rocks.voss.jsonhelper.beans;

import lombok.Data;

import java.util.List;

@Data
public class GlossDivBean {
    private String title;
    private List<GlossEntryBean> GlossList;
}
