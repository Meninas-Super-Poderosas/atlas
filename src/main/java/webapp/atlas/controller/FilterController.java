package webapp.atlas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webapp.atlas.model.Filter;
import webapp.atlas.service.FilterService;

import java.util.List;

@RestController
@RequestMapping("/filters")
public class FilterController {
    @Autowired
    private FilterService filterService;

    @PostMapping
    public Filter CreateFilter(@RequestBody Filter filter){
        return filterService.createFilter(filter);
    }
    @DeleteMapping("/{id}")
    public void DeleteFilter(@PathVariable Long id){
        filterService.deleteFilter(id);
    }
    @GetMapping()
    public List<Filter> ListAllFilters() { return filterService.listAllFilters(); }

}
