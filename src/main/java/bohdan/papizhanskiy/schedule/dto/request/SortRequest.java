package bohdan.papizhanskiy.schedule.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class SortRequest {
    private String fieldName;

    private Sort.Direction direction;
}
