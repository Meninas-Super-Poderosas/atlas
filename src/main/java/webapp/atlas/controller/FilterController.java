package webapp.atlas.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import webapp.atlas.model.Filter;
import webapp.atlas.repository.FilterRepository;
import webapp.atlas.service.FilterService;

import java.util.List;

@RestController
@RequestMapping("/filter")
public class FilterController {
    @Autowired
    public FilterService filterService;

    @PostMapping
    @Operation(summary = "Create Filter", description = "Accepts request/JSON. Add a new filter and store it in the database.")
    public Filter createFilter(Filter filter){
        return filterService.createFilter(filter);
    }

    @GetMapping
    @Operation(summary = "Get all filters.", description = "returns JSON with all filters.")
    public List<Filter> getAllFilters(){
        return filterService.getAllFilters();
    }

}
