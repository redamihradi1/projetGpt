package ma.mihradi.projetgpt.services;

import lombok.AllArgsConstructor;
import ma.mihradi.projetgpt.dtos.OwnerDto;
import ma.mihradi.projetgpt.entities.Owner;
import ma.mihradi.projetgpt.mappers.OwnerMapper;
import ma.mihradi.projetgpt.repos.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerService {
    OwnerRepository ownerRepository;
    OwnerMapper ownerMapper;

    public boolean addOwner(OwnerDto ownerDto){
        if(ownerMapper.fromOwnerDto(ownerDto) != null){
            Owner owner = ownerMapper.fromOwnerDto(ownerDto);
            ownerRepository.save(owner);
            return true;
        }
       return false;
    }

    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }

    public boolean deleteOwner(Long id){
        Owner owner = ownerRepository.findById(id).orElse(null);
        if (owner!=null){
            ownerRepository.delete(owner);
            return true;
        }
        return false;
    }
    public boolean editOwner(OwnerDto ownerDto,Long id){
        Owner owner = ownerRepository.findById(id).orElse(null);
        Owner ownerEdit = ownerMapper.fromOwnerDto(ownerDto);
        if (owner != null){
            owner.setAddress(ownerEdit.getAddress());
            owner.setFullName(ownerEdit.getFullName());
            owner.setEmail(ownerEdit.getEmail());
            owner.setPhoneNumber(ownerEdit.getPhoneNumber());
            owner.setPassword(ownerEdit.getPassword());
            ownerRepository.save(owner);
            return true;
        }

        return false;

    }
}
