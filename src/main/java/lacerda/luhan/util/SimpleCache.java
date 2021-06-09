package lacerda.luhan.util;

import lacerda.luhan.model.Resultado;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Component
public class SimpleCache {

    private LinkedHashMap<Long, Resultado> maps;
    private static final int MAX_SIZE = 10;

    public SimpleCache() {
        this.maps = new LinkedHashMap<Long, Resultado>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Long, Resultado> eldest) {
                return size() > MAX_SIZE;
            }
        };
    }

    public void addElementInCache(Resultado resultado) {
        if (!maps.containsValue(resultado)) {
            maps.put(resultado.getId(), resultado);
        }
    }

    public Resultado getElement(Resultado resultado) {
        return maps.get(resultado.getId());
    }

}
