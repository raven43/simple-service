package com.moocaltin.simpleservice.controller;

import com.moocaltin.simpleservice.dataaccess.model.Device;
import com.moocaltin.simpleservice.dataaccess.model.ServiceEntity;
import com.moocaltin.simpleservice.dataaccess.request.ServiceRequest;
import com.moocaltin.simpleservice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import static java.lang.String.format;

@Controller
public class MainController {

    private final CrudService crudService;

    @Autowired
    public MainController(CrudService crudService) {
        this.crudService = crudService;
    }

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.addObject("list", crudService.getServices());
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @GetMapping("/service/{id}")
    public ModelAndView service(@PathVariable Long id,
                                ModelAndView modelAndView) {

        modelAndView.addObject("item", crudService.getById(id));
        modelAndView.setViewName("/service");
        return modelAndView;
    }

    @PostMapping("/service/{id}/delete")
    public ModelAndView deleteService(@PathVariable Long id,
                                      ModelAndView modelAndView,
                                      RedirectAttributes redirectAttributes) {

        ServiceEntity deletedService = crudService.deleteService(id);
        redirectAttributes.addFlashAttribute("message",
                format("Service \'%s\' deleted", deletedService.getName()));
        modelAndView.setViewName("redirect:/list");
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.addObject("devices", Device.values());
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView addNew(ServiceRequest request,
                               @Valid ModelAndView modelAndView) {
        ServiceEntity newService = crudService.createNewService(request);
        modelAndView.setViewName("redirect:/service/" + newService.getId());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id,
                             ModelAndView modelAndView) {
        modelAndView.addObject("service", crudService.getById(id));
        modelAndView.addObject("devices", Device.values());
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView addNew(@PathVariable Long id,
                               @Valid ServiceRequest request,
                               ModelAndView modelAndView) {
        ServiceEntity updatedService = crudService.updateExistingService(id, request);
        modelAndView.setViewName("redirect:/service/" + updatedService.getId());
        return modelAndView;
    }


}
