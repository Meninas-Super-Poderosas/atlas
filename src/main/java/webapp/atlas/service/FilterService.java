package webapp.atlas.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import webapp.atlas.model.Filter;
import webapp.atlas.repository.FilterRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FilterService {

    private FilterRepository filterRepository;

    public Filter createFilter(@NonNull Filter filter) {
        return filterRepository.save(filter);
    }
    public List<Filter> getAllFilters(){
        return filterRepository.findAll();
    }

}
