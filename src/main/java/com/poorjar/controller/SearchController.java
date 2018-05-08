package com.poorjar.controller;

import com.google.common.collect.Lists;
import com.poorjar.entity.SearchItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class SearchController {
    @RequestMapping("/search/{type}/{searchterm}")
    public List<SearchItem> handleRequest() {
        return getResults();
    }

    private List<SearchItem> getResults() {
        return Lists.newArrayList(new SearchItem(1, "Hello World"), new SearchItem(2, "Hello Track"));
    }
}
