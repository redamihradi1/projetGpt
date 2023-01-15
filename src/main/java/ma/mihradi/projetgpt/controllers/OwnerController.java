package ma.mihradi.projetgpt.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.mihradi.projetgpt.dtos.OwnerDto;
import ma.mihradi.projetgpt.entities.Owner;
import ma.mihradi.projetgpt.mappers.OwnerMapper;
import ma.mihradi.projetgpt.repos.OwnerRepository;
import ma.mihradi.projetgpt.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class OwnerController {

    OwnerService ownerService ;
    OwnerMapper ownerMapper;
    OwnerRepository ownerRepository;


    @GetMapping("/formOwner")
    public String formOwner(Model model){
        model.addAttribute("ownerDto",new OwnerDto());
        return "owner/formOwner";
    }
    @PostMapping(path = "/saveOwner")
    public String saveOwner(@Valid OwnerDto ownerDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "formOwner";
        ownerService.addOwner(ownerDto);
        return "homePage";
    }
    @GetMapping("/allOwners")
    public String getAllOwners(Model model){
        model.addAttribute("listeOwner",ownerService.getAllOwners());
        return "owner/allOwners";
    }

    @GetMapping("/deleteOwner")
    public String deleteOwner(Long id){
        if (ownerService.deleteOwner(id)){
            ownerService.deleteOwner(id);
            return "redirect:/allOwners";

        }
        return "homePage";
    }

    @GetMapping("/editOwner")
    public String editOwner(Model model,Long id){
        Owner owner = ownerRepository.findById(id).orElse(null);

        model.addAttribute("ownerDto",ownerMapper.fromOwner(owner));
        model.addAttribute("idOwner",id);
        return "owner/editOwner";
    }
    @PostMapping(path = "/saveEditOwner")
    public String saveEditOwner(OwnerDto ownerDto,@PathVariable Long id, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "editOwner";
        ownerService.editOwner(ownerDto,id);
        return "redirect:/allOwners";
    }
}
