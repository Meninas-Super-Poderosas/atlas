package webapp.atlas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.atlas.model.Filter;
import webapp.atlas.repository.FilterRepository;

import java.util.List;

@Service
public class FilterService {
    @Autowired
    private FilterRepository filterRepository;

    public Filter createFilter(Filter filter){ return filterRepository.save(filter);}
    public void deleteFilter(long id){ filterRepository.deleteById(id); }
    public List<Filter> listAllFilters(){ return filterRepository.findAll(); }

}
