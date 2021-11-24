package rocks.voss.jsonhelper.beans;

import lombok.Data;

import java.util.List;

@Data
public class GlossDefBean {
    private String para;
    private List<String> glossSeeAlso;
}
